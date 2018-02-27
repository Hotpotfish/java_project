import java.io.*;
public class Main {
	public static void main(String args[])
	{
		try
		{
			int count = 0;
			FileWriter fw = new FileWriter("outpu.out");
			FileReader fr = new FileReader("input.in");
			BufferedReader br = new BufferedReader(fr);
			String str = new String();
			String message[] = new String[4];
			while((str = br.readLine()) != null)
			{
				count++;
				if(count != 2)
				{
					continue;
				}
				message = str.split(" ");
			}
			fw.write("<form action=\"JSPÒ³Ãæ\" method=\"post\"" +" ENCTYPE=\"" + message[1] +"\"" + " " + ">" + "\r\n");
			fw.write("	" + "<input type=\"file\"" + message[2] + ">" + "\r\n");
			fw.write("</form>");
			fw.close();
			br.close();
		}
		catch(Exception e)
		{
			
		}
	}

}
