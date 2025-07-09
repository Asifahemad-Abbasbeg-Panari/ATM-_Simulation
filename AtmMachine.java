package com.asifpanari.objectandclasses;

import java.util.Scanner;

class ATM {
	double Balance;
	private int PIN = 5674;
	int opt;
	Scanner sc = new Scanner(System.in);

	public void checkPin() {
		System.out.println("Enter Your PIN: ");
		int enteredpin = sc.nextInt();
		if (enteredpin == PIN) {
			menu();
		} else {
			System.out.println("Entered Wrong PIN:");
			checkPin();
		}
	}
	public void menu() {
		System.out.println("Enter your choice: ");
		System.out.println("1. Check A/C Balance: ");
		System.out.println("2. Withdraw Money: ");
		System.out.println("3. Diposit Money: ");
		System.out.println("4. EXIT");

		opt = sc.nextInt();

		switch (opt) {
		case 1:
			checkBalance();
			break;
		case 2:
			withdrawMoney();
			break;
		case 3:
			dipositMoney();
			break;
		default:
			return;
		}
	}
	
	public void takeDecision() {
		System.out.println("If you want to use ATM again please press number 9 or 0 to exit!");
		opt = sc.nextInt();
		if (opt == 9) {
			menu();
		} else if (opt != 0) {
			takeDecision();
		} else {
			System.out.println("Thankyou for using me!\nUse me Again!");
			return;
		}
	}

	public void checkBalance() {
		System.out.println("Balance: " + Balance);
		takeDecision();
	}

	public void withdrawMoney() {
		System.out.println("Enter Amount: ");
		float amount = sc.nextFloat();
		if (amount > Balance) {
			System.out.println("Insufficient Balance");
		}

		else {
			Balance = Balance - amount;
			System.out.println("Withdraw Sucssesfull");
			checkBalance();
		}
	}

	public void dipositMoney() {
		System.out.println("Enter the amount: ");
		float amount = sc.nextFloat();
		Balance = Balance + amount;
		System.out.println("Money Diposit Sucssesfully: ");
		checkBalance();
	}
}

public class AtmMachine {
	public static void main(String[] args) {
		ATM obj = new ATM();
		//System.out.println(obj.PIN);
		obj.checkPin();
	}
}


