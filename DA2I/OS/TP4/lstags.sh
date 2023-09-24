#!/bin/bash

###########
# METHODS #
###########





########
# MAIN #
########

# find ~/ -inum $1 | grep -v ~/tags/ | head -1

inodes=""

for i in "$@" ; do
	
	if [[ -d ~/tags/$i ]] ; then
		
		list=`ls ~/tags/$i`
		
		for j in $list ; do
			inode=`ls -i ~/tags/$i/$j | cut -d ' ' -f 1`
			inodes=$inodes" "$inode
		done
	fi
done

for i in `echo $inodes | tr " " "\n" | sort | uniq` ; do
	find ~/ -inum $i | grep -v ~/tags/ | head -1
done
