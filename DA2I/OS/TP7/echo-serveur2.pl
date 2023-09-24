#!/usr/bin/perl

########
# MAIN #
########

use Socket;

socket (SERVEUR, PF_INET, SOCK_STREAM, getprotobyname('tcp'));
setsockopt (SERVEUR, SOL_SOCKET, SO_REUSEADDR, 1);
$mon_adresse = sockaddr_in ("7777", INADDR_ANY);

bind(SERVEUR, $mon_adresse) || die ("bind");
listen (SERVEUR, SOMAXCONN) || die ("listen");


while (accept (CLIENT, SERVEUR))
{
	$forkpid = fork();
	
	if ($forkpid != 0) # Pere
	{
		close (CLIENT);
		next;
	}
	else # Fils
	{
		select (CLIENT);
		$bool = 0;

		while ($bool == 0)
		{
			$line = <CLIENT>;
			print(CLIENT $line);
			autoflush CLIENT 1;
	
			$bool = 1 if ($line eq "\n");
		}

		close (CLIENT);
	}
}

close (SERVEUR);
