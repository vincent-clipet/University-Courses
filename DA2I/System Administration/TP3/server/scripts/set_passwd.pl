#!/usr/bin/perl


open(FILE, "<logins.txt");
@_usersToAdd = <FILE>;
close(FILE);

my $usersNb = @_usersToAdd;

for (my $i = 0; $i < $usersNb; $i++)
{
        $login = $_usersToAdd[$i];
        chomp($login);
        #$password = crypt("$login","$login");  
        #system("ldapsetpasswd $login $password");
        system("ldapsetpasswd $login $login");

}

