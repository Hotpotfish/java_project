package lab8_2;

import java.util.Scanner;

public class Main {
	public static void main(String []args)
	{
		int n, p1, p2, p3, T1, T2;
		int i, j, k;
		int start[], end[];
		int sum1 = 0 , sum2 = 0 ,sum3 = 0 ;
		int w = 0;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		p1 = s.nextInt();
		p2 = s.nextInt();
		p3 = s.nextInt();
		T1 = s.nextInt();
		T2 = s.nextInt();
		start = new int[n];
		end = new int[n];
		for(i = 0 ; i < n ; i++)
		{
			start[i] = s.nextInt();
			end[i] = s.nextInt();
			sum1 += end[i] - start[i];
		}
		for(i = 0 ; i < n - 1 ; i++)
		{
			int res = 0;
			res = start[i+1] - end[i];
			if(res <= T1)
			{
				sum1 += res;
			}
			else if(res > T1 && res - T1 <= T2)
			{
				sum1 += T1;
				sum2 += res - T1;
				
			}
			else if(res > T2 + T1)
			{
				sum1 += T1;
				sum2 += T2;
				sum3 += res - T2 - T1;
			}
		}
		w = sum1 * p1 + sum2 * p2 + sum3 * p3;
		System.out.println(w);
		
		
	}

}
