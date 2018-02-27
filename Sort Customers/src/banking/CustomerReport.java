package banking;

import java.util.*;
import banking.domain.*;
import java.text.NumberFormat;
public class CustomerReport {    
    
	  public void generateReport() {
		  
	    
	    Bank         bank =Bank.getBank();    
	    
	    Customer     customer; 
	    bank.sortCustomers();
	    
	    
	    System.out.println("CUSTOMERS REPORT");    
	    System.out.println("================");    
	    
	    for ( int cust_idx = 0; cust_idx < bank.getNumOfCustomers(); cust_idx++ ) {    
	      customer = bank.getCustomer(cust_idx);    
	    
	      System.out.println();    
	      System.out.println("Customer: "    
	    + "[" + customer.getFirstName() +" "    
	    + customer.getLastName() + "]");    
	    
	      for ( int acct_idx = 0; acct_idx < customer.getNumOfAccounts(); acct_idx++ ) {    
	 Account account = customer.getAccount(acct_idx);    
	 String  account_type = "";    
	    
	 // Determine the account type    
	 if ( account instanceof SavingsAccount ) {    
	   account_type = "Savings Account";    
	 } else if ( account instanceof CheckingAccount ) {    
	   account_type = "Checking Account";    
	 } else {    
	   account_type = "Unknown Account Type";    
	 }    
	    
	 // Print the current balance of the account    
	 System.out.print("    " + account_type + ": current balance is ")   ; 
	    System.out.printf("$%.1f\n",account.getBalance());    
	      }    
	    }    
	  }    
	    
	}  