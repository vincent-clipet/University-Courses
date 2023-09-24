# https://www.digitalocean.com/community/articles/how-to-install-and-configure-a-basic-ldap-server-on-an-ubuntu-12-04-vps

# https://www.digitalocean.com/community/articles/how-to-authenticate-client-computers-using-ldap-on-an-ubuntu-12-04-vps


apt-get install slapd ldap-utils
dpkg-reconfigure slapd
#da2i.org
#da2i.org
#admin
#HDB
#No
#Yes
#No



apt-get install phpldapadmin
nano /etc/phpldapadmin/config.php

# $servers->setValue('server','host','192.168.194.10');
# $servers->setValue('server','base',array('dc=da2i,dc=org'));
# $servers->setValue('login','bind_id','cn=admin,dc=da2i,dc=org');
# $config->custom->appearance['hide_template_warning'] = true;


ldapsearch -xLLL -b "dc=da2i,dc=org" uid=exampleuser sn givenName cn








ldappasswd -x -D cn=admin,dc=da2i,dc=org -w root -s testuser uid=testuser,ou=people,dc=da2i,dc=org

ldapadd -c -x -D cn=admin,dc=da2i,dc=org -W -f allusers.ldif

ldapsearch -x -H ldap://serveur.da2i.org/ -b dc=da2i,dc=org uid=testuser

