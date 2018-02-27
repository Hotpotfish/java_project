import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int length = 0;
		char c[];
		String str1 = " " , str2 = " ";
		Scanner s = new Scanner(System.in);
		str1 = s.next();
		length = str1.length();
		c = new char[length];
		str2 = s.next();
		for(int i = 0 ; i < length ; i++)
		{
			c[i] = str1.charAt(i);
		}
		
		for(int i = 0 ; i < length - 1 ; i++)
		{
			char temp = ' ';
			for(int j = i + 1 ; j < length; j++)
			{
				if(c[i] > c[j] && i == 0 && c[j] == '0')
					continue;
				if(c[i] > c[j])
				{
					temp = c[i];
					c[i] = c[j];
					c[j] = temp;
				}
			}
		}
		if(c[0] == '0')
		{
			System.out.println("WRONG_ANSWER");
			return;
		}
		for(int i = 0 ; i < length ; i++)
		{
			if(c[i] != str2.charAt(i))
			{
				System.out.println("WRONG_ANSWER");
				return;
			}
		}
		System.out.println("OK");
		
		
		
	}

}
