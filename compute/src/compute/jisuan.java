package compute;

import java.util.Scanner;
import java.math.*;
public class jisuan {
	public static void main(String args[])
	{
		double xk = 3;
		double xka =xk - (0.25 *xk*(xk - 4))/(0.5 * xk - 1);
		int Inter = 1;
		for(;;)
		{
			if(Math.abs(xka - xk) <= 0.00001)
			{
				break;
			}
			else
			{
				xk = xka;
				xka =xk - (0.25 *xk*(xk - 4))/(0.5 * xk - 1);
				System.out.println(xk);
				Inter++;
			//c 	System.out.println(xk);
				
			}
			
		}		
		System.out.println(Inter);
		return;
	}

}
