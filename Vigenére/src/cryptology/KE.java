package cryptology;

public class KE {
	public static void main(String  args[])
	{
		System.out.println(KEC(7,36)[0]+" "+KEC(7,36)[1]);
		
		
	}
	public static int []KEC(int f, int d)
	{
		int big,small;
		if(f > d)
		{
			big  = f;
			small = d;
			
		}
		else
		{
			big = d;
			small = f;
		}
		int x1,x2,x3,y1,y2,y3,q;
		x1 = 1;
		x2 = 0;
		x3 = big;
		y1 = 0;
		y2 = 1;
		y3 = small;
		while(y3 != 0 && y3 != 1)
		{
			
			int t1,t2,t3;
			q = x3 / y3;
			t1 = x1 - q * y1;
			t2 = x2 - q * y2;
			t3 = x3 - q * y3;
			x1 = y1;
			x2 = y2;
			x3 = y3;
			y1 = t1;
			y2 = t2;
			y3 = t3;			
		}
		if(y3 == 0)
		{
			int re[] = new int[2];
			re[0] = x3;
			re[1] = 99999;
			
			return re;
		}
		if(y3 == 1)
		{
			int re[] = new int[2];
			re[0] = y3;
			re[1] = y2;
			return re;
		}
		return null;
		
	}
	public static int gcd(int a, int b)
	{
		int big,small;
		if(a >= b)
		{
			big  = a;
			small = b;
			
		}
		else
		{
			big = b;
			small = a;
		}
		int r = 0;
		int temp;
		while(r != 0)
		{
			r = big % small;
			big = small;	
			temp = small;
			small = r;
			r = temp;
			
		}
		return small;
		
		
	}

}
