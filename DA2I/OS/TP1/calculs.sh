#!/bin/bash

read -p "nombres ? : " nb1 nb2

while [ ! nb1 = "." ] && [ ! nb2 = "." ] ; do

	sum=`expr $nb1 + $nb2`
	diff=`expr $nb1 - $nb2`
	prod=`expr $nb1 \* $nb2`
	div=`expr $nb1 / $nb2`
	echo "$nb1 + $nb2 = $sum"
	echo "$nb1 - $nb2 = $diff"
	echo "$nb1 * $nb2 = $prod"
	echo "$nb1 / $nb2 = $div"

	read -p "nombres ? : " nb1 nb2
done

echo $sum
