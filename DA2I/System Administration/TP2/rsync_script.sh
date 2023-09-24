#!/bin/sh



# DISMOUNT
umount /srv/backup/
mount -o rw /dev/sdb1 /srv/backup/



# RSYNC
DIR_TARGET=/srv/backup
DIR_SOURCE=/home/users
IP_SOURCE=192.168.194.25
REMOTE_USER=root

rm -Rf $DIR_TARGET/2
mv $DIR_TARGET/1 $DIR_TARGET/2
mv $DIR_TARGET/0 $DIR_TARGET/1
mkdir -p $DIR_TARGET/0/$DIR_SOURCE

rsync -a --no-o --delete --safe-links --link-dest=$DIR_TARGET/1 $REMOTE_USER@$IP_SOURCE:$DIR_SOURCE/* $DIR_TARGET/0$DIR_SOURCE/



# REMOUNT
umount /srv/backup/
mount -o ro /dev/sdb1 /srv/backup/

