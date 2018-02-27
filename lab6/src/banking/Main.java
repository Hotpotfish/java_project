package banking;

import banking.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main{
	

  public static void main(String[] args) {
  Bank bank = new Bank();
  NumberFormat currency_format = NumberFormat.getCurrencyInstance();
  Customer customer;
  int curCustomer = 0;
  Scanner s = new Scanner(System.in);
  int t = s.nextInt();
  s.nextLine();
  // Create several customers and their accounts according to data
  while (t-- > 0) {
   String f = s.next();
   String l = s.next();
   s.nextLine();
   bank.addCustomer(f, l);
   customer = bank.getCustomer(curCustomer++);
   int numAccount = s.nextInt();
   s.nextLine();
   while (numAccount-- > 0) {
    String[] type = s.nextLine().split(" ");
    double balance;
    double interesOrProtect;
    if (type[0].equals("C") || type[0].equals("c")) {
     balance = Double.parseDouble(type[1]);
     if (type.length == 3) {
      interesOrProtect = Double.parseDouble(type[2]);
      customer.addAccount(new CheckingAccount(balance,
        interesOrProtect));
     } else {
      customer.addAccount(new CheckingAccount(balance));
    //  interesOrProtect = Double.parseDouble(type[2]);
     }
    } else if (type[0].equals("S") || type[0].equals("s")) {
     balance = Double.parseDouble(type[1]);
     interesOrProtect = Double.parseDouble(type[2]);
     customer.addAccount(new SavingsAccount(balance,
       interesOrProtect));
    } else if (type[0].equals("A") ||type[0].equals("a")) {
     int cIndex = Integer.parseInt(type[1]);
     int aIndex = Integer.parseInt(type[2]);
     customer.addAccount(bank.getCustomer(cIndex).getAccount(
       aIndex));
    }
   }
  }

    // Generate a report
    System.out.println("CUSTOMERS REPORT");
    System.out.println("================");

    for ( int cust_idx = 0; cust_idx < bank.getNumOfCustomers(); cust_idx++ ) {
      customer = bank.getCustomer(cust_idx);

      System.out.println();
      System.out.println("Customer: "
    + customer.getLastName() + ", "
    + customer.getFirstName());

      for ( int acct_idx = 0; acct_idx < customer.getNumOfAccounts(); acct_idx++ ) {
		Account account = customer.getAccount(acct_idx);
		String  account_type = "";
		 
		if(customer.accounts[acct_idx] instanceof CheckingAccount)
		{
			DecimalFormat df = new DecimalFormat("###,###.00");
			account_type = "Checking Account";
			System.out.print("    " +account_type);
			System.out.print("$");
			String str = df.format(customer.accounts[acct_idx].balance);
			System.out.print(str+"\n");
		}
		else if(customer.accounts[acct_idx] instanceof SavingsAccount)
		{
			DecimalFormat df = new DecimalFormat("###,###.00");
			account_type = "Savings Account";
			System.out.print("    " + account_type);
			System.out.print("$");
			String str = df.format(customer.accounts[acct_idx].balance);
			System.out.print(str+"\n");
		}

      }
    }
  }
}