package banking;

public class Customer {
	CheckingAccount ca ;
	SavingsAccount sa ;
	String f = "" ;
	String l = "" ;
	String getLastName()
	{
		return l ;
	}
	String getFirstName()
	{
		return f ; 
	}
	SavingsAccount getSavings()
	{
		return sa;
	}
	CheckingAccount getChecking()
	{
		return ca;
	}
	void setSavings(SavingsAccount ssa)
	{
		sa = ssa;
	}
	void setChecking(CheckingAccount sca)
	{
		ca = sca;
	}
	public String toString ()
	{
		return "[" + l + ", " + f + "]";
	}
}

