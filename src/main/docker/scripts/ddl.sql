alter session set "_ORACLE_SCRIPT"=true;

create user TESTIT identified by mysecret;
grant create session to TESTIT;
grant connect to TESTIT;
grant create table to TESTIT;
grant create view, create procedure, create sequence to TESTIT;
grant select any table, insert any table, delete any table, update any table to TESTIT;

grant all privileges to TESTIT;

alter session set current_schema = TESTIT;

CREATE TABLESPACE tbs_01 DATAFILE 'tbs_f2.dbf' SIZE 40M     ONLINE;

alter user TESTIT quota unlimited on tbs_01;