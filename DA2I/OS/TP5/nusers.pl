#!/usr/bin/perl

$nb = `who | cut -d " " -f 1 | uniq | wc -l`;
print "Utilisateurs connectés : " . $nb;
