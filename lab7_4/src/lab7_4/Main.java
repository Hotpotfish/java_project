package lab7_4;

import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int i , j , k;
		int n , mark1 , mark2 , mark3 , mark4;
		int R , C ;
		int differ;
		int length , count , count2;
		char c;
		String str;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		s.nextLine();
		for(i = 0 ; i < n ; i++)
		{
			R = 0;
			C = 0;
			mark1 = 0;
			mark2 = 0;
			mark3 = 0;
			mark4 = 0;
			
			count = 0;
			length = 0;
			count2 = 0;
			differ = 0;
			c = ' ';
			str = "";
			str = s.nextLine();
			length = str.length();
			for(j = 0 ; j < length ; j++)
			{
				c = str.charAt(j);
				if(c <= 'Z' && c>= 'A' && count == 0 )
				{
					mark1 = j;
					count ++;
					continue;
				}
				if(c <= 'Z' && c>= 'A' && count == 1)
				{
					mark2 = j;
					count++;
					continue;
				}
				if(c <='Z' && c>= 'A' && count == 2)
				{
					mark4 = j;
					count++;
					
					continue;
				}
				
			}
			if(count == 1)
			{
				C = str.charAt(0) - 64;
				R = Integer.parseInt(str.substring(1));
				System.out.println("R" + R + "C" + C);
			}
			if(count == 2)
			{
				if(mark2 - mark1 == 1)
				{
					C = (str.charAt(0) - 64) * 26 + str.charAt(1) - 64;
					R = Integer.parseInt(str.substring(2));
					System.out.println("R" + R + "C" + C);
				}
				else if(mark2 - mark1 != 1)
				{
					int b = 0 , y = 0;
					for(k = 0 ; k < length ; k++)
					{
						c = str.charAt(k);
						if(c =='C')
						{
							mark3 = k;
							differ = mark3 - 1;
							break;
						}
						
					}
					R = Integer.parseInt(str.substring(1 ,differ+1));
					C = Integer.parseInt(str.substring(mark3+1));
					b = C / 26;
					y = C % 26;
					if(b == 0)
					{
						System.out.printf("%s",(char)(y+64));
						System.out.println(R);
					}
					else if(C < 676)
					{
						System.out.printf("%s%s",(char)(b + 64),(char)(y + 64));
						System.out.println(R);
					}
					else if(C == 676)
					{
						System.out.println("YZ23");
					}
					if(count == 3)
					{
						if(  mark2 - mark1 == 1 && mark4 - mark2 == 1)
						{
							C = (str.charAt(0) - 64) * 26 * 26 + (str.charAt(1) - 64) * 26 + str.charAt(2) - 64 ;
							R = Integer.parseInt(str.substring(3));
							System.out.println("R" + R + "C" + C);
						}
					}
				}
			}
		}
		
	}

}
