package banking;

import java.util.ArrayList;
import java.util.List;

public class Customer {           
    List<Account> list = new ArrayList<Account>();  
    String f = "" ;      
    String l = "" ;      
    public void addAccount(Account account)      
    {
    	list.add(account);
    }      
    public Account getAccount(int cur)      
    {      
        return list.get(cur) ;      
              
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
        return list.size() ;      
    }
    public String toString()
    {
    	return "[" + f + " " + l + "]";
    }
          
}      