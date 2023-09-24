#!/usr/bin/perl

$somme = 0;

foreach $i (@ARGV)
{
	$somme += $i;
}

print $somme . "\n";

