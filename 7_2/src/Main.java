import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		int count;
		int n;
		int i ,j;
		int length;
		char c;
		String str ;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		for(i = 0 ; i < n ; i++)
		{
			count = 0;
			str = "";
			str = s.next();
			length = str.length();
			for(j = 0 ; j < length ; j++)
			{
				c = str.charAt(j);
				if( c == '4' || c == '7' )
				{
					count++;
				}
			}
			if(count == 4 || count == 7)
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
