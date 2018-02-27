package lab9_4;

import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		long n , m;
		int i , j , k;
		Scanner s = new Scanner(System.in);
		m = s.nextInt();
		for(i = 0 ; i < m ; i++)
		{
			n = s.nextLong();
			System.out.print(n + ",");
			do
			{
				if(n % 2 == 0)
				{
					n /= 2;
					if(n != 1)
					System.out.print(n + ",");
				}
				 if(n % 2 == 1 && n != 1)
				{
					n = 3 * n + 1;
					System.out.print(n + ",");
				}
				 if(n == 1)
				{
					System.out.println(1);
				}
			}while(n != 1);
		}
		
		
	}

}
