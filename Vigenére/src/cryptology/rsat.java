package cryptology;

public class rsat {
	public static void main(String args[])
	{
		System.out.println(ext_euclid(23,41)[1]);
	}
	public static int []ext_euclid(int a, int b)
	{
		
		int x1,x2,x3,y1,y2,y3,t1,t2,t3,q;
		x1 = 1;
		x2 = 0;
		x3 = a;
		y1 = 0;
		y2 = 1;
		y3 = b;
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
	

	

}
