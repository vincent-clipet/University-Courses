#!/usr/bin/perl

use File::Copy qw(copy);



########
# MAIN #
########

@list = glob('*.txt');

foreach $file (@list)
{
	chomp $file;
	copy $file, $file . ".archive";
}
