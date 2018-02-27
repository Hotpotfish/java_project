package lab7_5;

import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int n , C , R;
		int Arr[] = new int[100];
		int length , countle , re;
		int i , j , k;
		char c;
		String str;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		s.nextLine();
		for(i = 0 ; i < n ; i++)
		{
			re = 0;
			C = 0;
			R = 0;
			countle = 0;
			c = ' ';
			length = 0;
			str ="";
			str = s.next();
			length = str.length();
			for(j = 0 ; j < length ; j++)
			{
				c = str.charAt(j);
				if(c <= 'Z' && c >= 'A')
				{
					countle ++;
				}
			}
			if(countle == 1)
			{
				C = str.charAt(0) - 64;  
	            R = Integer.parseInt(str.substring(1));  
	            System.out.println("R" + R + "C" + C);  
			}
			if(countle == 2)
			{
				if(str.contains("R") && str.contains("C") && str.indexOf('C') - str.indexOf('R') > 1)
				{
					R = Integer.parseInt(str.substring(str.indexOf('R') + 1 , str.indexOf('C')));
					C = Integer.parseInt(str.substring(str.indexOf('C') + 1));
					if(C == 676)
					{
						System.out.println("YZ23");
						return;
					}
					re = C;
					k = 0;
					do{
						Arr[k] = re % 26;
						re = re / 26;
						k += 1;
					}while(re != 0);
					for(j = k - 1 ; j >= 0 ; j--)
					{
						System.out.printf("%s",(char)(Arr[j] + 64));
					}
					System.out.println(R);
				}
				else
				{
					for(j = 0 ; j < length ; j++)
					{
						if(str.charAt(j) <= '9' && str.charAt(j) >= '0')
						{
							c = str.charAt(j);
							break;
						}
					}
					R = Integer.parseInt(str.substring(str.indexOf(c)));
					str = str.substring(0,str.indexOf(c));
					length = str.length();
					int sum = 0;
					for(j = 0; j < length ;j++ )
					{
						sum += (str.charAt(j) - 64) * Math.pow(26,length - j - 1);
					}
					C = sum;
					System.out.println("R" + R + "C" + C);
				}
			}
			if(countle > 2)
			{
				for(j = 0 ; j < length ; j++)
				{
					if(str.charAt(j) <= '9' && str.charAt(j) >= '0')
					{
						c = str.charAt(j);
						break;
					}
				}
				R = Integer.parseInt(str.substring(str.indexOf(c)));
				str = str.substring(0,str.indexOf(c));
				length = str.length();
				int sum = 0;
				for(j = 0; j < length ;j++ )
				{
					sum += (str.charAt(j) - 64) * Math.pow(26,length - j - 1);
				}
				C = sum;
				System.out.println("R" + R + "C" + C);
			}
		}
		
	}

}
