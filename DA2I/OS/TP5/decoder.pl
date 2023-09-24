#!/usr/bin/perl

@alphabet = (" ", a..z);

foreach $number (@ARGV)
{
	if ($number >= 0 && $number <= 26)
	{
		print "@alphabet[$number]";
	}
	else
	{
		print ".";
	}
}

print "\n"
