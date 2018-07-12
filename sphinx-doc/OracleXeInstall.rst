Installing Oracle XE
====================

http://www.oracle.com/technetwork/database/database-technologies/express-edition/downloads/index.html

unzip oracle-xe-11.2.0-1.0.x86_64.rpm.zip
cd Disk1

sudo rpm -i oracle-xe-11.2.0-1.0.x86_64.rpm 
sudo /etc/init.d/oracle-xe configure
sudo /etc/init.d/oracle-xe configure

Oracle Database 11g Express Edition Configuration
-------------------------------------------------
This will configure on-boot properties of Oracle Database 11g Express 
Edition.  The following questions will determine whether the database should 
be starting upon system boot, the ports it will use, and the passwords that 
will be used for database accounts.  Press <Enter> to accept the defaults. 
Ctrl-C will abort.

Specify the HTTP port that will be used for Oracle Application Express [8080]:

Specify a port that will be used for the database listener [1521]:1523 

Specify a password to be used for database accounts.  Note that the same
password will be used for SYS and SYSTEM.  Oracle recommends the use of 
different passwords for each database account.  This can be done after 
initial configuration:
Confirm the password:

Do you want Oracle Database 11g Express Edition to be started on boot (y/n) [y]:n

Starting Oracle Net Listener...Done
Configuring database...grep: /u01/app/oracle/product/11.2.0/xe/config/log/*.log: No such file or directory
grep: /u01/app/oracle/product/11.2.0/xe/config/log/*.log: No such file or directory
Done
/bin/chmod: cannot access '/u01/app/oracle/diag': No such file or directory
Starting Oracle Database 11g Express Edition instance...Done
Installation completed successfully.


/usr/lib64/libc.so.6
GNU C Library (GNU libc) stable release version 2.27.
Copyright (C) 2018 Free Software Foundation, Inc.
This is free software; see the source for copying conditions.
There is NO warranty; not even for MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE.
Compiled by GNU CC version 8.1.1 20180502 (Red Hat 8.1.1-1).
libc ABIs: UNIQUE IFUNC
For bug reporting instructions, please see:
<http://www.gnu.org/software/libc/bugs.html>.

Fedora 
------


TODO
----
https://docs.oracle.com/cd/E18283_01/server.112/e16638/sqltrace.htm
