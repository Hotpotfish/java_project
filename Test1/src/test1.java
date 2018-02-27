import java.io.*;
public class test1 {
	public static void main(String []args)
	{
		try{
			FileWriter fw = new FileWriter("t2.txt");  
			BufferedReader br = new BufferedReader(new FileReader("t1.txt"));
			String str = "";
			while((str = br.readLine()) != null)
			{
				fw.write(str + "\r");
			}
			fw.close();
			br.close();
		}
		catch(Exception e)
		{
			
		}
	}

}
