import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int nu , add;
		int count = 0;
		Scanner s = new Scanner(System.in);
		nu = s.nextInt();
		add = s.nextInt();
		int Arr[] = new int[nu];
		for(int i = 0 ; i < nu ; i++)
		{
			Arr[i] = s.nextInt();
		}
		for(int i = 0 ; i < nu - 1 ; i++)
		{
			while(Arr[i] >= Arr[i+1])
			{
				Arr[i+1] += add;
				count ++;
				
			}
			
		}
		System.out.println(count);
		
	}

}
