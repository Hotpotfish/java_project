package lab7_7;

import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int n;
		int count;
		int i , j;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		s.nextLine();
		StringBuffer sb[] = new StringBuffer[n * 2];
		for( i = 0 ; i < n * 2 ; i++)
		{
			String str = new String();
			str = "";
			count = 0;
			str = s.next();
			sb[i] = new StringBuffer(str);
			for(j = 0 ; j <= i ; j++)
			{
				if(sb[i].toString().equals(sb[j].toString()))
				{	
					count ++;
				}
			}
			if(count == 1)
			{
				System.out.println("OK");
			}
			else if(count > 1)
			{
				sb[i + 1] = new StringBuffer();
				sb[i + 1].append(sb[i]);
				sb[i + 1].append(count - 1);
				System.out.println(sb[i+1]);
				i = i+1;
			}
			
		}
	
	}

}
