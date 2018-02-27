package banking;

public class Account {
	double balance = 0 ;
	Account(double balance)
	{
		this.balance = balance ;
	}

}

class CheckingAccount extends Account
{
	double interesOrProtect ;
	CheckingAccount(double balance ,double interesOrProtect)
	{
		super(balance);
		this.interesOrProtect = interesOrProtect ;
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
	


