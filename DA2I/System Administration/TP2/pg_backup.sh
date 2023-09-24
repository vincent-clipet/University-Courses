#!/bin/bash



su postgres -c "pg_dumpall -U 'postgres'" > /home/postgres/databases.sql
