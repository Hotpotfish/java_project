package lab8_8;

import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int n;
		
		int i , j , k;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		for(i = 0 ; i < n ; i++)
		{
			int num = 0;
			boolean b = false;
			num = s.nextInt();
			for(j = 1 ; j <= num - 1 ; j++)
			{
				if(j % 2 == 0 && (num - j) % 2 == 0)
				{
					b = true;
					break;
				}
			}
			if(b)
			{
				System.out.println("YES");
				
			}
			else
			{
				System.out.println("NO");
			}
			
		}
		
	}

}
