package banking;

import banking.*;
public class CheckingComp  implements Comparable<CheckingAccount> 
{
	public int compareTo(CheckingAccount c1, CheckingAccount c2)
	{
		if(c1.balance > c2.balance)
		{
			return 1;
		}
		else if(c1.balance < c2.balance)
		{
			return -1;
			
		}
		else
		{
			return 0;
		}
	}

}
