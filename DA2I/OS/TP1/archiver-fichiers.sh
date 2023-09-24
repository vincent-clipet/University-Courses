#!/bin/bash

#set -x
backup="0"
next="0"
directory=""

for i in $@ ; do
	if test $next = "1" ; then
		directory=$i
		break
	fi

	if test $i = "--backup-dir" ; then
		backup="1"
		next="1"
	fi
done


if test $backup = "1" ; then
	cd $directory
fi



for i in `find *.txt -maxdepth 1 -type f` ; do
	ln $i $i.archive 2> /dev/null # supprime l'erreur en cas de fichier deja existant
done
