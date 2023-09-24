#!/bin/bash

###########
# METHODS #
###########

deleteTaggedFile()				# $1 : link, $2 : tag
{
	if [[ -f ~/tags/$2/$1 ]] ; then
		rm ~/tags/$2/$1
	fi
}

isTag()							# $1 : tag
{
	if [[ -d ~/tags/$1 ]] ; then
		return 0
	else
		return 1
	fi
}

isFile()						# $1 : file
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


# OLD -------------
tag=$1 ; shift

if [[ -d ~/tags/$tag ]] ; then

	for i in "$@" ; do
		deleteTaggedFile $i $tag
	done
	
fi
# ------------------




listTags=""
listFiles=""

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

for i in $listTags ; do
	for param in "$@" ; do
		if isFile $param ; then
			deleteTaggedFile $param $i
		fi
	done
done


