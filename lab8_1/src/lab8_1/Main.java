package lab8_1;

import java.util.*;
class Point
{
	int x;
	int y;
	}
public class Main {
	public static void main(String[] args)
	{
		int i , j;
		int R , C;
		String str = "";
		char pre = ' ';
		int count = 0;
		Map<Character , Integer> map = new HashMap<Character,Integer>();
		Scanner s = new Scanner(System.in);
		R = s.nextInt();
		C = s.nextInt();
		str = s.next();
		pre = str.charAt(0);
		char Arr[][] = new char[R][C];
		for(i = 0 ; i < R ; i++)
		{
			str = s.next();
			for(j = 0 ; j < C ; j++ )
			{
				char c = ' ';
				c = str.charAt(j);
				Arr[i][j] = c;
			}
		}
		for(i = 0 ; i < R ; i++)
		{
			for(j = 0 ; j < C ; j++)
			{
				if(Arr[i][j] == pre)
				{
					if(i - 1 >= 0)
					{
						if(Arr[i-1][j] != pre && Arr[i-1][j] != '.' && map.get(Arr[i-1][j]) == null)
						{
							map.put(Arr[i-1][j] , 1);
							count ++;
						}
					}
					if(i + 1 < R)
					{
						if(Arr[i+1][j] != pre && Arr[i+1][j] != '.' && map.get(Arr[i+1][j]) == null)
						{
							map.put(Arr[i+1][j] , 1);
							count ++;
						}
					}
					if(j - 1 >= 0)
					{
						if(Arr[i][j-1] != pre && Arr[i][j-1] != '.' && map.get(Arr[i][j-1]) == null)
						{
							map.put(Arr[i][j-1] , 1);
							count ++;
						}
					}
					if(j + 1 < C)
					{
						if(Arr[i][j+1] != pre && Arr[i][j+1] != '.' && map.get(Arr[i][j+1]) == null)
						{
							map.put(Arr[i][j+1] , 1);
							count ++;
						}
					}
					
				}
			}
		}
		System.out.println(count);
	}

}
