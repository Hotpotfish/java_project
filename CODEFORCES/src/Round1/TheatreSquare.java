package Round1;
import java.util.Scanner;
public class TheatreSquare {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		double n, m, a;
		long re1,re2;
		n = s.nextDouble();
		m = s.nextDouble();
		a = s.nextDouble();
		if(n % a == 0)
		{
			re1 =(int)(n / a);
		}
		else
		{
			re1 = (int)(n / a) + 1;
		}
		if(m % a == 0)
		{
			re2 =(int)(m / a);
		}
		else
		{
			re2 = (int)(m / a) + 1;
		}
		System.out.println(re1 * re2);
		
	}
	

}
