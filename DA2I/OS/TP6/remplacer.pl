#!/usr/bin/perl

########
# MAIN #
########

#$input = $ARGV[0];
#$output = $ARGV[1];
#$inputPattern = $ARGV[2];
#$outputPattern = $ARGV[3];

$input = <STDIN>; chomp $input;
$output = <STDIN>; chomp $output;
$inputPattern = <STDIN>; chomp $inputPattern;
$outputPattern = <STDIN>; chomp $outputPattern;


if (-e $output)
{
	print "Ecraser le fichier '$output' (o/n) ? ";
	$answer = <STDIN>;
	chomp $answer;
	
	($answer eq "n") or die;
	
	unlink $output;
}

open(INPUTFILE,"<$input") or die $?;
open(OUTPUTFILE,">$output") or die $?;

foreach $line (<INPUTFILE>)
{
	$line =~ s/$inputPattern/$outputPattern/g;
	print(OUTPUTFILE $line);
}

close(INPUTFILE);
close(OUTPUTFILE);
