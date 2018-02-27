import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		int nu;
		Scanner s = new Scanner(System.in);
		nu = s.nextInt();
		for(int i = 0 ; i <= nu ; i++)
		{
			int space = nu - i;
			for(int j  = 0 ; j < space ; j++)
			{
				System.out.print("  "); 
			}
			for(int j = 0 ; j <= i ; j++)
			{
				System.out.print(j);
				if (0 != i)System.out.print(' ');
			}
			for(int j = i - 1 ; j >= 0 ; j--)
			{
				System.out.print(j);
				if (j != 0)System.out.print(' ');
			}
			System.out.println();
		}
		for(int i = nu - 1 ; i >= 0 ; i--)
		{
			int space = nu - i;
			for(int j = 0 ; j < space ; j++)
			{
				System.out.print("  ");
				
			}
			for(int j = 0 ; j <= i ; j++)
			{
				
				System.out.print(j);
				if (0 != i)System.out.print(' ');
			}
			for(int j = i - 1 ; j >= 0 ; j--)
			{
				System.out.print(j);
				if (j != 0)System.out.print(' ');
			}
			System.out.println();
		}
	}
}
