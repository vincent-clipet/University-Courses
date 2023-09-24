#!/bin/bash

#set -x

read txt

while [[ $txt != "FINI" ]]
do
	eval "echo $"$txt
	read txt
done
