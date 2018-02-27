import java.io.*;

public class Main {
	public static void main(String args[])
	{
		String filename = new String();
		filename = "input.in";
		try
		{
			FileWriter fw = new FileWriter("output.out");
			boolean flag , flag2;
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line = new String();
			flag2 = true;
			int linenum = 0;
			int tem = 0;
			while((line = br.readLine()) != null)
			{
				linenum++;
				int i;
				flag = true;
				for(i = 0 ; i < line.length() - 1 ; i++)
				{
					if(line.charAt(i) == '/' && line.charAt(i+1) == '/')
					{
						flag = false;	
					}
					if(line.charAt(i) == '/' && line.charAt(i+1) == '*')
					{
						tem = linenum;
						flag2 = false;
					}
					if(!flag2 && line.charAt(i) == '*' && line.charAt(i+1) == '/')
					{
						flag2 = true;
						i += 2;
						if (linenum != tem)
						{
							System.out.println();
							fw.write("\r\n");
						}
					}
					if(flag && flag2 && i < line.length())
					{
						System.out.print(line.charAt(i));
						fw.write(String.valueOf(line.charAt(i)));
					}
				}
				if (flag2 && i == line.length() - 1)
				{
					if (flag)
					{
						System.out.print(line.charAt(i));
						fw.write(String.valueOf(line.charAt(i)));
					}
					System.out.println();
					fw.write("\r\n");
				}
			}
			fw.close();
			br.close();
		}
		catch(Exception e)
		{
			
		}
	}

}
