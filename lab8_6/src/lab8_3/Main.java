package lab8_3;

import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int T;
		double m , n , a;
		double b1 , b2;
		long res;
		int i , j , k;
		Scanner s = new Scanner(System.in);
		T = s.nextInt();
		for(i = 0 ; i < T ; i ++)
		{
			res = 0;
			b1 = 0;
			b2 = 0;
			n = 0;
			m = 0;
			a = 0;
			n = s.nextInt();
			m = s.nextInt();
			a = s.nextInt();
			if(n / a - (int)(n / a) != 0)
			{
				b1 =(int)(n / a) + 1;
			}
			else if(n % a == 0)
			{
				b1 = n / a;
			}
			if(m / a - (int)(m / a) != 0)
			{
				b2 =(int)(m / a) + 1;
			}
			else if(m % a == 0)
			{
				b2 = m / a;
			}
			res =(long)( b1 * b2);
			System.out.println(res);
			
		}
		
		
		
	}

}
