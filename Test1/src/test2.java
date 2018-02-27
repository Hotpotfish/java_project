
import java.util.Scanner;
public class test2 {
	public static void main(String args[])
	{
		int a1,a2,a3,a4,a5;
		int c1,c2,c3,c4;
		c1 = 1;
		c2 = 0;
		c3 = 0;
		c4 = 1;
		a1 = 1;
		a2 = 0;
		a3 = 0;
		a4 = 0;
		System.out.print("1000");
		for(int i = 0 ; i < 32 ; i++)
		{
			a5 = (c4 * 2 + a1) ^(c3 * 2 + a2) ^(c2 * 2 + a3) ^(c1 * 2 + a4);
			System.out.print(a5);
			a1 = a2;
			a2 = a3;
			a3 = a4;
			a4 = a5;
		}
		
		
		
		
	}
}
