package bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilities {
	public static Object getInput(Class<?> type,Scanner scan) {
		Object object = null;
		try {
			switch(type.getSimpleName()) {
			case "String":
				object = scan.nextLine();
				break;
			case "Integer":
				object = scan.nextInt();
				scan.nextLine();
				break;
			case "Double":
				object = scan.nextDouble();
				scan.nextLine();
				break;
			default:
				break;
			}
		}
		catch(InputMismatchException e) {
			scan.nextLine();
			object = getInput(type,scan);
		}
		return object;
	}
	
	public static boolean validString(String str) {
		if(str.isEmpty()||str.isBlank()) {
			return false;
		}
		else {
			return true;
		}
	}
}
