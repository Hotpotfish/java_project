import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		int count = 0;
		Scanner s = new Scanner(System.in);
		String chess[] = new String[8];
		for(int i = 0 ; i < 8 ; i++)
		{
			chess[i] = new String();
			chess[i] = s.nextLine();
		}
		for(int i = 0 ; i < 8 ; i++)
		{
			boolean b = true;
			for(int j = 0 ; j < 8 ; j++)
			{
				char c = chess[i].charAt(j);
				if(c == 'W')
				{
					b = false;
					break;
				}
			}
			if(b == true)
			{
				count ++;
			}
		}
		for(int i = 0 ; i < 8 ; i++)
		{
			boolean b = true;
			for(int j = 0 ; j < 8 ; j++)
			{
				char c = chess[j].charAt(i);
				if(c == 'W')
				{
					b = false;
					break;
				}	
			}
			if(b == true)
			{
				count ++;
			}
		}
		if(count == 16)
			count = 8;
		System.out.println(count);
	}
	
}
