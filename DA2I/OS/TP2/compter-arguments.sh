#!/bin/bash

#set -x

count=1

for i in $* ; do
	echo L\'argument $count est $i
	((count++))
	shift 1
done
