apt-get install tree rsync
apt-get install slapd ldap-utils
# Mot de passe LDAP 'admin' : root
ifconfig eth0 192.168.194.10 netmask 255.255.255.0 up
# edit /etc/network/interfaces :
# iface eth0 inet static address 192.168.194.10 netmask 255.255.255.0
