#!/bin/bash

for i in * ; do
	if cd $i 2> /dev/null ; then
		cd ..
	else
		echo `wc -c $i`
	fi
done
