#!/usr/bin/perl

foreach $file (@ARGV)
{
	print "$file \n";
	open(FILE1, $file);
	
	while (<FILE1>)
	{
		print $_;
	}

	close(FILE1);
}
