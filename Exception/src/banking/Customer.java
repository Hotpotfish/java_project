package banking;

import banking.domain.Account;

public class Customer {
	int NumOfAccounts ;
	Account accounts[] = new Account[200];
	String f = "" ;
	String l = "" ;
	public void addAccount(Account account)
	{
		this.accounts[NumOfAccounts] = new Account(0) ;
		this.accounts[NumOfAccounts] = account ;
		NumOfAccounts++ ;
	}
	public Account getAccount(int cur)
	{
		return accounts[cur] ;
		
	}
	public String getLastName()
	{
		return l ;
	}
	public String getFirstName()
	{
		return f ; 
	}
	public int getNumOfAccounts()
	{
		return NumOfAccounts ;
	}
	
}
