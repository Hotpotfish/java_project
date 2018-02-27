package banking.domain;

public class OverdraftException {
	private double  deficit;
	public double getDeficit()
	{
		return deficit;
	}
	public OverdraftException(String  message , double deficit)
	{
		this.deficit = deficit;
	}

}
