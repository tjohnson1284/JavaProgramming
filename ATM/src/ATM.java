/* Name: Terrence Johnson
 * ID: 1202
 * Date: 2/14/14
 * Abstract: This program creates an ATM machine.
 * To accomplish this, I will use two classes. One to handle accounts and another to handle ATM access.
 * From this, I will use several methods to emulate ATM functions.
 * 
 */

import java.util.Scanner;
public class ATM {
	
	//variables
	private Account2[] accounts;
	private String bankName, location;
	private int serialNumber; 
	private static int withdrawal = 0, deposit = 0, transfer = 0;
	private static int withdrawalSuccess = 0, withdrawalFailure = 0;
	private static int depositSuccess = 0, depositFailure = 0;
	private static int transferSuccess = 0, transferFailure = 0;
	private static int atmFunds = 0;
	private static int numOfAtms = 0;
	
	
	private Account2[] setAccounts(Account2[] accounts)
	{
		//This function takes the accounts variable, initializes it, and adds each of the default accounts into the variable
		//Once complete, it will return the accounts variable.
		accounts = new Account2[10];
		
		accounts[0] = new Account2("Alice", 1234, 5000.00); 
		accounts[1] = new Account2("Tom", 2000, 200.00);
		accounts[2] = new Account2("Monica", 3000, 50.00);
		accounts[3] = new Account2("Michael", 7777, 0.00);
		accounts[4] = new Account2("John", 8000, 500.00);
		accounts[5] = new Account2("Jane", 2222, 500.00);
		accounts[6] = new Account2("Robert", 2323, 200.00);
		accounts[7] = new Account2("Owen", 4455, 50.00);
		accounts[8] = new Account2("Chris", 8787, 10.00);
		accounts[9] = new Account2("Rebecca", 8080, 555.55);
		
		return accounts;
	}
	public ATM()
	{
		//Default constructor with no variables.
		
		this.bankName = "";
		this.serialNumber = numOfAtms;
		setAccounts(this.accounts); 
		numOfAtms += 1;
	}
	public ATM(String name)
	{
		// Default constructor when a name is given for the ATM
		this.bankName = name;
		this.serialNumber = numOfAtms;
		this.accounts = setAccounts(this.accounts); 
		numOfAtms += 1;
	}
	public ATM(int amount, String name, String location)
	{
		//Constructor when values are given for each field.
		this.bankName = name;
		atmFunds = amount;
		this.serialNumber = numOfAtms;
		this.location = location;
		setAccounts(this.accounts); 
		numOfAtms += 1;
	}
	public String toString()
	{
		//toString constructor. Returns a string describing the ATM and its current balance.
		
		return ("Serial Number: " + this.serialNumber + ", Bank Name: " + this.bankName + ", Location: " + this.location + ", Balance: $" + atmFunds);
	}
	public boolean equals(ATM atm2)
	{
		//Equals constructor. Compares the serial number of each atm. Returns true if they match, returns false if they don't.
		return(this.serialNumber == atm2.serialNumber);
	}
	public void setATM(int funds, String location)
	{
		//Set method. Allows you to set an ATM with an amount and location.
		this.location = location;
		atmFunds = funds;
	}
	public void addFund(int funds)
	{
		//This method allows you to add funds to an ATM. For administrators.
		atmFunds += funds;
	}
	public void displayMenu()
	{
		// This method displays a menu. Uninteractable.
		System.out.println("===== ATM Transaction Menu =====");
		System.out.println("1. Withdrawal");
		System.out.println("2. Deposit");
		System.out.println("3. Transfer");
	}
	public boolean withdrawal(String name, int pinCode, int fund)
	{
		//This method handles withdrawals. It will return true if a withdrawal is successful(name/pin code match a record on file)
		//It will return false if those conditions fail. 
		for(int i = 0; i < 10; i++)
		{
			if(this.accounts[i].verification(name, pinCode) == true)
			{
				if(fund < atmFunds && accounts[i].withdrawal(fund)) // Verifies that the ATM has enough funds to handle the transaction and calls a method that verifies that the customer has funds)
				{
					System.out.println("Succeed - withdrawal: " + accounts[i].accountHolder() + " new balance: $" + accounts[i].balance());
					withdrawalSuccess++;
					return true;
				}
			}
		}
		System.out.println("Fail - withdrawal");
		withdrawalFailure++;
		return false;
	}
	public boolean deposit(String name, int pinCode, int fund)
	{
		//Deposit method. It will return true if the account exists with the give name and pin code and the deposit was successful.
		//It will return false, if it can't find the account or the deposit wasn't successful(negative balance given, etc)
		for(int i = 0; i < 10; i++)
		{
			if(accounts[i].verification(name, pinCode))
			{
				if(accounts[i].deposit(fund))
				{
					System.out.println("Succeed - deposit: " + accounts[i].accountHolder() + " new balance: $" + accounts[i].balance());
					depositSuccess++;
					return true;
				}
				System.out.println("Fail - deposit");
				depositFailure++;
				return false;
			}
		}
		System.out.println("Fail - deposit");
		depositFailure++;
		return false;
	}
	public boolean transfer(String name, int pinCode, int fund, String payee, int payeePin)
	{
		// This method handles transfers between accounts. To do this, it verifies the first account given. If that account is found, it then searches for a second account
		// If that account exists, it will then withdraw the funds from the first account and deposit them into the second account. 
		// If it successfully completes this process, it will return true.
		// If this fails at any step, it will return false.
		
		for(int i = 0; i < 10; i++)
		{
			if(accounts[i].verification(name, pinCode))
			{
				for(int j = 0; j < 10; j++)
				{
					if(accounts[j].verification(payee, payeePin))
					{
						if(accounts[i].withdrawal(fund) && accounts[j].deposit(fund))
						{
							System.out.println("Success - transfer" + accounts[i].accountHolder() + " new balance: $" + accounts[i].balance()
									+ ", " + accounts[j].accountHolder() + " new balance: $" + accounts[j].balance());
							transferSuccess++;
							return true;
						}
						System.out.println("Fail - transfer");
						transferFailure++;
						return false;
					}
				}
			}
		}
		
		System.out.println("Fail - transfer");
		transferFailure++;
		return false;
	}

	public void status()
	{
		// This method prints the current status of an ATM. This includes the total transactions processed, the serial number, and other identifying information
		// It then details the transactions performed.
		
		int transactions = withdrawalSuccess + withdrawalFailure + depositSuccess + depositFailure + transferSuccess + transferFailure;
		int totalWithdrawal = withdrawalSuccess + withdrawalFailure;
		int totalDeposit = depositSuccess + depositFailure;
		int totalTransfers = transferSuccess + transferFailure;
				
		
		System.out.println("Machine Status");
		
		System.out.println(toString());
		
		System.out.println("    " + transactions + " Transactions so far:");
		
		System.out.println("    Withdrawal(s): " + totalWithdrawal + " (" + withdrawalSuccess + " success, " + withdrawalFailure + " fail)");
		
		System.out.println("    Deposit(s): " + totalDeposit + " (" + depositSuccess + ", success, " + depositFailure + " fail)");
		
		System.out.println("    Transfer(s): " + totalTransfers + " (" + transferSuccess + ", success, " + transferFailure + " fail)");
		
	}
	public double atmFunds()
	{
		return this.atmFunds;
	}
}
