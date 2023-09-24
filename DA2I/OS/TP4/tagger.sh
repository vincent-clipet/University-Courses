#!/bin/bash

###########
# METHODS #
###########

createTagsFolder()
{
	if [[ ! -e ~/tags/ ]] ; then
		mkdir ~/tags/
	fi
}

createTag()				# $1 : tag
{
	if [[ ! -e ~/tags/$1 ]] ; then
		mkdir ~/tags/$1
	fi
}

tagFile()				# $1 : file, $2 : tag
{
	if [[ -f $1 ]] ; then
		if [[ -f ~/tags/$2/$1 ]] ; then
			rm ~/tags/$2/$1
		fi
		
		ln $1 ~/tags/$2/$1
	fi
}

isTag()					# $1 : tag
{
	if [[ -d ~/tags/$1 ]] ; then
		return 0
	else
		return 1
	fi
}

isFile()					# $1 : file
{
	if [[ -f $1 ]] ; then
		return 0
	else
		return 1
	fi
}




########
# MAIN #
########

listTags=""
listFiles=""

createTagsFolder
createTag $tag



for param in "$@" ; do
	if isTag $param ; then
		listTags=$listTags" "$param
		shift
	else
		if isFile $param ; then
			break
		else
			createTag $param
			listTags=$listTags" "$param
			shift
		fi
	fi
done

for param in "$@" ; do
	if isFile $param ; then
		listFiles=$listFiles" "$param
	fi
	
	shift
done


for i in $listTags ; do
	for j in $listFiles ; do
		tagFile $j $i
	done
done



