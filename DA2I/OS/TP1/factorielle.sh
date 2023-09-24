#!/bin/bash

if expr $# != 1 ; then
	exit
fi


result=$1
var=$1

while expr $var != 1 ; do
	var=`expr $var - 1`
	result=`expr $result \* $var`
done

echo $result
