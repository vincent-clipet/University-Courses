#!/bin/bash

###########
# methods #
###########


createDir ()
{
	if [[ ! -d $path ]] ; then
		mkdir $path
	fi
}

addToGarbage ()		# $1 : fichier
{
	if [[ ! -f $1 ]] ; then
		echo "Fichier inexistant"
		return;
	fi

	newName=$1
	dir=`dirname "$PWD/$1"`
	file=`basename "$PWD/$1"`

	if [[ ! -f $path/$1 ]] ; then
		mv $1 $path/
	else
		val=1
		
		while [[ -f $path/$1\#$val ]] ; do
			((val++))
		done
		
		newName=$1\#$val
		mv $1 $path/$newName
	fi
	
	echo $file > $path/.$newName # nom du fichier d'origine
	echo $dir >> $path/.$newName # nom du dossier d'origine
}

restoreFromGarbage()		# $1 : fichier a restaurer
{
	if [[ ! -f $path/$1 ]] ; then
		echo "Fichier inexistant"
		return;
	fi
	
	file=`cat $path/.$1 | head -1`
	dir=`cat $path/.$1 | tail -1`
	
	mv "$path/$1" "$dir/$file"
	rm $path/.$1
}



########
# main #
########

path=~/poubelle
createDir $path

if [[ $1 == "-l" ]] ; then
	ls $path

elif [[ $1 == "-v" ]] ; then
	rm -r $path/*
	
elif [[ $1 == "-s" ]] ; then
	mv $path/$2 $3
	
elif [[ $1 == "-r" ]] ; then
	restoreFromGarbage $2
	
else
	for i in $@ ; do
		addToGarbage $i
	done
fi
