import java.io.Serializable;


public class Record implements Serializable {
	private String stringField;
	private int integerField;
	private double doubleField;
	Record(String SF , int IF , double DF)
	{
		this.stringField = SF;
		this.integerField = IF;
		this.doubleField = DF;
	}

	public String getStringField()
	{
		return stringField;
		
	}
	public int getintegerField()
	{
		return integerField;
	}
	public double doubleField()
	{
		return doubleField;
	}
	public String toString()
	{
		return "Record" + "[" + "'" + stringField + "'" +  ", " + integerField + ", " + doubleField + "] ";
	}
	
}
