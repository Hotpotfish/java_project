
import java.io.*;
public class timuer {
	public static void main(String []args)
	{
		long score = 0;
		int temp = 0;
		try{
			BufferedReader br = new BufferedReader(new FileReader("in31488.txt"));
			String str[];
			str = br.readLine().split(" ");
			for(int i = 0 ; i < str.length ; i++)
			{
				temp = Integer.parseInt(str[i]);
				score += temp;
			}
			br.close();
			System.out.println(score);
			
		}catch(Exception e)
		{
			
		}
		
	}
	

}
