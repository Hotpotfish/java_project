import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
public class test3 {
	public static void main(String args[])
	{
		Map<String , Integer> map = new HashMap<String , Integer>();
		try
		{
			
			File file = new File("Backup 2015_11_16 (001).SMS");
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");  
			BufferedReader br = new BufferedReader(isr);
			String line = new String();
			
			while((line = br.readLine()) != null)
			{
				
				StringBuffer sb = new StringBuffer();
				for(int i = 0 ; i < line.length() ; i++)
				{
					if(line.charAt(i) != 0)
					{
						sb.append(line.charAt(i));
					}
					
				}
				line = sb.toString();
				//System.out.println(line);
				String s[] = new String[2] ;
				if(line.indexOf("Time") >= 0)
				{
					s[1] = new String();
					s[0] = new String();
					
					s = line.split("=");
					if(s.length == 1)
					{
						continue;
					}
					s[1] = s[1].substring(0,2);
					if(map.get(s[1]) == null)
					{
						map.put(s[1], 1);
						
					}
					else if(map.get(s[1]) != null)
					{
						int count = map.get(s[1]) ;
						map.put(s[1], ++count );
						
					}
					//System.out.println(s[1]);
					
				}
				
			}
			
		}
		
		
		catch(Exception e)
		{
			
		}
		for(Map.Entry<String, Integer> entry:map.entrySet()){ 
	          System.out.println(entry.getKey()+"   "+entry.getValue()); 
		}
		
	}

}
