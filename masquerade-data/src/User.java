//import java.util.Scanner;
import java.io.*;
import java.util.*;

public class User {
	public static void main(String args[]) throws IOException
	{
		double Data[][][] = new double[51][151][857];
		double distan[][] = new double[51][101];
		File file = new File("Data.txt");
		FileWriter fw = new FileWriter(file);
		FileWriter fw1 = new FileWriter("distan.txt");
		Map<String,Integer> map = new HashMap<String,Integer>();
		String s = new String();
		BufferedReader in;
		for(int i = 1 ; i <= 50 ; i++)
		{
			try
			{
				StringBuffer sb = new StringBuffer("User");
				sb.append(i);
				String user = new String(sb);
				in = new BufferedReader(new FileReader(user));
				s = in.readLine();
				while(s != null)
				{
					if(map.get(s) == null)
					{
						map.put(s, 0);
					}
					else if(map.get(s) != null)
					s = in.readLine();
				}
				in.close();
			}	
			catch(IOException e)
			{
				System.out.println("File read error:"+e);
			}
		}//到此为止 是求出了这50个用户总共发出了856条不同的命令
		//System.out.println();	
		System.out.println();
		for(int j = 1 ; j <= 50 ; j++)
		{
			String str = new String();
			StringBuffer sb = new StringBuffer("User");
			sb.append(j);
			String user = new String(sb);
			try
			{
				if(j == 1)
				{
					for (String key : map.keySet()) 
					{
						fw.write(key + " ");
			        }
					fw.write("\n\n");	
				}
				fw.write("User" + j + ":\n");
				in = new BufferedReader(new FileReader(user));
			//	fw.write(user + ":\n");
				for(int k = 1 ; k <= 15000 ; k++)
				{
					if((k % 100) != 0)
					{
						int count;
						str = in.readLine();
						count = map.get(str);
						count++;
						map.put(str, count);
					}
					else if((k % 100) == 0)
					{
						int count;
						str = in.readLine();
						count = map.get(str);
						count++;
						map.put(str, count);
						int data = 1;
						for (String key : map.keySet()) 
						{
							fw.write(((double)(map.get(key))/100) + " ");
							Data[j][(k/100)][data] = map.get(key);
							data++;
							map.put(key, 0);
				        }
						fw.write("\n");	
					}	
				}	
			}
			catch(IOException e)
			{
				System.out.println("File read error:"+e);
			}
			
		}
		fw.close();
		System.out.println();
		for(int i = 1 ; i <= 50 ; i++)
		{
			for(int j = 51 ; j <= 150 ; j++)
			{
				double min = 9999999/1000;
				double dis = 0 ;
				for(int k = 1 ; k <= 50 ; k++)
				{
					for(int l = 1 ; l <= 856 ; l++)
					{
						dis += (Data[i][j][l] - Data[i][k][l]) * (Data[i][j][l] - Data[i][k][l]);
					}
					dis = dis/1000;
					if(min > dis)
					{
						min = dis;
					}
					//distan[i][j - 50] = min;	
				}
				distan[i][j - 50] = min;	
			}
		}
		System.out.println();
		for(int i1 = 1 ; i1 <= 50 ; i1++)
		{
			fw1.write("User" + i1 + "\n\n");
			for(int j1 = 1 ; j1 <= 100 ; j1++)
			{
				/*
				if(i1 == 49)
				{
					System.out.println("1");
				}*/
				fw1.write(j1 + "萌哥傻吊");
				fw1.write(distan[i1][j1] + "\n");			
			}
		}
		System.out.println("运行完成");
		fw1.close();
	}

}
