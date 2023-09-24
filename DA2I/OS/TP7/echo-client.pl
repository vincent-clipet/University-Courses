#!/usr/bin/perl

########
# MAIN #
########

use Socket;

socket (SERVEUR, PF_INET, SOCK_STREAM, getprotobyname('tcp'));
$adresse = inet_aton ("localhost") || die ("inet_aton");
$adresse_complete = sockaddr_in("7777", $adresse) || die ("sockaddr_in");

connect (SERVEUR, $adresse_complete) || die ("connect");
print "Connection established\n-------------------------\n";

while (1)
{
	$text = <STDIN>;
	print(SERVEUR $text);
	autoflush SERVEUR 1;
	$answer = <SERVEUR>;
	print "$answer \n";
}

close (SERVEUR);


