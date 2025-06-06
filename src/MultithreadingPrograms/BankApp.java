/*
  Scenario Overview: We have a bank account class where multiple threads are trying to access and modify 
  the balance by performing deposit and withdrawal operations. We need to ensure thread safety when
  these operations are happening concurrently.
Program Steps:
Create a BankAccount Class: This class will have methods for deposit and withdrawal.
 We'll make these methods synchronized to avoid race conditions.
Create a Task Class: This class will represent the deposit/withdrawal operation. 
It will implement the Runnable interface.
Run the Application: We'll create multiple threads to simulate concurrent deposits and withdrawals 
on the same bank account.

 */



package MultithreadingPrograms;

import java.util.Scanner;
 class BankAccount{
	private double balance;
	BankAccount(double balance)
	{
		this.balance=balance;
		System.out.println("The bank initial Balance is "+ balance);
	}
	public synchronized void deposite(double amount)
	{
		if(amount>0)
		{
			double newBalance=balance+amount;
			try{
				Thread.sleep(5000);
			}catch(Exception e)
			{
				
	             System.out.println("Deposit interrupted.");
			}
			balance=newBalance;
			System.out.println("Deposited amount is: "+amount+"\nNew Balance: "+balance);
		}
		else {
			System.out.println("Invalid Amount");
			
		}
	}
	
	public synchronized void withdraw(double amount) {
		if(balance>amount)
		{
			double newBalance=balance-amount;
			try {
				Thread.sleep(5000);
			}catch(Exception e) {
				System.out.println("Withdraw amount is: ");
			}
			balance=newBalance;
			System.out.println("Withdrawl amount is: "+amount+"\n New Balance is: "+balance);
		}
		else {
			System.out.println("Amount is not present "+amount);
		}
	}
}
public class BankApp {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BankAccount bk=new BankAccount(10000);
		System.out.println("Enter Deposite Amount");
		double am=s.nextDouble();
		System.out.println("Enter Withdrawl Amount");
		double amount=s.nextDouble();
		bk.deposite(am);
		bk.withdraw(amount);
	}
}
