package lab8_9;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		int d;
		int tri , seg ;
		int i , j , k , l;
		Scanner s = new Scanner(System.in);
		d = s.nextInt();
		for(i = 0 ; i < d ; i++)
		{
			int m = 0 , n = 0 , q = 0 , p = 0;
			tri = 0;
			seg = 0;
			m = s.nextInt();
			n = s.nextInt();
			q = s.nextInt();
			p = s.nextInt();
			if((m+n>p&&m+p>n&&n+p>m)||(m+n>q&&m+q>n&&n+q>m)||(m+p>q&&m+q>p&&p+q>m)||(p+n>q&&n+q>p&&p+q>n))
			{
				System.out.println("TRIANGLE");
			}
			else if((m+n==p)||(m+n==q)||(m+p==q)||(m+p==n)||(m+q==p)||(m+q==n)||(n+p==m)||(n+p==q)||(n+q==p) ||(n+q==m)||(p+q==m)||(p+q==n))
			{
				System.out.println("SEGMENT");
			
			}
			else
			{
				System.out.println("IMPOSSIBLE");
			}
			
		}
		
	}

}
