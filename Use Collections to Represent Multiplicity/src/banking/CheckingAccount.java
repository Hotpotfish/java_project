package banking;
import banking.domain.*;
import banking.*;



public class CheckingAccount extends Account      
{      
   double overdraftProtection ;      
   public CheckingAccount(double balance ,double protect)      
   {      
       super(balance);      
       this.overdraftProtection = protect ;      
   }      
   public CheckingAccount(double balance)      
   {      
       super(balance) ;      
   }
   public void withdraw(double amt) throws OverdraftException{
		if (balance >= amt){
			balance -= amt;
		}
	    else if (balance + overdraftProtection >= amt && balance < amt){
       	overdraftProtection -= amt - balance;
       	balance = 0.0;
       }
       else
       {
       	if (this.overdraftProtection==0) 
       		throw new OverdraftException("No overdraft protection" , amt - (super.getBalance() + overdraftProtection));
       	throw new OverdraftException("Insufficient funds" , amt - (super.getBalance() + overdraftProtection));
       }
}
}