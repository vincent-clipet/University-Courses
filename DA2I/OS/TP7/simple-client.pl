#!/usr/bin/perl


###########
# METHODS #
###########









########
# MAIN #
########


use Socket;

socket (SERVEUR, PF_INET, SOCK_STREAM, getprotobyname('tcp'));
$adresse = inet_aton ("localhost") || die ("inet_aton");
$adresse_complete = sockaddr_in("11111", $adresse) || die ("sockaddr_in");

connect (SERVEUR, $adresse_complete) || die ("connect");
print "Connection established\n-------------------------\n";

while (<SERVEUR>)
{
	print "> ", $_;
}

close (SERVEUR);

