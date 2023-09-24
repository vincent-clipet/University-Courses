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

open(F,">f") or die $?;
open(F1,">f1") or die $?;
open(F1,">f2") or die $?;

$num = 1;

while (<STDIN>)
{
	$line = $_ ;
	@cut = cleanLine($line);
	$nom = $cut[0]; chomp $nom;
	$prenom = $cut[1]; chomp $prenom;
	$annee = $cut[2]; chomp $annee;
	$option = $cut[3]; chomp $option;
	
	print (F "$num;$nom;$prenom\n");
	
	if ($annee eq "1")
	{
		print (F1 "$num;$option\n");
	}
	elsif ($annee eq "2")
	{
		print (F2 "$num;$option\n");
	}
	
	$num++;
}

close(F);
close(F1);
close(F2);
