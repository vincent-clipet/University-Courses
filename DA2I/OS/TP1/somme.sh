#!/bin/bash

sum=0

for i in $@ ; do
	sum=`expr $sum + $i`
	#let "sum += $i"
done

echo $sum
