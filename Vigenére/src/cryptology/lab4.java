package cryptology;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class lab4 {
	public static void main(String args[])
	{
		//System.out.println(ext_euclid(17,283)[1]);
		System.out.println(modular_exponentitation(23,6,135));
		try
		{
			FileWriter fw = new FileWriter("re.txt");
			for(int i = 100 ; i <= 10000 ; i++)
			{
				fw.write(i + "  " + EL(i) + "\r\n");
				
	
			}
			fw.close();
		//	System.out.println("!!");
			
		}
		catch(Exception e)
		{
			
		}
		
		
		
		
	}
	public static int []ext_euclid(int a, int b)
	{
		int big,small;
		if(a >= b)
		{
			big = a;
			small = b;
			
		}
		else
		{
			big = b;
			small = a;
		}
		int x1,x2,x3,y1,y2,y3,t1,t2,t3,q;
		x1 = 1;
		x2 = 0;
		x3 = big;
		y1 = 0;
		y2 = 1;
		y3 = small;
		int re[] = new int[2];
		while(true)
		{
			if(y3 == 0)
			{
				re[0] = x3;
				re[1] = -999999;
				return re;
			}
			if(y3 == 1)
			{
				re[0] = y3 ;
				re[1] = y2 ;
				return re;
			}
			q = x3 / y3;
			t1 = x1 - q*y1;
			t2 = x2 - q*y2;
			t3 = x3 - q*y3;
			x1 = y1;			
			x2 = y2;
			x3 = y3;
			y1 = t1;
			y2 = t2;
			y3 = t3;		
		}	
	}
	public static int modular_exponentitation(int a, int b, int n)
	{
		int re = 0;
		re = (int)(Math.pow(a, b) % n);
		return  re;	
	}
	public static int EL(int a)
	{
		if(isPrimes(a))
		{
			return a - 1;
		}
		else
		{
			return prCount(a);
			
		}
		
	}
	public static boolean isPrimes(int a)   //判断是不是素数
	{
		if(a < 2)
		{
			return false;
		}
		for(int i = 2 ; i <= a - 1 ; i++)
		{
			if(a % i == 0)
			{
				return false;
			}
		}
		return true;
	
	}
	public static int prCount(int a)  //计算a的欧拉函数结果
	{
		int count = 0;
		for(int i = 1 ; i < a ; i++)
		{
			if(ext_euclid(i,a)[0] == 1)
			{
				count ++;
			}
		}
		return count;		
	}
	
	

}
