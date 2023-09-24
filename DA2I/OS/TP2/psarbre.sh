#!/bin/bash

###########
# methods #
###########

getPPID ()					# $1 : PID
{
	if [[ -d /proc/$1/ ]] ; then
		cat /proc/$1/stat | cut -d " " -f 4
	else
		echo "Unknown PID"
	fi
}

hasChildren ()				# $1 : pid
{
	for i in `ls /proc/ | grep '^[0-9]*$'` ; do

       	ppid=`getPPID $i`

		if [[ $ppid = $1 ]] ; then
			echo 0
			return
		fi

	done

	echo 1
}

getChildren ()				# $1 : PID
{
	listChildren=""

	for i in `ls /proc/ | grep '^[0-9]*$'` ; do

       	ppid=`getPPID $i`

		if [[ $ppid = $1 ]] ; then
			listChildren=$listChildren" "$i
			#echo $listChildren
		fi

	done

	echo $listChildren
}

printProcess ()				# $1 : pid, $2 : level
{
	cmdline=`cat /proc/$1/cmdline`
	toAdd=""
	lvl=$2

	while [[ $lvl -gt 0 ]] ; do
		toAdd=$toAdd" | "
		((lvl--))
	done

	toAdd=$toAdd" |--"

	echo "$toAdd$1 $cmdline"
}

printTree ()				# $1 : pid, $2 : lvl
{
	children=`getChildren $1`
	printProcess $1 $2

	for child in $children ; do

		nextLevel=`expr $2 + 1`

		if [[ `hasChildren $child` = 0 ]] ; then
			printTree $child $nextLevel
		else
			printProcess $child $nextLevel
		fi

	done
}


########
# main #
########


#range=`ls /proc/ | grep '^[0-9]*$'`
range=0

for pid in $range ; do

	printTree $pid 0

done


