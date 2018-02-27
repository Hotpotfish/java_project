package banking;

import java.util.*;
import banking.*;
public class Bank {      
    List<Customer> list = new ArrayList<Customer>();
    private static Bank instance = new Bank();
    public void sortCustomers()
    {
    	
    }
    public void addCustomer(String firstname , String lastname )      
    {
    	Customer customer = new Customer();
    	customer.f = firstname;
    	customer.l = lastname;
    	list.add(customer);
    }      
    public Customer getCustomer(int cur)      
    {      
        return list.get(cur);      
    }      
    public int getNumOfCustomers()      
    {      
        return list.size() ;      
    }      
    public static Bank getBank()      
    {      
        return instance;      
    }      
    private Bank()      
    {                 
    }      
      
}      