package bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
	private static Scanner scan = new Scanner(System.in);
	private static Banking banking = new Banking();
	private static Map<String,Account> accounts = new HashMap<>();
	public static void main(String[] args) {
		try {
			while(true) {
				System.out.print("Enter 1 for existing user, 2 for new user \nChoice: ");
				int opt = (Integer) Utilities.getInput(Integer.class, scan);
				switch(opt) {
				case -1:
					return;
				case 1:
					System.out.println("Enter username: ");
					String username = (String) Utilities.getInput(String.class,scan);
					if(!Utilities.validString(username)) {
						System.out.println("Username is invalid");
					}
					System.out.println("Enter password: ");
					String password = (String) Utilities.getInput(String.class,scan);
					Account account = accounts.get(username);
					if(account==null) {
						System.out.println("Account not found");
						break;
					}
					if(!account.checkPassword(password)) {
						System.out.println("Wrong password");
						break;
					}
					banking.doBanking(account,scan);
					break;
				case 2:
					System.out.println("Enter username: ");
					username = (String) Utilities.getInput(String.class,scan);
					if(!Utilities.validString(username)) {
						System.out.println("Username is invalid");
					}
					System.out.println("Enter password: ");
					password = (String) Utilities.getInput(String.class,scan);
					if(!Utilities.validString(password)) {
						System.out.println("Password is invalid");
					}
					account = new Account(username,password);
					accounts.put(username, account);
					banking.doBanking(account,scan);
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
				System.out.println("Hit Enter to continue");
				Utilities.getInput(String.class, scan);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			scan.close();
		}
	}
}

