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
    |   111 | Sonia Gupta      | Konnagar   | T111       |      111 |
    |   222 | Indrajit Ghosh   | Uttarpara  | T222       |      222 |
    |   333 | Souvik Ray       | Uttarpara  | T333       |      333 |
    |   444 | Rajdeep Maullick | Hind Motor | T444       |      444 |
    |   555 | Sourya Saha      | Jirat      | T555       |      555 |
    |   666 | Steven Smith     | Kolkata    | T666       |      666 |
    +-------+------------------+------------+------------+----------+
=========================================================================================

And The other table is the Transaction Table which is unique for each bank account and the name of the Transaction Table is the TransactionID given in the accounts table.

Each Transaction Table contains SerialNo., Date of Transaction, Description, Credit, Debit and Balance
Here I have worked with 6 Accounts So 6 Transaction Tables should be maintained.
Every Account has an account Creation Statement i.e. the accounts are created with a certain amount of balance and the date when it was Created.
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
