#!/bin/bash

########
# MAIN #
########

liste_login=`getent group | grep info-sil | cut -d ":" -f 4 | tr "," " "`


for s in $liste_login ; do

	ligne=`getent passwd | grep $s`
	prenom_nom=`echo $ligne | cut -d ":" -f 5`
	email=`echo $prenom_nom | tr " " "." | tr [[:upper:]] [[:lower:]]``echo "@univ-lille1.fr"`
	echo $prenom_nom $email
done
