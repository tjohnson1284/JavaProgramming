public class Account2 
{
	//variables
    private String name;
    private int pinCode;
    private double balance;
    
    
    public Account2(String name, int pinCode, double balance)
    {
    	// Constructor when given name, pin, and balance.
        this.name = name;
        this.pinCode = pinCode;
        this.balance = balance;
    }
    
    public boolean deposit(double fund)
    {
    	// Method handles deposits. Returns true if deposit is successful
    	// Returns False if deposit fails.
        if (fund < 0.0) 
        {
            System.out.println("Error: no negative amount to deposit.");
            return false;
        }
		balance += fund;
		return true;
    }
    public boolean deposit(int fund)
    {
    	// Method handles deposits. Returns true if deposit is successful
    	// Returns False if deposit fails.
    	
        if (fund < 0.0) 
        {
            System.out.println("Error: no negative amount to deposit.");
            return false;
        }
		balance += fund;
		return true;
    }
    
    public boolean withdrawal(int fund)
    {
    	// Method handles withdrawals. Returns true if withdrawal is successful
    	// Returns False if withdrawal fails.
        if (fund > balance) 
        {
            System.out.println("Error: insufficient balance to withdraw.");
            return false;
        }
		balance -= fund;
		return true;
    }
    public boolean withdrawal(double fund)
    {
    	// Method handles withdrawals. Returns true if withdrawal is successful
    	// Returns False if withdrawal fails.
    	
        if (fund > balance) 
        {
            System.out.println("Error: insufficient balance to withdraw.");
            return false;
        }
		balance -= fund;
		return true;
    }
    public String accountHolder()
    {
    	//Method that returns the name of the account holder.
    	return this.name;
    }
    public boolean verification(String name, int pinCode)
    {
    	//Method that verifies a given name and pin code correspond to the current account.
    	return (this.name == name && this.pinCode == pinCode);
    }
    public double balance()
    {
    	//Method returns the current account's balance.
    	return this.balance;
    }
    public void printAccount()
    {
    	//Prints the current information for an Account Holder
    	System.out.println("Account Holder Name: " + this.name +  " Account Balance: " + this.balance);
    }
}