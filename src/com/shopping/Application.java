package com.shopping;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		Boolean run = true;
		while (run) {
			System.out.println("Select form the following options:");
			System.out.println("1: Login");
			System.out.println("2: Create Account");
			System.out.println("3: Exit");
			String x = scanner.next();
			if (x .equals("1")) {
				Login();
			} else if (x .equals("2")) {
				CreateAccount();
			}else if (x .equals("3")) {
				run = false;
			} else {
				System.out.println("Please enter a valid input");
			}
		}
		scanner.close();
	}
	
	public static void CreateAccount() {
		clearConsole();
		String name;
		String email;
		String password;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a Username");
		Boolean n = true;
		while (n) {
			name = scan.next();
			if (Services.UserExists(name)) {
				System.out.println("Username is already taken. Please try another");
			} else {
				n = false;
			}
		}
		clearConsole();
		System.out.println("Please enter a email");
		n = true;
		while (n) {
			email = scan.next();
			if (Services.UserExists(email)) {
				System.out.println("An account already uses that email. Please try another");
			} else {
				n = false;
			}
		}
		clearConsole();
		System.out.println("Please enter a password");
		n = true;
		while (n) {
			password = scan.next();
			if (Services.ValidPassword(password)) {
				n = false;
			}
		}
		clearConsole();
		scan.close();
	}
	
	public static void Login() {
		clearConsole();
		String user;
		String password;
		Scanner scan = new Scanner(System.in);
		System.out.println("Username:  ");
		user = scan.next();
		System.out.println("Password:    ");
		password = scan.next();
		int i = Services.Login(user, password);
		if (i == -1) {
			System.out.println("Incorrect Username or Password");
		} else {
			Menu(i);
		}
	}
	
	public static void Menu(int userID) {
		
	}
	
	public static void clearConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}

}
