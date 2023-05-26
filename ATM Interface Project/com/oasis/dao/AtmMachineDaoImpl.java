package com.oasis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.oasis.factory.ConnectionFactory;

public class AtmMachineDaoImpl implements AtmMachineDao {
	
	@Override
	public void transactHistory(int accno) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ResultSet rst = null;
		String tid = null;
		try {
			//Establishing database Connection
			con = ConnectionFactory.getConnectionObject();
			
			//Creating Statement Object
			if(con != null)
				st = con.createStatement();
			//Checking if the Account of the User Existed or not
			//Creating ResultSets
			if(st != null) {
				rs = st.executeQuery("SELECT TRANSACTID FROM ACCOUNTSTABLE WHERE ACCNO="+accno);
				boolean b = rs.next();
				if(b == true) {
					tid = rs.getString(1);
					rst = st.executeQuery("SELECT * FROM "+tid);
					System.out.println("The Transaction History is as follows : ");
					System.out.println("=============================================================");
					while(rst.next())
						System.out.println(rst.getInt(1)+"  "+rst.getString(2)+"  "+rst.getString(3)+"  "+rst.getFloat(4)+"  "+rst.getFloat(5)+"  "+rst.getFloat(6));
					System.out.println("==============================================================");
				}
				else
					System.out.println("User Account Not Existed ...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(rst != null)
					rst.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return;
	}

	@Override
	public String withdraw(int accno,int amount) {
		Connection con = null;
		Statement st = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		String tid= "";
		String status = null;
		try {
			con = ConnectionFactory.getConnectionObject();
			int slno = 0, balance = 0;
			if(con != null)
				st = con.createStatement();
			if(st != null)
				rs1 = st.executeQuery("SELECT * FROM ACCOUNTSTABLE WHERE ACCNO = " + accno);
			boolean b = rs1.next();
			if(b == true && rs1 != null) {
				tid = rs1.getString(4);
				if(st != null)
					rs2 = st.executeQuery("SELECT MAX(SERIALNO) FROM " + tid);
				if(rs2 != null) {
					if(rs2.next())
						slno = rs2.getInt(1);
				}				
				if(st != null)
//					rs3 = st.executeQuery("SELECT BALANCE FROM "+ tid +"WHERE SERIALNO = " + slno);
					rs3 = st.executeQuery("SELECT BALANCE FROM "+ tid +" WHERE SERIALNO = " + slno);
				if(rs3 != null) {
					if(rs3.next())
						balance = rs3.getInt(1);
				}
				if(balance >= amount) {
					if(st != null) {
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDateTime now = LocalDateTime.now();
						String datestr = dtf.format(now);
						//INSERT INTO TR1111 VALUES(2,"2005-06-2","CASH WITHDRAWN",500,0,500);
						st.executeUpdate("INSERT INTO "+ tid +" VALUES(" +(slno+1) +",'"+ datestr +"','Cash Withdrawn',0,"+ amount +","+(balance - amount) +")");
					}
					status =  "success";
				}
				else {
					status =  "amount high";
				}
			}
			else {
				status =  "not existed";
			}
		} catch (SQLException sqe) {
			if(sqe.getErrorCode()==1)
				System.out.println("Duplicate cannot be inserted to primary key");
			if(sqe.getErrorCode()==1400)
				System.out.println("Null cannot be inserted to primary key");
			if(sqe.getErrorCode()>=900 && sqe.getErrorCode()<=999)
				System.out.println("Invalid Column names or table names or sql query");
			if(sqe.getErrorCode()==12899)
				System.out.println("Do not insert more than column size data to table");
			status = "failure";
			sqe.printStackTrace();
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}finally {
			try {
				if(rs1 != null && rs2 != null&& rs3 != null) {
					rs1.close();
					rs2.close();
					rs3.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return status;

	}

	@Override
	public String deposit(int accno,int amount) {
		Connection con = null;
		Statement st = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		String tid= "";
		String status = null;
		try {
			con = ConnectionFactory.getConnectionObject();
			int slno = 0, balance = 0;
			if(con != null)
				st = con.createStatement();
			if(st != null)
				rs1 = st.executeQuery("SELECT * FROM ACCOUNTSTABLE WHERE ACCNO = " + accno);
			boolean b = rs1.next();
			if(b == true && rs1 != null) {
				tid = rs1.getString(4);
				if(st != null)
					rs2 = st.executeQuery("SELECT MAX(SERIALNO) FROM " + tid);
				if(rs2 != null) {
					if(rs2.next())
						slno = rs2.getInt(1);
				}				
				if(st != null)
//					rs3 = st.executeQuery("SELECT BALANCE FROM "+ tid +"WHERE SERIALNO = " + slno);
					rs3 = st.executeQuery("SELECT BALANCE FROM "+ tid +" WHERE SERIALNO = " + slno);
				if(rs3 != null) {
					if(rs3.next())
						balance = rs3.getInt(1);
				}
				
				if(st != null) {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDateTime now = LocalDateTime.now();
					String datestr = dtf.format(now);
					//INSERT INTO TR1111 VALUES(2,"2005-06-2","CASH WITHDRAWN",500,0,500);
					st.executeUpdate("INSERT INTO "+ tid +" VALUES(" +(slno+1) +",'"+ datestr +"','Cash Deposited',"+amount+",0,"+(balance + amount) +")");
				}
				status =  "success";
			}
			else {
				status =  "not existed";
			}
		} catch (SQLException sqe) {
			if(sqe.getErrorCode()==1)
				System.out.println("Duplicate cannot be inserted to primary key");
			if(sqe.getErrorCode()==1400)
				System.out.println("Null cannot be inserted to primary key");
			if(sqe.getErrorCode()>=900 && sqe.getErrorCode()<=999)
				System.out.println("Invalid Column names or table names or sql query");
			if(sqe.getErrorCode()==12899)
				System.out.println("Do not insert more than column size data to table");
			status = "failure";
			sqe.printStackTrace();
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}finally {
			try {
				if(rs1 != null && rs2 != null&& rs3 != null) {
					rs1.close();
					rs2.close();
					rs3.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public String transfer(int fromAccNo, int toAccNo,int amount) {
		String status = null;
		status = this.withdraw(fromAccNo, amount);
		if(status.equalsIgnoreCase("success")) {
			status = this.deposit(toAccNo, amount);
			if(!status.equalsIgnoreCase("success")) {
				this.deposit(fromAccNo, amount);
				status = "failure";
			}
		}
		else
			status = "failure";
		return status;
	}
	
	public String loginUser(int accno,int pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs1 = null;
		int password = 0;
		String status = null;
		try {
			con = ConnectionFactory.getConnectionObject();
			if(con != null)
				st = con.createStatement();
			if(st != null)
				rs1 = st.executeQuery("SELECT * FROM ACCOUNTSTABLE WHERE ACCNO = " + accno);
			boolean b = rs1.next();
			if(b == true && rs1 != null) {
				password = rs1.getInt(5);
				if(password == pwd)
					status = "success";
				else
					status = "failure";
			}
			else
				status = "not existed";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
