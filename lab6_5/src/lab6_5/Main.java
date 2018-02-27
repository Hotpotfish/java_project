package lab6_5;

import java.util.Scanner;
import java.util.Arrays;
 

public class Main {
	static int[] getNumber(String str)
	{
		int i ,k = 0 ,length;
		int Number[] = new int[7];
		char c;
		length = str.length();
		for(i = 0 ; i < length ; i++)
		{
			
			c = str.charAt(i);
			if(c >= 'A' && c <= 'Z')
			{
				if(c == 'A' || c == 'B' || c == 'C')
				{
					Number[k] = 2; 
				}
				else if(c == 'D' || c == 'E' || c == 'F')
				{
					Number[k] = 3;
				}
				else if(c == 'G' || c == 'H' || c == 'I')
				{
					Number[k] = 4;
				}
				else if(c == 'J' || c == 'K' || c == 'L')
				{
					Number[k] = 5;
				}
				else if(c == 'M' || c == 'N' || c == 'O')
				{
					Number[k] = 6;
				}
				else if(c == 'P' || c == 'R' || c == 'S')
				{
					Number[k] = 7;
				}
				else if(c == 'T' || c == 'U' || c == 'V')
				{
					Number[k] = 8;
				}
				else if(c == 'W' || c == 'X' || c == 'Y')
				{
					Number[k] = 9;
				}
				k += 1;
			}
			else if(c >= '0' && c <= '9')
			{
				Number[k] = Integer.parseInt(String.valueOf(str.charAt(i)));
				k += 1;
			}
			
		}
		return Number;
		
	}
	public static void main(String[] args)
	{
		int i ,j ,k;
		int i1;
		int nu ,count;
		int Arr[][];
		int temp[] = new int[7];
		Scanner s = new Scanner(System.in);
		nu = s.nextInt();
		int Nu[] = new int[7];
		Arr = new int[nu][7];
		String str[] = new String[nu];
		for(i = 0 ; i < nu ; i++)
		{	
			str[i] = new String();
			str[i] = s.next();
			Arr[i] = getNumber(str[i]);
		}
		for(i = 0 ; i < nu ; i++)
		{
			for(j = i ; j < nu ; j++ )
			{
				if(Arr[i][0] > Arr[j][0])
				{
					temp = Arr[i];
					Arr[i] = Arr[j];
					Arr[j] = temp;
				} 
			}	
		}
	}
}
			


