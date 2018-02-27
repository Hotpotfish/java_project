package banking;

public class Account {
	protected double balance ;
	Account(double init_balance)
	{
		this.balance = init_balance ;
	}
	double getBalance()
	{
		return balance;
	}
	boolean deposit(double amt)
	{
		balance += amt;
		return true;
	}
	boolean withdraw(double amt)
	{
		if(balance - amt < 0)
		{
			return false;
		}
		else
		{
			balance -= amt;
			return true;
		}
		
	}

}

class CheckingAccount extends Account
{
	double interesOrProtect ;
	SavingsAccount protectedBy = new SavingsAccount(0,0) ;
	CheckingAccount(double balance ,SavingsAccount protect)
	{
		super(balance);
		protectedBy = protect;
	}
	boolean withdraw(double amt)
	{
		if(balance +protectedBy.balance - amt >= 0 && balance - amt < 0)
		{
			
			protectedBy.balance = balance + protectedBy.balance -amt;
			balance = 0;
			return true;
		}
		else if(balance - amt >= 0)
		{
			balance -= amt;
			return true;
		}
		else
		{
			return false;
		}
	}
	CheckingAccount(double balance)
	{
		super(balance) ;
	}
	
}

class SavingsAccount extends Account
{
	double interesOrProtect ;
	SavingsAccount(double balance ,double interesOrProtect)
	{
		super(balance);
		this.interesOrProtect = interesOrProtect ;
	}
}