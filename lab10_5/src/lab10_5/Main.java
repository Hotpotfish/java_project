package lab10_5;
import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int n;
		int jump;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		for(int i = 0 ; i < n ; i++)
		{
			int sum = 0;
			jump = 0;
			int nu = 0;
			nu = s.nextInt();
			if(nu == 0)
			{
				System.out.println(0);
				continue;
			}
			else if(nu < 0)
			{
				nu = -nu;
			}
			while(sum < nu)
			{
				jump += 1;
				sum += jump;
			}
			if((sum - nu) % 2 == 0)
			{
				System.out.println(jump);
				continue;
			}
			else if((sum - nu) % 2 != 0 && (jump + 1) % 2 != 0)
			{
				System.out.println(jump+1);
				continue;
			}
			else if((sum - nu) % 2 != 0 && (jump + 1) % 2 == 0 && (jump + 2) % 2 != 0)
			{
				System.out.println(jump+2);
				continue;
			}
			
		}
	}

}