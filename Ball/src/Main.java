import java.util.Scanner;

class Lady
{
	int B = 0 , I = 0 , R = 0;
	
}
		
public class Main {
	
	public static void main(String[] args)
	{
		int count  = 0;
		int nu = 0;
		Scanner s = new Scanner(System.in);
		nu = s.nextInt();
		Lady l[] = new Lady[nu];
		for(int i = 0 ; i < nu ; i++)
		{
			l[i] = new Lady();
			l[i].B = s.nextInt();
		}
		for(int i = 0 ; i < nu ; i++)
		{
			l[i].I = s.nextInt();
		}
		for(int i = 0 ; i < nu ; i++)
		{
			l[i].R = s.nextInt();
		}
		for(int i = 0 ; i < nu ; i++)
		{
			for(int j = 0 ; j < nu ; j++)
			{
				if(j != i)
				{
					if(l[i].B < l[j].B && l[i].R < l[j].R && l[i].I < l[j].I)
					{
						
						count ++;
						break;
					}
				}
			}
				
		}
		System.out.println(count);
	}

}
