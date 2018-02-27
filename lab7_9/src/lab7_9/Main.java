package lab7_9;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		int n;
		int count = 0;
		int i , j , k;
		int l = 0;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		s.nextLine();
		Map<String, Integer>  people = new HashMap<String , Integer>();
		for(i = 0 ; i < n ; i++)
		{
			String str = "";
			str = s.nextLine();
			if(str.charAt(0) == '+')
			{
				String str1 = "";
				str1 = str.substring(1);
				if(people.get(str1) == null || people.get(str1) == 0)
				{
					people.put(str1, 1);
					count ++;
					continue;
				}
			}
			else if(str.charAt(0) == '-')
			{
				String str1 = "";
				str1 = str.substring(1);
				if(people.get(str1) == 1)
				{
					people.remove(str1);
					count --;
					continue;
				}
			}
			else
			{
				String str1 = "";
				int mark = 0 , length = 0;
				mark = str.indexOf(":");
				str1 = str.substring(mark + 1);
				length = str1.length();
				l += length * count;
			}
			
		}
		System.out.println(l);
	}

}
