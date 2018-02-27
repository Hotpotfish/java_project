import java.util.Scanner;
public class Main {
	public static void main(String [] args)
	{
		int length = 0;
		String str = "";
		Scanner s = new Scanner(System.in);
		str = s.next();
		s.nextLine();
		str = str.toLowerCase();
		StringBuffer sb = new StringBuffer(str);
		length = sb.length();
		for(int i = 0 ; i < length ; i++)
		{
			char c = ' ';
			c = sb.charAt(i);
			if(c == 'A' || c == 'a' || c == 'O' || c == 'o' ||c == 'Y' || c == 'y' ||c == 'E' || c == 'e' ||c == 'U' || c == 'u' ||c == 'I' || c == 'i')
			{
				sb.deleteCharAt(i);
				i -= 1;
			}
			length = sb.length();
		}
		length = sb.length();
		for(int j = 0 ; j < length ; j++)
		{
			System.out.print(".");
			System.out.print(sb.charAt(j));
		}
		System.out.println();
	}

}
