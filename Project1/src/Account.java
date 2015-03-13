/*
 * This class mostly consists of support for the bank class which accesses it. There are numerous setters/getters and printing methods.
 */
public class Account{
	
	private int accNum;
	private int accType;//1 = Checking, 2 = Saving
	private int lastFourOfSsn;
	private String ssn;
	private double balance;
	

	public Account(String ssn, int accNum, int accType, double balance)
	{
		//Default Constructor
		this.accNum = accNum;
		this.accType = accType;
		this.balance = balance;
		this.ssn = ssn;
		this.lastFourOfSsn = Integer.parseInt(ssn.substring(8, 11));
	}
	
	public int accNum()
	{
		//Returns an accNum
		return accNum;
	}
	public boolean verification(int accNum)
	{
		//Compares a given accNum to current account number
		return this.accNum == accNum;
	}
	public int accType()
	{
		//Returns an accType
		return accType;
	}
	public double balance()
	{
		//Returns a Balance
		return balance;
	}
	public boolean equals(Account acc2)
	{
		//Equals
		return this.ssn.equals(acc2.ssn);
	}
	public String toString()
	{
		//toString
		return (ssn + " " + accNum + " " + accType + " " + balance);
	}
	public int lastfour()
	{
		//Returns the last four of a SSN
		return this.lastFourOfSsn;
	}
	public String ssn()
	{
		//Returns a full SSN
		return ssn;
	}
}
