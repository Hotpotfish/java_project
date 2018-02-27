package banking.domain;

public class CheckingAccount extends Account
{
	double interesOrProtect ;
	public CheckingAccount(double balance ,double interesOrProtect)
	{
		super(balance);
		this.interesOrProtect = interesOrProtect ;
	}
	public CheckingAccount(double balance)
	{
		super(balance) ;
	}
	
}