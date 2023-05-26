package com.oasis.dao;

public interface AtmMachineDao {
	public void transactHistory(int accno);
	public String withdraw(int accno,int amount);
	public String deposit(int accno,int amount);
	public String transfer(int fromAccNo,int toAccNo,int amount);
	public String loginUser(int accno,int pwd);
	
}
