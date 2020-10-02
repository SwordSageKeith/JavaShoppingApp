package com.shopping;

import java.util.Scanner;

import com.shopping.model.*;
import com.shopping.dao.Storage;

public class Application {
	
	static Storage s = new Storage();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clearConsole();

		Boolean run = true;
		while (run) {
			System.out.println("Select form the following options:");
			System.out.println("1: Login");
			System.out.println("2: Create Account");
			System.out.println("3: Exit");
			String x = scanner.next();
			if (x.equals("1")) {
				Login();
			} else if (x.equals("2")) {
				CreateAccount();
			} else if (x.equals("3")) {
				run = false;
			} else {
				System.out.println("Please enter a valid input");
			}
		}
		scanner.close();
		
	}

	public static void CreateAccount() {
		clearConsole();
		String name = null;
		String email = null;
		String password = null;
		System.out.println("Please enter a Username");
		Boolean n = true;
		while (n) {
			name = scanner.next();
			if (s.checkName(name)) {
				System.out.println("Username is already taken. Please try another");
			} else {
				n = false;
			}
		}
		System.out.println("Please enter a email");
		n = true;
		while (n) {
			email = scanner.next();
			if (s.checkEmail(email)) {
				System.out.println("An account already uses that email. Please try another");
			} else {
				n = false;
			}
		}
		System.out.println("Please enter a password");
		n = true;
		while (n) {
			password = scanner.next();
			if (s.validPassword(password)) {
				n = false;
			}
		}
		
		User u = new User(name, email, password);
		s.newUser(u);
		clearConsole();
	}

	public static void Login() {
		clearConsole();
		String user;
		String password;
		System.out.println("Username:  ");
		user = scanner.next();
		System.out.println("Password:    ");
		password = scanner.next();
		int i = s.login(user, password);
		if (i == -1) {
			System.out.println("Incorrect Username or Password");
		} else if(i == -2) {
			System.out.println("No account with that username");
		} else {
			Menu(i);
		}
		clearConsole();
	}

	public static void Menu(int userID) {
		clearConsole();

		Boolean run = true;
		while (run) {
			System.out.println("Select form the following options:");
			System.out.println("1: Purchase Items");
			System.out.println("2: Return an item");
			System.out.println("3: Exit");
			String x = scanner.next();
			if (x.equals("1")) {
				clearConsole();
				Purchase(userID);
			} else if (x.equals("2")) {
				
			} else if (x.equals("3")) {
				run = false;
			} else {
				System.out.println("Please enter a valid input");
			}
		}
	}
	
	public static void Return(int i) {
		clearConsole();
		Boolean run = true;
		while (run) {
			System.out.println("Select a recipt for further details, or press 0 to exit");
			s.printInv(i);
			String str = scanner.next();
			int val = Integer.parseInt(str);
			if (val == 0)
				run = false;
			else {
				if (s.showInvoiceID(val)) {
					Boolean next = true;
					while (next) {
						System.out.println("Return these items? yes/no");
						str = scanner.next();
						if (str.equals("yes") || str.equals("y")) {
							s.ReturnItems(val);
						} else if (str.equals("no") || str.equals("n")) {
							next = false;
						} else {
							System.out.println("Please enter 'yes' or 'no'");
						}
					}
				}
			}
		}
	}
	
	public static void Purchase(int i) {
		Boolean run = true;
		while(run) {
			System.out.println("Select an item to add to your cart");
			s.printStore();
			System.out.println("or, press 1 to view your cart. or 2 to return to main menu");
			String x = scanner.next();
			if (x.equals("1")) {
				clearConsole();
				s.viewCart(i);
				if (checkout(i))
					run = false;
			} else if (x.equals("2")) {
				run = false;
			} else {
				clearConsole();
				s.addToCart(x, i);
			}	
		}
	}
	
	public static Boolean checkout(int id) {
		Boolean run = true;
		while(run) {
			System.out.println("Press 1 to check out, or 2 to return to shopping");
			String in = scanner.next();
			if (in.contentEquals("1")) {
				clearConsole();
				System.out.println("Thank you for your purchase");
				s.buyCart(id);
				return true;
			} else if (in.equals("2")) {
				run = false;
			} else {
				System.out.println("Please enter a valid input");
			}
		}
		return false;
	}

	public static void clearConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}

}
