package com.oasis.service;

import com.oasis.dao.AtmMachineDao;
import com.oasis.factory.AtmMachineDaoFactory;

public class AtmMachineServiceImpl implements AtmMachineService {

	@Override
	public void transactHistoryService(int accno) {
		AtmMachineDao atmDao = AtmMachineDaoFactory.getAtmMachineDao();
		atmDao.transactHistory(accno);
		return;

	}

	@Override
	public String withdrawService(int accno,int amount) {
		AtmMachineDao atmDao = AtmMachineDaoFactory.getAtmMachineDao();
		String status = atmDao.withdraw(accno, amount);
		return status;
	}

	@Override
	public String depositService(int accno,int amount) {
		AtmMachineDao atmDao = AtmMachineDaoFactory.getAtmMachineDao();
		String status = atmDao.deposit(accno, amount);
		return status;
	}

	@Override
	public String transferService(int fromAccNo, int toAccNo,int amount) {
		AtmMachineDao atmDao = AtmMachineDaoFactory.getAtmMachineDao();
		String status = atmDao.transfer(fromAccNo, toAccNo, amount);
		return status;
	}
	
	public String loginUserService(int accno,int pwd) {
		AtmMachineDao atmDao = AtmMachineDaoFactory.getAtmMachineDao();
		String status = atmDao.loginUser(accno, pwd);
		return status;
		
	}
}
