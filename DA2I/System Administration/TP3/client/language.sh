#
# LANGUAGE
#

dpkg-reconfigure locales
# en_US.UTF-8
# nl_NL.UTF-8

nano /etc/default/locale




#
# AUTO-COMPLETE
#

nano /etc/bash_completion

if [ -f /etc/bash_completion ]; then
	. /etc/bash_completion
fi





#
# SOFT
#

apt-get install icedove
