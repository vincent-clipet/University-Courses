#!/usr/bin/perl

$size = @ARGV;
if ($size != 1) { exit 1; }

$next = @ARGV[0];
while ($next != 1)
{
	print $next . "\n";
	#($next % 2 == 0) ? ($next /= 2) : ($next = $next * 3 + 1); # WTF
	$next = ($next % 2 == 0) ? $next / 2 : $next * 3 + 1;
}

