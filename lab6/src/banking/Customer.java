package banking;

public class Customer {
	int NumOfAccounts ;
	Account accounts[] = new Account[200];
	String f = "" ;
	String l = "" ;
	void addAccount(Account account)
	{
		this.accounts[NumOfAccounts] = new Account(0) ;
		this.accounts[NumOfAccounts] = account ;
		NumOfAccounts++ ;
	}
	Account getAccount(int cur)
	{
		return accounts[cur] ;
		
	}
	String getLastName()
	{
		return l ;
	}
	String getFirstName()
	{
		return f ; 
	}
	int getNumOfAccounts()
	{
		return NumOfAccounts ;
	}
	
}

