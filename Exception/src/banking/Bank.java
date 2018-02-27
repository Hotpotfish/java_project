package banking;




public class Bank {
	public int numOfCustomers ;
	private static Bank instance = new Bank();
	Customer customer[] = new Customer[2000];
	public void addCustomer(String firstname , String lastname )
	{
		customer[numOfCustomers] = new Customer() ;
		customer[numOfCustomers].f = firstname ;
		customer[numOfCustomers].l = lastname ;
		numOfCustomers++ ;
	}
	public Customer getCustomer(int cur)
	{
		return customer[cur] ;
	}
	public int getNumOfCustomers()
	{
		return numOfCustomers ;
	}
	public static Bank getBank()
	{
		return instance;
	}
	private Bank()
	{
		
	}

}
