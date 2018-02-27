import java.util.Scanner;
import java.io.*;
public class DataAnalysis {
	public static void main(String args[])
	{
		File file = new File("terran.noup.thres");
		try
		{
			int count = 0;
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s;
			while(br.read() != -1)
			{
				s = br.readLine();
				count += s.split(" ").length;
			}
			System.out.println(count);
			
		}
		catch(IOException e)
		{
			System.out.println("File read error:"+e);
		}
		
		
	}

}
