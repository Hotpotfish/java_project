package lab6_4;

import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String str = "";
		int n1 ,n2;
		int i ,j ,k;
		n1 = s.nextInt();
		for(i = 0 ; i < n1 ; i++)
		{
			int x = 0 ,y = 0;
			int Box[] = new int[3];
			int Pen[] = new int[3];
			Box[0] = 0;
			Box[1] = 1;
			Box[2] = 2;
			n2 = s.nextInt();
			for(j = 0 ; j < n2 ; j++)
			{
				int t;
				str = s.next();
				x = Integer.parseInt(String.valueOf(str.charAt(0))) - 1;
				y = Integer.parseInt(String.valueOf(str.charAt(2))) - 1;
				t = Box[x];
				Box[x] = Box[y];
				Box[y] = t;
			}
			for(k = 0 ; k < 3 ; k++)
			{
				if(Box[k] == 0)
				{
					System.out.println(k+1);
				}
			}	
		}
		
		
	}

}
