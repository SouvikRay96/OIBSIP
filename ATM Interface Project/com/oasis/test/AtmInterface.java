package com.oasis.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.oasis.factory.AtmMachineServiceFactory;
import com.oasis.factory.ConnectionFactory;
import com.oasis.service.AtmMachineService;

public class AtmInterface {
	
	static {
		ConnectionFactory.getConnectionObject();
	}
	public static void main(String[] args) {
		int option;
		int accno = 0,pwd = 0;
		BufferedReader br = null;
		System.out.println("============================================");
		System.out.println("Welcome to the ATM Machine User Interface ");
		System.out.println("============================================");
		System.out.println();
		
		
		try {
			AtmMachineService atmService = AtmMachineServiceFactory.getAtmMachineService();
			br = new BufferedReader(new InputStreamReader(System.in));
			String status = null;
			String ch = null;
			do {
				System.out.println("USER LOGIN");
				System.out.println("=============");
				System.out.print("Enter the Account Number : ");
				accno = Integer.parseInt(br.readLine());
				System.out.print("Enter the Password : ");
				pwd = Integer.parseInt(br.readLine());
				status = atmService.loginUserService(accno, pwd);
				System.out.println("===========================================");
				if(status.equalsIgnoreCase("success")) {
					System.out.println("USER LOGGED IN SUCCESSFULLY ");
					break;
				}
				else if(status.equalsIgnoreCase("failure")) {
					System.out.println("PLEASE ENTER A VALID PASSWORD");
				}
				else if(status.equalsIgnoreCase("not existed"))
					System.out.println("THE USER ACCOUNT NOT EXISTED");
				System.out.println("===========================================");
				do {
					System.out.print("Do you want to enter the Credentials Again(yes/no) : ");
					ch = br.readLine();
					if(ch.equalsIgnoreCase("no")) {
						System.out.println("THANK YOU!!! FOR USING THE ATM MACHINE INTERFACE ... PLEASE VISIT AGAIN");
						System.exit(0);
					}
					else if(ch.equalsIgnoreCase("yes"))
						break;
					else
						System.out.println("PLEASE ENTER YES/NO IN ANY CASE");
				}while(true);
			}while(true);
			do {
				int toaccno = 0;
				int amount = 0;
				System.out.println();
				System.out.println("==================================================");
				System.out.println("Here are the ATM Machine Operations that you can Perform");
				System.out.println("===================================================");
				System.out.println();
				System.out.println("===================================================");
				System.out.println("1) Transaction History of the User.");
				System.out.println("2) Withdrawal of Cash.");
				System.out.println("3) Deposit of Cash.");
				System.out.println("4) Cash Transfer.");
				System.out.println("5) Quit.");
				System.out.println("===================================================");
				System.out.print("Enter your choice : ");
				option = Integer.parseInt(br.readLine());
				switch(option) {
				case 1:
					//Transaction History
					System.out.println();
					System.out.println("**************** TRANSACTION HISTORY ****************");
					atmService.transactHistoryService(accno);
					break;
				case 2:
					//Withdrawal of Cash
					System.out.println();
					System.out.println("**************** CASH WITHDRAWAL ****************");
					System.out.print("Enter the Amount to be Withdrawn : ");
					amount = Integer.parseInt(br.readLine());
					status = atmService.withdrawService(accno, amount);
					System.out.println("===================================================");
					if(status.equalsIgnoreCase("not existed"))
						System.out.println("ACCOUNT NOT EXISTED");
					else if(status.equalsIgnoreCase("amount high"))
						System.out.println("YOU DON'T HAVE SUFFICIENT BALANCE");
					else if(status.equalsIgnoreCase("success"))
						System.out.println(amount+" IS SUCCESSFULLY WITHDRAWN");
					System.out.println("===================================================");
					break;
				case 3:
					//Deposit of Cash
					System.out.println();
					System.out.println("**************** CASH DEPOSIT ****************");
					System.out.print("Enter the Amount to be deposited : ");
					amount = Integer.parseInt(br.readLine());
					status = atmService.depositService(accno, amount);
					System.out.println("===================================================");
					if(status.equalsIgnoreCase("not existed"))
						System.out.println("ACCOUNT NOT EXISTED");
					else if(status.equalsIgnoreCase("success"))
						System.out.println(amount+" IS SUCCESSFULLY DEPOSITED");
					else if(status.equalsIgnoreCase("failure"))
						System.out.println("SOMETHING WENT WRONG !!!!");
					System.out.println("===================================================");
					break;
				case 4:
					//Cash Transfer
					System.out.println();
					System.out.println("**************** CASH TRANSFER ****************");
					System.out.print("Enter the Account number to which the amount is to be transfered : ");
					toaccno = Integer.parseInt(br.readLine());
					System.out.print("Enter the amount to be transfered : ");
					amount = Integer.parseInt(br.readLine());
					status = atmService.transferService(accno, toaccno, amount);
					if(status.equalsIgnoreCase("success"))
						System.out.println("CASH TRANSFER SUCCESSFULL");
					else if(status.equalsIgnoreCase("failure"))
						System.out.println("CASH TRANSFER FAILED");
					break;
				case 5:
					System.out.println("THANK YOU!!! FOR USING THE ATM MACHINE INTERFACE ... PLEASE VISIT AGAIN");
					System.exit(0);
				default:
					System.out.println("INVALID CHOICE ... PLEASE ENTER VALID CHOICE...");
				}
			}while(true);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
