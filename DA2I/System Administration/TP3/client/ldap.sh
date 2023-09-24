# https://www.digitalocean.com/community/articles/how-to-authenticate-client-computers-using-ldap-on-an-ubuntu-12-04-vps



sudo apt-get update
sudo apt-get install libpam-ldap nscd


ldap://serveur.da2i.org
dc=da2i,dc=org
3
No
Yes
cn=admin,dc=da2i,dc=org
admin




nano /etc/nsswitch.conf
# passwd: ldap compat group: ldap compat shadow: ldap compat

nano /etc/pam.d/common-session
session required pam_mkhomedir.so skel=/etc/skel umask=0022
sudo /etc/init.d/nscd restart




ssh LDAP_user@LDAP_client_IP_Address
pwd
