#!/bin/bash

#set -x

function printTree ()			# $1 : directory to print, $2 : level
{
	for i in `ls -1 $1` ; do

		txt=`getSpacesFromLevel $2`

		b=`echo $1$i`

		if [[ -d $b ]] ; then
			a=`echo $1`$i\/
			echo "$txt ├──$a"
			newLevel=`expr $2 + 1`
			printTree $a $newLevel
                elif [[ -f $b ]] ; then
                        echo "$txt ├──$i"
		elif [[ ! -e $1 ]] ; then
                	true;
		else
			echo "erreur"
		fi
	done
}

function getSpacesFromLevel ()		# $1 : level
{
	txt="    "
	nb=$1

	while (( nb != 0 )) ; do
		((nb--))
		txt=$txt' │'
	done

	echo $txt
}



printTree $1 0


