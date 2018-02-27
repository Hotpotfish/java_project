package Round2;

import java.util.Scanner;
public class TheLeastRoundWay {
	public static void main(String args[])
	{
		int x = 91;
		int y = 100;
		int count = 0;
		while(y >0)
		{
			if(x > 100)
			{
				x -= 10 ;
				y --;
				count ++;
			}
			else 
				x ++;
		}
		System.out.println(count);
	}

}
