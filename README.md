# OIBSIP

ATM Interface
--------------------------------------------------------------------------
It is a Console-Based Stand-Alone Java Application which caters the user interface in an ATM Machine. When the application is runned it will prompt to an user-login where user will have to give the user-id and password to log-in to their bank accounts.

After successful Log-in the User can perform the following operations : 
=================================================================================
1) Transaction History :-> 
----------------------------------------
    The user can view their Transaction History i.e. what are the transactions made from his/her account for eg. withdrawals, deposits and transfers of money.
2) Withdrawal :->
-----------------------------------------
    The user can withdraw money from their account.
3) Deposit :->
-----------------------------------------
    The User can deposit money into their account.
4) Transfer :->
-----------------------------------------
    The user can Transfer money from their account to another existing account


To accomplish this Task I have used MySQL as the database
I have created one database named bank_database in MySQL which contained two tables.
The first Table is the "ACCOUNTSTABLE" which contains the AccNo. , Account Holder Name, Branch Name, TransactionID and Password of the account

AccountsTable
=========================================================================================
    +-------+------------------+------------+------------+----------+
    | AccNo | AccHolderName    | BranchName | TransactID | PassWord |
    +-------+------------------+------------+------------+----------+
    |   111 | AAA              | Konnagar   | T111       |      111 |
    |   222 | BBB              | Uttarpara  | T222       |      222 |
    |   333 | CCC              | Uttarpara  | T333       |      333 |
    |   444 | DDD              | Hind Motor | T444       |      444 |
    |   555 | EEE              | Jirat      | T555       |      555 |
    |   666 | FFF              | Kolkata    | T666       |      666 |
    +-------+------------------+------------+------------+----------+
=========================================================================================

And The other table is the Transaction Table which is unique for each bank account and the name of the Transaction Table is the TransactionID given in the accounts table.
-----------------------------------------------------------------------------------------
    Each Transaction Table contains SerialNo., Date of Transaction, Description, Credit, Debit and Balance
    Here I have worked with 6 Accounts So 6 Transaction Tables should be maintained.
    Every Account has an account Creation Statement i.e. the accounts are created with a certain amount of balance and the date when it was Created.
-----------------------------------------------------------------------------------------
Here they are as follows :->
=========================================================================================
For Account Number : 111
---------------------------------------
    +----------+----------------+------------------+--------+-------+---------+
    | SerialNo | DateOfTransact | Description      | Credit | Debit | Balance |
    +----------+----------------+------------------+--------+-------+---------+
    |        1 | 2002-05-19     | Account Creation |   2000 |     0 |    2000 |
    +----------+----------------+------------------+--------+-------+---------+
-----------------------------------------------------------------------------------------
For Account Number : 222
---------------------------------------
    +----------+----------------+------------------+--------+-------+---------+
    | SerialNo | DateOfTransact | Description      | Credit | Debit | Balance |
    +----------+----------------+------------------+--------+-------+---------+
    |        1 | 2004-11-21     | Account Creation |   4500 |     0 |    4500 |
    +----------+----------------+------------------+--------+-------+---------+
-----------------------------------------------------------------------------------------
For Account Number : 333
---------------------------------------
    +----------+----------------+------------------+--------+-------+---------+
    | SerialNo | DateOfTransact | Description      | Credit | Debit | Balance |
    +----------+----------------+------------------+--------+-------+---------+
    |        1 | 2003-10-22     | Account Creation |   4500 |     0 |    4500 |
    +----------+----------------+------------------+--------+-------+---------+
-----------------------------------------------------------------------------------------
For Account Number : 444
---------------------------------------
    +----------+----------------+------------------+--------+-------+---------+
    | SerialNo | DateOfTransact | Description      | Credit | Debit | Balance |
    +----------+----------------+------------------+--------+-------+---------+
    |        1 | 2006-08-02     | Account Creation |   5000 |     0 |    5000 |
    +----------+----------------+------------------+--------+-------+---------+
-----------------------------------------------------------------------------------------
For Account Number : 555
---------------------------------------
    +----------+----------------+------------------+--------+-------+---------+
    | SerialNo | DateOfTransact | Description      | Credit | Debit | Balance |
    +----------+----------------+------------------+--------+-------+---------+
    |        1 | 2005-07-29     | Account Creation |   3000 |     0 |    3000 |
    +----------+----------------+------------------+--------+-------+---------+
