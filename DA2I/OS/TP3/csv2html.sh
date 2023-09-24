#!/bin/bash

########
# MAIN #
########

sep=';'
sorter=""
lines=""
search=""

read first_line

while [[ ! -z $1 ]] ; do
	if [[ $1 == "-d" ]] ; then
        sep="$2"
	elif [[ $1 == "-s" ]] ; then
		sorter="sort -k $2"
	elif [[ $1 == "-S" ]] ; then
		lines=`echo $first_line | tr "$sep" " "`
		search="$2"
	fi
	
	shift 2
done


if [[ ! -z $lines ]] ; then
	count=1
	echo $search
	for i in $lines ; do

		if [[ $i = $search ]] ; then
			sorter="sort -k $count"
			break;
		fi

		((count++))
	done
fi


if [[ ! -z $sorter ]] ; then
	sorter="$sorter -t \"$sep\""
fi


echo '<html lang="fr"><head>  <meta charset="utf-8">'
echo "$out<table border='1'>"

first_line="<thead><tr><th>"`echo $first_line | sed -e "s!$sep!</th><th>!g"`
echo "$first_line"

eval "$sorter" | sed -e 's/^/<tr><td>/' \
	-e 's!$!</td></tr>!' \
	-e "s!$sep!</td><td>!g"

echo "$out</table></html>"


