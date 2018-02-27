
import java.io.*;
public class Main {

	public static void main(String[] args) {
		File file = new File("output.out");
		
		try
		{
			int i = 1;
			FileWriter fw = new FileWriter(file);
			BufferedReader in = new BufferedReader(new FileReader("input.in")); 
			String s;
			s = in.readLine();
			while(s != null)
			{
				fw.write(i + " " + s + "\n");
				i++;		
				s = in.readLine();
			}
			in.close();
			fw.close();
		}
		catch(IOException e)
		{
			System.out.println("File read error:"+e);
		}
		
	}
	
}
