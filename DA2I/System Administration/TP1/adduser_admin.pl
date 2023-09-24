#!/usr/bin/perl
require 'config.pl';



sub printHelp
{
	print "\nOptions :\n=======\n\n";
	print "-n | --dry-run\n  --> pre-visualize result of command, without executing it\n\n";
	print "-m | --manual-edit\n  --> Files '/etc/passwd', '/etc/shadow' & '/etc/group' will be modified 'manually'\n\n";
	print "-f | --input-file\n  --> File containing names, needed to create all accounts\n\n";
	print "-o | --output-file\n  --> Log file containing all created accounts information\n\n";
	print "-s | --shell-type\n  --> Define shell to use when the user logs in\n\n";
	exit 0;
}

sub getNextUserLogin
{
	my $userName = $_[0];
	my $userSurname = $_[1];
	my $firstLetter = substr($userSurname, 0, 1);
	my $login = $userName . $firstLetter;
	my $outputLogin = $login;
	
	my $idCommandResult = `id $outputLogin 2>&1`;
	my $counter = 1;
	
	while ($idCommandResult =~ /^uid=/)
	{
		$outputLogin = $login . $counter;
		$idCommandResult = `id $outputLogin 2>&1`;
		$counter++;
	}
	
	return $outputLogin;
}

sub getNextUserHome
{
	my $login2 = $_[0];
	my $directory = $_baseDir;
	
	my $outputLogin = $login2;
	my $counter = 1;
	
	while (-d "$directory/$outputLogin")
	{
		$outputLogin = $login2 . $counter;
		$counter++;
	}
	
	return $outputLogin;
}

sub checkGroupExists
{
	my $returnedLines = `cat /etc/group | cut -d ':' -f 3 2>&1`;
	print "------ $returnedLines \n";
	if ($returnedLines =~ /^$_groupId$/)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

sub cleanName
{
	my $name = $_[0];
	chomp($name);
	
	$name = lc($name);
	
	$name =~ s/[àâä]/a/g;
	$name =~ s/[ûùü]/u/g;
	$name =~ s/[êèéë]/e/g;
	$name =~ s/[ç]/c/g;
	$name =~ s/[ôö]/o/g;
	$name =~ s/[îï]/i/g;
	$name =~ s/\-//g;
	$name =~ s/\'//g;
	$name =~ s/ //g;
	
	return $name;
}

sub getNextFreeUID
{
	my $ret = `awk -F: '$3>500&&$3<20000{print $3}' /etc/passwd | sort -n | tail -1 | awk '{print $1+1}'`;
	return $ret;
}




########
# MAIN #
########

$_dryrun = 0;
$_manual = 0;
$_inputFile;
$_shellType = "/bin/bash";
$_outputFile = "adduser.log";
@_usersToAdd;
$_argsSize = @ARGV;

printHelp() if ($_argsSize == 0);

for (my $i = 0; $i < $_argsSize; $i++)
{
	printHelp() if ($ARGV[0] eq "-h" || $ARGV[$i] eq "?" || $ARGV[$i] eq "--help");
	$_dryrun = 1 if ($ARGV[$i] eq "-n" || $ARGV[$i] eq "--dry-run");
	$_manual = 1 if ($ARGV[$i] eq "-m" || $ARGV[$i] eq "--manual-edit");
	$_inputFile = $ARGV[$i+1] if ($ARGV[$i] eq "-f" || $ARGV[$i] eq "--input-file");
	$_shellType = $ARGV[$i+1] if ($ARGV[$i] eq "-s" || $ARGV[$i] eq "--shell-type");
	$_outputFile = $ARGV[$i+1] if ($ARGV[$i] eq "-o" || $ARGV[$i] eq "--output-file");
}

if (defined($_inputFile))
{
	if (-e $_inputFile)
	{
		open(FILE, "<$_inputFile");
		@_usersToAdd = <FILE>;
		close(FILE);
	}
	else
	{
		print "file '$_inputFile' does not exist\n";
		exit 1;
	}
}
else
{
	print "no input file specified\n";
}



my $usersNb = @_usersToAdd;
open(FILE, ">>$_outputFile") || die "unknown error";

for (my $i = 0; $i < $usersNb; $i++)
{
	$_usersToAdd[$i] = cleanName($_usersToAdd[$i]);
	
	my @splitNameSurname = split(';', $_usersToAdd[$i]);
	my $login = getNextUserLogin($splitNameSurname[0], $splitNameSurname[1]);
	my $homeDir = $_baseDir . "/" . getNextUserHome($login);
	my $password = crypt("$login","$login"."azerty");
	my $shell = $_shellType;
	my $timestamp = time;
	
	print("$timestamp;$login;$password;$homeDir;$shell\n");
	
	if ($_dryrun != 1)
	{
		# DEBIAN
		if ($_manual != 1)
		{
			print(FILE "$timestamp;$login;$password;$homeDir;$shell\n");
			`useradd -d $homeDir -p $password -s $shell $login 2>&1`;
			mkdir $homeDir;
		}
		# MANUAL
		else
		{
			my $nextUid = getNextFreeUID();
		}
	}
}

close(FILE);


