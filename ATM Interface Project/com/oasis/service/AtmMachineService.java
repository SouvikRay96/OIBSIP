package com.oasis.service;

public interface AtmMachineService {
	public void transactHistoryService(int accno);
	public String withdrawService(int accno,int amount);
	public String depositService(int accno,int amount);
	public String transferService(int fromAccNo,int toAccNo,int amount);
	public String loginUserService(int accno,int pwd);
	
}
