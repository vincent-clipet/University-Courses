#!/usr/bin/perl
require 'config.pl';



sub printHelp
{
	print "\nOptions :\n=======\n\n";
	print "-n | --dry-run\n  --> pre-visualize result of command, without executing it\n\n";
	print "-m | --manual-edit\n  --> Files '/etc/passwd', '/etc/shadow' & '/etc/group' will be modified 'manually'\n\n";
	print "-f | --input-file\n  --> File containing login to delete\n\n";
	print "-o | --output-file\n  --> Log file containing all deleted accounts information\n\n";
	exit 0;
}





########
# MAIN #
########

$_dryrun = 0;
$_manual = 0;
$_inputFile;
$_outputFile = "deluser.log";
@_usersToDel;
$_argsSize = @ARGV;

printHelp() if ($_argsSize == 0);

for (my $i = 0; $i < $_argsSize; $i++)
{
	printHelp() if ($ARGV[0] eq "-h" || $ARGV[$i] eq "?" || $ARGV[$i] eq "--help");
	$_dryrun = 1 if ($ARGV[$i] eq "-n" || $ARGV[$i] eq "--dry-run");
	$_manual = 1 if ($ARGV[$i] eq "-m" || $ARGV[$i] eq "--manual-edit");
	$_inputFile = $ARGV[$i+1] if ($ARGV[$i] eq "-f" || $ARGV[$i] eq "--input-file");
	$_outputFile = $ARGV[$i+1] if ($ARGV[$i] eq "-o" || $ARGV[$i] eq "--output-file");
}

if (defined($_inputFile))
{
	if (-e $_inputFile)
	{
		open(FILE, "<$_inputFile");
		@_usersToDel = <FILE>;
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



my $usersNb = @_usersToDel;
open(FILE, ">>$_outputFile") || die "unknown error";

for (my $i = 0; $i < $usersNb; $i++)
{
	$login = $_usersToDel[$i];
	chomp($login);
	
	# DEBIAN
	if ($_manual != 1)
	{
		my $idCommandResult = `id $login 2>&1`;
	
		if ($idCommandResult =~ /^uid=/)
		{
			my $homeDir = $_baseDir . "/" . $login;
			my $timestamp = time;
	
			print("$timestamp;$login;$homeDir\n");
	
			if ($_dryrun != 1)
			{
				if (-d $homeDir)
				{
					`rm -rf $homeDir`;
				}
		
				`deluser $login`;
				print(FILE "$timestamp;$login;$homeDir\n");
			}
		}
	}
	# MANUAL
	else
	{
		#TODO
	}
	
	
}

close(FILE);

