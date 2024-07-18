package bank;

import java.util.Scanner;

public class Banking {
	private void deposit(Account account,Double amount) {
		account.setBalance(account.getBalance()+amount);
	}
	private boolean withdraw(Account account,Double amount) {
		if(account.getBalance()>=amount) {
			account.setBalance(account.getBalance()-amount);
			return true;
		}
		else {
			return false;
		}
	}
	public void doBanking(Account account,Scanner scan) {
		while(true) {
			System.out.println("1 for deposit \n2 for withdrawl \n3 for balance \n4 for logout \nYour choice: ");
			int opt = (Integer)Utilities.getInput(Integer.class, scan);
			switch(opt) {
			case 1:
				System.out.println("Enter amount to deposit");
				Double amount = (Double) Utilities.getInput(Double.class, scan);
				deposit(account, amount);
				break;
			case 2:
				System.out.println("Enter amount to withdraw");
				amount = (Double) Utilities.getInput(Double.class, scan);
				if(withdraw(account, amount)) {
					System.out.println("Withdrew :"+amount+" balance: "+account.getBalance());
				}
				else {
					System.out.println("Insufficient funds, balance: "+account.getBalance());
				}
				break;
			case 3:
				System.out.println("Balance: "+account.getBalance());
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid input, try again");
				break;
			}
		}
	}
}
