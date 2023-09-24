#!/usr/bin/perl

########
# MAIN #
########

foreach $arg (@ARGV)
{
	open(FILE,"<$arg") or die $?;
	
	$count = 1;	
	foreach $line (<FILE>)
	{
		chomp $line;
		print $count, "\t", $line, "\n";
		$count++;
	}
	
	close(FILE);
}
