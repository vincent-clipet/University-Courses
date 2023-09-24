#!/bin/bash

set -x

read -n 3 txt

while [[ $txt != "oui" && $txt != "non" ]]
do
	read -n 3 txt
done
