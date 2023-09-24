#!/usr/bin/perl

open(FILE, "<logins.txt");
@_usersToAdd = <FILE>;
close(FILE);


my $usersNb = @_usersToAdd;

for (my $i = 0; $i < $usersNb; $i++)
{
    $user = $_usersToAdd[$i];
    system("ldapdelete -D cn=admin,dc=da2i,dc=org -w root uid=$user,ou=people,dc=da2i,dc=org");
}
