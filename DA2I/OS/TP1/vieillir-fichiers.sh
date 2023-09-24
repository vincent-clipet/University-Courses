#!/bin/bash

option=0

for i in $@ ; do
	if test $i = "-v" ; then
		option=1
	fi
done

for i in $@ ; do
	if expr $option = 1 ; then
		ls -l -d $i
	else
		mv $i $i.old
	fi
done
