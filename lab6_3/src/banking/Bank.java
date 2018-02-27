package banking;

public class Bank {
	int numOfCustomers ;
	Customer customer[] = new Customer[2000];
	void addCustomer(String firstname , String lastname )
	{
		customer[numOfCustomers] = new Customer() ;
		customer[numOfCustomers].f = firstname ;
		customer[numOfCustomers].l = lastname ;
		numOfCustomers++ ;
	}
	Customer getCustomer(int cur)
	{
		return customer[cur] ;
	}
	int getNumOfCustomers()
	{
		return numOfCustomers ;
	}

}
