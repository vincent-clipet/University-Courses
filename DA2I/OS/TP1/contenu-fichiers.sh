#!/bin/bash

for i in $@
do
	echo $i
	echo "====================="
	cat $i
done
