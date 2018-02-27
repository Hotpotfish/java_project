package whichisbetter;

//import java.util.Scanner;
public class Test {
	public static long mat[][] ;
		/*	{
		{30,35},{35,15},{15,5},{5,10},{10,20},{20,25}
			};*/ //矩阵全局
	public static long mimaben[][];//密码本
	public static void main(String args[])
	{
		for(int i = 1 ; i < 30 ; i++)
		{
			long r1 = 0;
			long r2 = 0;
			buildMatMessage(i);	
			double s1 ,s2,e1,e2;
			s1 = System.currentTimeMillis();
			r1 = m1(0,i - 1);
			e1 = System.currentTimeMillis();
			s2 = System.currentTimeMillis();
		//	r2 = m2(0,i - 1);
			e2 =  System.currentTimeMillis();
			System.out.println((e1 - s1)/1000 +" "   + " " + i);
			
			
			
		}
		
		
		
		
	}
	public static void buildMatMessage(int length)   //简单初始化所有矩阵的行列信息
	{
		mat = new long[length][2];  
		mimaben = new long[length][length];
		for(int i = 0 ; i < length ; i++)   //简单初始化所有矩阵的行列
		{
			mat[i][0] = i+1;
			mat[i][1] = i+2;
			//mimaben[i][i] = 0;              //m(i,i) = 0
			for(int j = 0 ; j < length ; j++)
			{
				mimaben[i][j] = -1;
			}
		}
	}
	public static long m1(int start , int end) //非密码本递归方法
	{
		if(start == end)
		{	
			return 0;//m(i,i) = 0
		}
		long ans = 0, min = 100000000;	
		for(int k = start ; k < end ; k++)
		{
			ans = m1(start, k) + m1(k + 1 , end)
					+ mat[start][0] * mat[k][1] * mat[end][1];
			if(ans  < min)
			{
				min = ans;
			}
			
			
		}
		return min;	
	}
	public static long m2(int start , int end) //密码本递归方法
	{
		
		if(mimaben[start][end] != -1)
		{
			return mimaben[start][end];
		}
		if(start == end)
		{	
			mimaben[start][end] = 0;//m(i,i) = 0
			return 0;
		}
		//if(mimaben)
		long ans = 0, min = 1000000000;
		for(int k = start ; k < end ; k++)
		{
			ans = m2(start, k) + m2(k + 1 , end) + mat[start][0] * mat[k][1] * mat[end][1];
			if(ans  < min)
			{
				min = ans;
			}
			mimaben[start][end] = min;   //更新密码本
			
		}
		return min;	
	}
}
