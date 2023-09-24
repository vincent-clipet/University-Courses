#!/usr/bin/perl


###########
# METHODS #
###########









########
# MAIN #
########

use Socket;

$nb = @ARGV[0];

socket (SERVEUR, PF_INET, SOCK_STREAM, getprotobyname('tcp'));
setsockopt (SERVEUR, SOL_SOCKET, SO_REUSEADDR, 1);
$mon_adresse = sockaddr_in ("11111", INADDR_ANY);

bind(SERVEUR, $mon_adresse) || die ("bind");
listen (SERVEUR, SOMAXCONN) || die ("listen");

while (1)
{
	accept (CLIENT, SERVEUR) || die ("accept");
	select (CLIENT);

	foreach $i (1..$nb)
	{
		print "Bonjour !\n";
	}

	close (CLIENT);
}
close (SERVEUR);

