import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int n , x0 , count = 0 ,Arr[][];
		int number[] = new int[1000];
		int max = 0 , min = 1000;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		x0 = s.nextInt();
		Arr = new int[n][2];
		for(int i = 0 ; i < n ; i++)
		{
			Arr[i][0] = s.nextInt();
			Arr[i][1] = s.nextInt();
			if(Arr[i][0] > Arr[i][1])
			{
				int temp = Arr[i][0];
				Arr[i][0] = Arr[i][1];
				Arr[i][1] = temp;
			}
			if(Arr[i][0] < min)
			{
				min = Arr[i][0];
			}
			if(Arr[i][1] > max)
			{
				max = Arr[i][1];
			}
		}
		for(int i = min ; i <= max ; i++)
		{
			boolean flag = true;
			for(int j = 0 ; j < n ; j++)
			{
				if(i < Arr[j][0] || i > Arr[j][1])
				{
					flag = false;
				}
			}
			if(flag == true)
			{
				number[count] = i;
				count ++;
			}
		}
		if(count == 0)
		{
			System.out.println("-1");
			return;
		}
		int min1 = number[0] - x0;
		if(min1 < 0)
		{
			min1 = -min1;
		}
		for(int i = 1 ; i < count ; i++)
		{
			if(number[i] - x0 < min1 && number[i] - x0 > -min1)
			{
				min1 = number[i] - x0;
				if(min1 < 0)
				{
					min1 = - min1;
				}
			}
			
		}
		System.out.println(min1);
		
	}

}
