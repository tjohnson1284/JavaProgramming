/*
 * This class supports both the account and bank classes. It is also mostly setters and getters. 
 */
public class Customer {
	
	private String name;
	private int lastFourOfSsn;
	private String ssn;
	private String address;
	private int zipCode;
	
	public Customer(String name, String address, int zipCode, String ssn)
	{
		this.name = name;
		this.ssn = ssn;
		this.lastFourOfSsn = Integer.parseInt(ssn.substring(7, 11));
		this.address = address;
		this.zipCode = zipCode;
	}
	public String customerName()
	{
		//Returns a customer name as a string
		return this.name;
	}
	public String customerAddress()
	{
		//Returns a customer address as a String
		return this.address;
	}
	public String customerSsn()
	{
		//Returns a customer ssn as a String
		return this.ssn;
	}
	public boolean equals(Customer cust2)
	{
		//Equals
		return this.ssn.equals(cust2.ssn);
	}
	public String toString()
	{
		//toString
		return (this.name + " " + this.address + " " + this.zipCode + " " + this.ssn);
	}
	public int lastFour()
	{
		//Returns the last four of a SSN
		return lastFourOfSsn;
	}
	public int zip()
	{
		//Returns a zip code as an int
		return zipCode;
	}

}
