import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		int n = 0;
		Scanner s  = new Scanner(System.in);
		n = s.nextInt();
		for(int j = 0 ; j < n ; j++)
		{
			int nu , sum = 0;
			nu = s.nextInt();
			for(int i = 2 ; i <= nu - 1 ; i++)
			{
				int a = nu;
				int b = i;
				while(a != 0)
				{
					int temp = a % b;
					a /= b;
					sum += temp;
				}
			}
			int m = sum;
			int n1 = nu - 2;
			while(m % n1 != 0)
			{
				int temp = m % n1;   
	            m = n1;   
	            n1 = temp;   
			}
			
			System.out.println(sum / n1 + "/" + (nu-2) / n1);	
		}
		
	}
	

}