-----------------------------------------------------------------------------------------
For Account Number : 666
---------------------------------------
    +----------+----------------+------------------+--------+-------+---------+
    | SerialNo | DateOfTransact | Description      | Credit | Debit | Balance |
    +----------+----------------+------------------+--------+-------+---------+
    |        1 | 2005-06-03     | Account Creation |   3500 |     0 |    3500 |
    +----------+----------------+------------------+--------+-------+---------+
=========================================================================================

The MySQL Commands/ queries are : 
     drop database bank_database;
     create database bank_database;
     connect bank_database;
     CREATE TABLE ACCOUNTSTABLE(ACCNO INT PRIMARY KEY, ACCHOLDERNAME VARCHAR(26), BRANCHNAME VARCHAR(26), TRANSANCTIONID VARCHAR(8), PASSWORD INT);
     INSERT INTO ACCOUNTSTABLE VALUES(111,'AAA', 'KONNAGAR', 'T111', 111);
     INSERT INTO ACCOUNTSTABLE VALUES(222,'BBB', 'UTTARPARA', 'T222', 222);
     INSERT INTO ACCOUNTSTABLE VALUES(333,'CCC', 'UTTARPARA', 'T333', 333);
     INSERT INTO ACCOUNTSTABLE VALUES(444,'DDD', 'HINDMOTOR', 'T444', 444);
     INSERT INTO ACCOUNTSTABLE VALUES(555,'EEE', 'JIRAT', 'T555', 555);
     INSERT INTO ACCOUNTSTABLE VALUES(666,'FFF', 'KOLKATA', 'T666', 666);
     CREATE TABLE T111(SERIALNO INT PRIMARY KEY,DATEOFTRANSACT DATE,DESCRIPTION VARCHAR(30),CREDIT FLOAT,DEBIT FLOAT,BALANCE FLOAT);
     INSERT INTO T111 VALUES(1,"2005-06-2","ACCOUNT CREATION",500,0,500);
     CREATE TABLE T222(SERIALNO INT PRIMARY KEY,DATEOFTRANSACT DATE,DESCRIPTION VARCHAR(30),CREDIT FLOAT,DEBIT FLOAT,BALANCE FLOAT);
     INSERT INTO T222 VALUES(1,"2006-08-12","ACCOUNT CREATION",3000,0,3000);
     CREATE TABLE T333(SERIALNO INT PRIMARY KEY,DATEOFTRANSACT DATE,DESCRIPTION VARCHAR(30),CREDIT FLOAT,DEBIT FLOAT,BALANCE FLOAT);
     INSERT INTO T333 VALUES(1,"2007-07-22","ACCOUNT CREATION",8000,0,8000);
     CREATE TABLE T444(SERIALNO INT PRIMARY KEY,DATEOFTRANSACT DATE,DESCRIPTION VARCHAR(30),CREDIT FLOAT,DEBIT FLOAT,BALANCE FLOAT);
     INSERT INTO T444 VALUES(1,"2008-03-17","ACCOUNT CREATION",9000,0,9000);
     CREATE TABLE T555(SERIALNO INT PRIMARY KEY,DATEOFTRANSACT DATE,DESCRIPTION VARCHAR(30),CREDIT FLOAT,DEBIT FLOAT,BALANCE FLOAT);
     INSERT INTO T555 VALUES(1,"2009-02-23","ACCOUNT CREATION",5000,0,5000);
     CREATE TABLE T666(SERIALNO INT PRIMARY KEY,DATEOFTRANSACT DATE,DESCRIPTION VARCHAR(30),CREDIT FLOAT,DEBIT FLOAT,BALANCE FLOAT);
     INSERT INTO T666 VALUES(1,"2007-10-28","ACCOUNT CREATION",4000,0,4000);

Number Guessing Game :->
-----------------------------------------------------------------------------------------
This is a Web-Based java Application where an user have to guess a number and the application will check whether the guessed number matches with the application generated random number or not. If the number guessed by the user is larger or smaller, the application will give hints about it. The user have to guess the number within 40 seconds. I have used Java Servlets to build this application and i have used TomCat Server to run this application. 
