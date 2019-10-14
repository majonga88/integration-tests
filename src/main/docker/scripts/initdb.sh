#!/bin/bash
echo 'Initialising testIT database - wait nearly 60 seconds'
export ORACLE_SID=ORCLCDB
export PATH=$ORACLE_HOME/bin:$PATH

echo exit | sqlplus sys/Oradoc_db1 as sysdba @/scripts/sql/ddl.sql && sleep 60
