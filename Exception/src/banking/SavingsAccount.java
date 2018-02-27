package banking;

public class SavingsAccount extends Account
{
	double interesOrProtect ;
	public SavingsAccount(double balance ,double interesOrProtect)
	{
		super(balance);
		this.interesOrProtect = interesOrProtect ;
	}
}