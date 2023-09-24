#!/usr/bin/perl


########
# MAIN #
########

use POSIX ":sys_wait_h";

$nb = @ARGV[0];
@pid = ();
$pid = $$;


print "PPID : $$\n";

for ($i = 0; $i < $nb; $i++)
{
	$forkpid = fork;

	if ($forkpid != 0) {
		print "Created sub-process with ID : ", $forkpid, "\n";
		@pid[$i] = $forkpid;
	}
	else { # ($forkpid == 0)
		exec("perl rien");
	}
}

for ($j = 0; $j < $nb; $j++)
{
	while (($n = waitpid(@pid[$j], &WNOHANG)) == 0) {
		#print "toujours pas mort\n";
	}

	if ($n == -1) {
		print "Error while waiting \n"; exit 1;
	}
	else {
		print "Process $n joined\n";
	}
}
