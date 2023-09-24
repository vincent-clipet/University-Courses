#!/usr/bin/perl 

########
# MAIN #
########


use Socket;

$hostname = @ARGV[0];
$file = @ARGV[1];

socket (SERVEUR, PF_INET, SOCK_STREAM, getprotobyname('tcp'));
$adresse = inet_aton ($hostname) || die ("inet_aton");
$adresse_complete = sockaddr_in("80", $adresse) || die ("sockaddr_in");

connect (SERVEUR, $adresse_complete) || die ("connect");
print "Connection established\n-------------------------\n";

$EOL = "\r\n";
$req = "GET $file HTTP/1.1".$EOL."Host: $hostname".$EOL.$EOL;

autoflush SERVEUR 1;
print (SERVEUR $req);

while (<SERVEUR>)
{
	print "> ", $_;
}

close (SERVEUR);
