#!/usr/bin/perl


###########
# METHODS #
###########

sub cleanLine
{
	my $string = $_[0];
	$string =~ s/[,; \t]/ /g;
	$string =~ s/ +/ /g;
	
	return split(/ /, $string);
}




########
# MAIN #
########


# Fichier de sortie

print "Nom du fichier de sortie ? ";
$outputFilename = <STDIN>;

while (-e $outputFilename)
{	
	print "Ecraser le fichier '$outputFilename' (o/n) ? ";
	$answer = <STDIN>;
	chomp $answer;
	
	if ($answer eq "n")
	{
		print "Nom du fichier de sortie ? ";
		$outputFilename = <STDIN>;
	}
	else
	{
		unlink $outputFilename;
	};
}

open(OUT, ">$outputFilename") or die $?;



# Re-indexation

%hash = ();
@lines = ();

foreach $filename (@ARGV)
{
	open(IN, "<$filename") or die $?;
	
	while (<IN>)
	{
		$line = $_ ;
		@cut = cleanLine($line);
		$num = $cut[0]; chomp $num;
		$nom = $cut[1]; chomp $nom;
		$hash{ $num } = $hash{ $num } + 1;
		
		push(@lines, $num.".".$hash{$num}."\t".uc($nom)."\n");
	}
	
	close(IN);
}



# Sort & write to file

@lines = sort(@lines);

foreach $line (@lines)
{
	print (OUT $line);
}

close (OUT);
