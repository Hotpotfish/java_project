import java.util.Scanner;
public class test {
	public static void main(String[] args)
	{
		double a,b ,res;
		Scanner s = new Scanner(System.in);
		while(s.hasNext())
		{
			String op1 = null;
			char op2 = ' ';
			res = 0;
			op1 = s.next();
			a = s.nextDouble();
			b = s.nextDouble();
			op2 = op1.charAt(0);
			if( b != 0 && (op2 !='%' || op2 != '/'))
			{
				switch (op2)
				{
				case 42: 
					res = a * b;
					break;
				case 43:
					res = a + b;
					break;
				case 45:
					res = a - b;
					break;
				case 47:
					res = a / b;
					break;
				case 94:
					res = Math.pow(a,b);
					break;
				case 37:
					res = a % b ;
					break;
				default:
					System.out.println("Invalid");
					continue;
				}
				if( (res - (int)res) == 0 )
				{
					System.out.printf("%d\n",(int)res);
				}
				else
				{
					System.out.printf("%.1f\n", res);
				}
			}
			else
			{
				System.out.println("Invalid");
			}
			
		}
		
	}

}
