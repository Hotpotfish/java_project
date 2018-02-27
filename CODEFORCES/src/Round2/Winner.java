package Round2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Winner {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int n;
		Map<String , Integer> map1 = new HashMap<String , Integer>();
		Map<String , Integer> map2 = new HashMap<String , Integer>();
		String name[] = new String[1000000];
		int score[] = new int[1000000];
		n = s.nextInt();
		int count = 1;
		for(int i = 0 ; i < n ; i++)
		{
			int get = 0;
			name[i] = new String();
			name[i] = s.next();
			score[i] = s.nextInt();
			if(map1.get(name[i]) == null)
			{
				map1.put(name[i], 0);
			}
			get = score[i] + map1.get(name[i]);
			map1.put(name[i], get);
		}
		long max = -99999;
		for(Map.Entry<String, Integer> entry:map1.entrySet())
		{
			if(entry.getValue() > max)
			{
				max = entry.getValue();
			}	
		}
		for(int j = 0 ; j < n ; j++)
		{
			if(map2.get(name[j]) == null)
			{
				map2.put(name[j], 0);
			}
			int get = 0;
			get = score[j] + map2.get(name[j]);
			map2.put(name[j], get);
			if(map2.get(name[j]) >= max && map1.get(name[j]) >= max)
			{
				System.out.println(name[j]);
				return;
			}
		}
		
	}

}
