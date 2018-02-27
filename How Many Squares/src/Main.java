import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int n;
		int count;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		for(int i = 0 ; i < n ; i++)
		{
			count = 0;
			String str[][];
			int R = 0 , C = 0;
			R = s.nextInt();
			C = s.nextInt();
			str = new String[R][C];
			for(int j = 0 ; j < R ; j++)
			{
				str[j] = new String[C];
				for(int k = 0 ; k < C ; k++)
				{
					str[j][k] = s.next();
				}
			}
			
			
		}
	}

}
