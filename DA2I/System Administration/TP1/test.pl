#!/usr/bin/perl
require 'config.pl';




open(FILE, "<tomodify.txt") or die("WTF");
@_usersToEdit = <FILE>;
close(FILE);

my $usersNb = @_usersToEdit;

for (my $i = 0; $i < $usersNb; $i++)
{
	chomp($_usersToEdit[$i]);
	($login, $newPassword, $newHomeDir, $newShellType) = split(';', $_usersToEdit[$i]);
	print "login: $login\n", "newPassword: $newPassword\n", "newHomeDir: $newHomeDir\n", "newShellType: $newShellType\n";
	print "============================\n";
	
	if ($newPassword eq "")
	{
		print "------------------\n";
	}
}
