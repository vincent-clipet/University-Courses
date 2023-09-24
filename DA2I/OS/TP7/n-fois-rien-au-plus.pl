#!/usr/bin/perl


###########
# METHODS #
###########

sub freeSpace
{		
	while (1)
	{
		for ($i = 0; $i < $max; $i++)
		{
			$n = waitpid($proc[$i], &WNOHANG);
					
			if ($n > 0)
			{
				$count--;
				$ret = $proc[$i];
				undef($proc[$i]);
				$last = $i;
				return $ret;
			}
		}
	}
}






########
# MAIN #
########

use POSIX ":sys_wait_h";

$max = $ARGV[0];
@proc = ();
$count = 0;
$last = 0;

while (<STDIN>)
{	
	if ($count >= $max) # Pool de processus vide
	{
		$freeSpace = freeSpace();
		print "Sub-process with ID $freeSpace ended", "\n";
	}
	
	$forkpid = fork;
	
	if ($forkpid != 0) {
		$proc[$last] = $forkpid;
		$last++;
		$count++;
		print "Created sub-process with ID : ", $forkpid, "\n";
	}
	else { # ($forkpid == 0)
		exec("perl rien");
	}
}



