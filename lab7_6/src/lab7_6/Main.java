package lab7_6;

import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		int n;
		int i , j , k;
		String str[] = new String[10000];
		int score[] = new int[10000];
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		Map<String, Integer>  a = new HashMap<String , Integer>();
		Map<String, Integer>  b = new HashMap<String , Integer>();
		for(i = 0 ; i < n ; i++)
		{
			int sum = 0;
			str[i] = new String();
			score[i] = 0;
			str[i] = s.next();
			score[i] = s.nextInt();
			if( a.get(str[i]) == null)
			{
				a.put(str[i] , 0);
			}
			sum = a.get(str[i]) + score[i];
			a.put(str[i], sum);	
		}
		int maxx = -99999;
		for(i = 0 ; i < n ; i++)
		{
			if(a.get(str[i]) > maxx)
			{
				maxx = a.get(str[i]);
			}
		}
		for(i = 0 ; i < n ; i++)
		{
			int sum = 0;
			if( b.get(str[i]) == null)
			{
				b.put(str[i] , 0);
			}
			sum =b.get(str[i]) + score[i];
			b.put(str[i], sum);
			if(b.get(str[i]) == maxx && a.get(str[i]) == maxx )
			{
				System.out.println(str[i]);
				break;
			}		
		}
	}

}
