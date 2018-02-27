package banking;

import banking.domain.*;
public class Account {      
    protected double balance = 0.0 ;      
    Account(double init)      
    {
    	balance = init;
    }      
    public double getBalance()      
    {      
        return balance;      
    }
    public void deposit(double amt)
    {
    	balance += amt;	
    }
    public void withdraw(double amt) throws OverdraftException
    {
    	if(balance >= amt)
    	{
    		balance -= amt;
    	}
    	else
    	{
    		throw new OverdraftException("Insufficient funds" , amt - balance);
    	}
    	
    }
      
}    