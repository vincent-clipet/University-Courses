#!/bin/bash


###########
# METHODS #
###########



########
# MAIN #
########

sed	-e "/--DEBUT_REMPLACEMENT--/ r $1" \
	-e "/--DEBUT_REMPLACEMENT--/,/--FIN_REMPLACEMENT--/d"
