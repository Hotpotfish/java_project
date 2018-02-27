package lab8_7;

import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int a , b , c , an;
		Scanner s = new Scanner(System.in);
		while(s.hasNextLine())
		{
			a = s.nextInt();
			b = s.nextInt();
			if(a == 0 && b== 0)
			{
				break;
			}
			c = an = 0;
			while(a != 0 || b != 0)
			{
				c += a % 10 + b % 10;
				a /= 10;
				b /= 10;
				if(c>9)
				{
					an++;
				}
				c /= 10;
				
			}
			if(an == 0)
			{
				System.out.println("No carry operation.");
			}
			else if (an == 1)
			{
				System.out.println("1 carry operation.");
				
			}
			else
			{
				System.out.printf("%d carry operations.\n",an);
			}
		}
	}

}
