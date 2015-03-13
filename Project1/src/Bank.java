
/*Title: Bank Class
 * Abstract: This program creates three classes to manage a small banking system. This will have a maximum of 30 accounts with 30 customers. Customers can have up to two accounts 
 * This program will obtain initial data from a file, the rest from user input.
 *  
 * Author: Terrence Johnson
 * ID: 1202
 * Date: 3/9/2014
 */
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Bank {

	private String name;
	private ArrayList<Account> accounts;
	private ArrayList<Customer> customers;
	private static int totalAccounts = 0;
	private static int totalCustomers = 0;
	private static double totalBalance = 0.0;
	
	public Bank(String name)
	{
		//Default Constructor
		this.name = name;
		accounts = new ArrayList<Account>();
		customers = new ArrayList<Customer>();
	}
	public void newCustomer(String name, String address, int zipCode, String ssn)
	{
		//Takes the information to create a new customers and creates one, if no customers with the given SSN exists.
		
		if(totalCustomers > 30)
		{
			System.out.println("Customer limit exceeded.");
			return;
		}
		for(int i = 0; i < totalCustomers; i++)
		{
			
			if(customers.get(i).customerSsn().equals(ssn))
			{
				System.out.println("Customer creation failed - Duplicated SSN.");
				return;
			}
		}
		
		Customer temp = new Customer(name, address, zipCode, ssn);
		customers.add(temp);
		System.out.println("Customer creation - " + name + " is added.");
		totalCustomers++;
	}
	public String toString()
	{
		return this.name;
	}
	public void newAccount(String ssn, int accountNum, int accountType, double balance)
	{
		if(totalAccounts > 30)
		{
			System.out.println("Customer limit exceeded.");
			return;
		}
		//This method takes account information and creates an account. If an account exists with a given account number, it will print an error.
		for(int i = 0; i < totalAccounts; i++)
		{
			if(accounts.get(i).verification(accountNum))
			{
				System.out.println("Account creation failed - Account " + accountNum + " already exists.");
				return;
			}
			else if(accounts.get(i).ssn().equals(ssn) && accounts.get(i).accType() == accountType)
			{
				for(int j = 0; j < totalCustomers; j++)
				{
					if(customers.get(j).customerSsn().equals(ssn))
					{
						System.out.print("Account creation failed - " + customers.get(j).customerName() + " (" + ssn + ") already has a ");
						if(accountType == 1)
						{
							System.out.println("checking account.");
							return;
						}
						else if (accountType == 2)
						{
							System.out.println("savings account.");
							return;
						}
					}
				}
				
			}
		}
		Account temp = new Account(ssn, accountNum, accountType, balance);
		accounts.add(temp);
		System.out.print("Account creation - Number: " + accountNum + ", ");
		for(int i = 0; i < totalCustomers; i++)
		{
			if(customers.get(i).customerSsn().equals(ssn))
			{
				System.out.println("Customer: " + customers.get(i).customerName());
				break;
			}
		}
		totalAccounts++;
		totalBalance += balance;
	}
	public void removeCustomer(String ssn)
	{
		//This method takes a SSN and closes the account of any person with that SSN. If no one with that SSN exists, an error is printed.
		int check = 0;
		for(int i = 0; i < totalCustomers; i++)
		{
			if(customers.get(i).customerSsn().equals(ssn))
			{
				System.out.println("Customer removed - SSN: " + customers.get(i).customerSsn() + ", Customer: " + customers.get(i).customerName());
				customers.remove(i);
				totalCustomers--;
				for(int j = 0; j < totalAccounts; j++)
				{
					if(accounts.get(j).ssn().equals(ssn))
					{
						System.out.print("    Account removed - Number: " + accounts.get(j).accNum() + ", Balance: ");
						System.out.printf("$%.2f", accounts.get(j).balance());
						System.out.println();
						accounts.remove(j);
						totalAccounts--;
					}
				}
				check++;
			}
		}
		if(check == 0)
		{
			System.out.println("Customer remove failed - SSN (" + ssn + ") does not exist.");
		}
	}
	public void closeAccount(int accNum)
	{
		//This method takes an account number and closes any account with a matching account number. If no one with that account number exists, error is printed.
		for(int i = 0; i < totalAccounts; i++)
		{
			if(accounts.get(i).accNum() == accNum)
			{
				System.out.printf("Account closed - Account Number: " + accounts.get(i).accNum() + ", Balance: $%.2f, ",accounts.get(i).balance());
				
				
				for(int j = 0; j < totalCustomers; j++)
				{
					if(customers.get(j).customerSsn().equals(accounts.get(i).ssn()))
					{
						System.out.println("Customer: " + customers.get(j).customerName());
						break;
					}
				}
				accounts.remove(i);
				return;
			}
		}
		
		System.out.println("Account close failed - Account (" + accNum + ") does not exist.");
	}
	public void customerInfoWithSSN(int lastFour)
	{
		/*
		 * This method takes the last four of a SSN and prints any customers that match. If no customers match, prints an error.
		 */
		int aCheck = 0, pCheck = 0, iCheck = 0;
		for(int i = 0; i < totalCustomers; i++)
		{
			if(customers.get(i).lastFour() == lastFour)
			{
				if(iCheck == 0)
				{
					System.out.println("Customers with the last four-digit SSN (" + lastFour +")");
					iCheck++;
				}
				System.out.println("Name: " + customers.get(i).customerName());
				System.out.println("      " + customers.get(i).customerAddress() + ", " + customers.get(i).zip());
				System.out.println("      SSN: " + customers.get(i).customerSsn());
				for(int j = 0; j < totalAccounts; j++)
				{
					if(accounts.get(j).ssn().equals(customers.get(i).customerSsn()))
					{
						if(accounts.get(j).accType() == 1)
						{
							System.out.print("      Checking (" + accounts.get(j).accNum() + "), ");
							System.out.printf("$%.2f", accounts.get(j).balance());
							System.out.println();
							aCheck++;
						}
						else if(accounts.get(j).accType() == 2)
						{
							System.out.print("      Savings (" + accounts.get(j).accNum() + "), ");
							System.out.printf("$%.2f", accounts.get(j).balance());
							System.out.println();
							aCheck++;
						}
					}
				}
				if(aCheck == 0)
				{
					System.out.println("      No Account");
				}
				pCheck++;
			}
		}
		if(pCheck == 0)
		{
			System.out.println("No customer with last four-digit SSN (" + lastFour + ")");
		}
	}
	public void readData(String fileName)
	{
		/*
		 * This method reads data from a file and calls functions to process that data
		 * Return paths: method will return with an error, if file is empty or doesn't exist.
		 * 
		 */
		Scanner readFile = null;
		int control = 0;
		String name, ssn, address, test;
		 
		int accountNum, accType, zipCode;
		double balance;
		
		try
		{
			readFile = new Scanner(new FileInputStream(fileName));
			File file = new File(fileName);
			if(file.length() == 0)
			{
				System.out.println("File empty");
				readFile.close();
				return;
			}
			control = readFile.nextInt();

			
			readFile.nextLine();
			
			
			System.out.println("Read data");
			for(int i = 0; i < control; i++)
			{
				test = readFile.nextLine();
				String[] parts = test.split(",");
				name = parts[0].substring(1, parts[0].length() - 1);
				address = parts[1].substring(1, parts[1].length() - 1);
				zipCode = Integer.parseInt(parts[2]);
				ssn = parts[3].substring(1, 12);
				newCustomer(name, address, zipCode, ssn);
				
			}
			
			control = readFile.nextInt();
			readFile.nextLine();
			
			
			
			for(int i = 0; i < control; i++)
			{			
				test = readFile.nextLine();
				String[] parts = test.split(",");
				ssn = parts[0].substring(1, 12);
				accountNum = Integer.parseInt(parts[1]);
				accType = Integer.parseInt(parts[2]);
				balance = Double.parseDouble(parts[3]);
				
				newAccount(ssn, accountNum, accType, balance);				
			}			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File" + fileName + "was not found, or could not be opened.");
			return;
		}
		readFile.close();
		
	}
	public void bankInfo()
	{
		/*
		 * This method prints all the accounts/customers for a specific bank
		 */
		System.out.println("Bank Name: " + this.name);
		System.out.println("Number of Customers: " + totalCustomers);
		for(int i = 0; i < totalCustomers; i++)
		{
			System.out.println("       " + customers.get(i).customerName() + ": " + customers.get(i).customerSsn());
		}
		System.out.println("Number of Accounts: " + totalAccounts);
		for(int i = 0; i < totalAccounts; i++)
		{
			System.out.printf("       " + accounts.get(i).accNum() + ": $%.2f", accounts.get(i).balance());
			System.out.println();
		}
		System.out.printf("Total Balance: $%.2f", totalBalance);
		System.out.println();
	}
	public void accountInfo(int accNum)
	{
		/*
		 * This method prints any account found for the given Account Number. If no account number is found, an error is printed.
		 */
		int check1 = 0;
		for(int i = 0; i < totalAccounts; i++)
		{
			if(accounts.get(i).accNum() == accNum)
			{
				if(check1 == 0)
				{
					System.out.println("Account Info: ");
					check1++;
				}
				System.out.println("    - Number: " + accounts.get(i).accNum());
				if(accounts.get(i).accType() == 1)
				{
					System.out.println("    - Checking");
				}
				else
				{
					System.out.println("    - Savings");
				}
				System.out.printf("    - Balance: $%.2f", accounts.get(i).balance());
				System.out.println();
				for(int j = 0 ; j < totalCustomers; j++)
				{
					if(customers.get(j).customerSsn().equals(accounts.get(i).ssn()))
					{
						System.out.println("    - Customer: " + customers.get(j).customerName());
						break;
					}
				}
				return;
			}
		}
		System.out.println("Account (" + accNum + ") does not exist.");
	}
}
