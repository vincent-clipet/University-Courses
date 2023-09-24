#!/usr/bin/perl

########
# MAIN #
########

%hash = ();

while (<STDIN>)
{
	chomp $_;
	$hash{ $_ } = $hash{ $_ } + 1;
}

foreach $key (keys(%hash))
{
	print "$key : $hash{$key} occurence(s)\n";
}
