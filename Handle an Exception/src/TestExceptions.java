public class TestExceptions 
{
	public static void main(String[] args)
	{
	
		try
		{
			for ( int i = 0; true; i++ )
			{
				System.out.println("args[" + i + "] is '" + args[i] + "'"); 
			} 
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			System.out.println("quitting...");
		}
		
 	} 
} 