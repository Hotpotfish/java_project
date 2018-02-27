package lab7_2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		int i , j , k;
		int n , nu , cur1 , cur2;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		for(i = 0 ; i < n ; i++)
		{
			nu = 0;
			cur1 = 0;
			cur2 = 0;
			nu = s.nextInt();
			cur1 = (int)(nu / 4);
			cur2 = nu % 4;
			for(j = 0 ; j < cur1 ; j++)
			{
				System.out.print("abcd");
			}
			if(cur2 == 0)
			{
				System.out.println();
			}
			if(cur2 == 1)
			{
				System.out.println("a");
			}
			if(cur2 == 2)
			{
				System.out.println("ab");
			}
			if(cur2 == 3)
			{
				System.out.println("abc");
			}
		}
		
	}

}
