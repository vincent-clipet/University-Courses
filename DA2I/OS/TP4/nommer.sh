#!/bin/bash

###########
# METHODS #
###########





########
# MAIN #
########

nb=`find ~/tags/ -inum $1 | wc -l`

if [[ $nb -ge 1 ]] ; then
	find ~/ -inum $1 | grep -v ~/tags/ | head -1
fi
