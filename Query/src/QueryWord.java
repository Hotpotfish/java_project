import java.io.*;
import java.util.Scanner;
public class QueryWord {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int count = 0;
		Scanner s= new Scanner(System.in);
		//String filename = new String();
		String Queryword = new String();
		Queryword = s.next();
		//filename = s.next();
		try{
			FileWriter fr = new FileWriter("output.out");
			String wordsLine[];
		//	boolean flag = false;
			BufferedReader br = new BufferedReader(new FileReader("test.txt"));
			String str = "";
			while((str = br.readLine()) != null)
			{
				wordsLine = str.split(" ");
				for(int i = 0 ; i < wordsLine.length ; i++)
				{
					StringBuffer sb = new StringBuffer(wordsLine[i]);
					int length = sb.length();
					for(int j = 0 ; j < length ; j++)
					{
						if(sb.charAt(j) < 'A' || sb.charAt(j) > 'z')
						{
							sb.deleteCharAt(j);
						}
						j -= 1;
						length -= 1;
					}
					String str1 = sb.toString();
					if(Queryword.equals(str1))
					{
						count ++;
						
					}
				}
			}
			fr.write(Queryword + " " +count);
			s.close();
			br.close();
			fr.close();
		}
		catch(Exception e)
		{
			
		}

	}

}
