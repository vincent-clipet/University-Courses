#!/usr/bin/perl

########
# MAIN #
########

@list = glob('./*');

foreach $line (@list)
{
	#$size = (-s $line);
	print (-s $line),"\t",$line,"\n";
}
