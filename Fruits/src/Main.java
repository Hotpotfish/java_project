import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		int sum = 0 , count = 0;
		int n , m;
		int Arr[];
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		Arr = new int[n];
		m = s.nextInt();
		for(int i = 0 ; i < n ; i++)
		{
			Arr[i] = s.nextInt();
		}
		for(int i = 0 ; i < n - 1 ; i++)
		{
			int temp = 0;
			for(int j = i + 1 ; j < n ; j++)
			{
				if(Arr[i] > Arr[j])
				{
					temp = Arr[i];
					Arr[i] = Arr[j];
					Arr[j] = temp;
				}
			}
		}
		Map<String,Integer> map = new TreeMap<String,Integer>();
		for(int i = 0 ; i < m ; i++)
		{
			String str = " ";
			str = s.next();
			if(map.get(str) == null)
			{
				map.put(str,1);
			}
			else if(map.get(str) != 0 || map.get(str) != null)
			{
				int add = map.get(str) + 1;
				map.put(str,add);
			}
		}
		List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>()
				{
			public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) 
			{	
				return (o2.getValue().compareTo(o1.getValue())); 
			}
			});
		 Iterator it= infoIds.iterator();  
		while(it.hasNext())
		{
			
			Map.Entry  mapentry = (Map.Entry) it.next();
			int add =  Integer.parseInt(String.valueOf(mapentry.getValue()));
			sum += add * Arr[count];
			count ++;
		}
		System.out.print(sum);
		System.out.print(" ");
		Iterator it1= infoIds.iterator(); 
		sum = 0;
		while(it1.hasNext())
		{
			
			Map.Entry mapentry = (Map.Entry) it1.next();
			int add =  Integer.parseInt(String.valueOf(mapentry.getValue()));
			sum += add * Arr[n - 1];
			n--;
		}
		System.out.println(sum);	
	}

}
