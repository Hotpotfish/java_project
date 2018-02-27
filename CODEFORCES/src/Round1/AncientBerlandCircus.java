package Round1;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.math.*;

class Point
{
	double x = 0;
	double y = 0;
	Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
}
class Computing
{
	double Distance(Point p1, Point p2)
	{
		double re1 = 0;
		double re2 = 0;
		double re = 0;
		re1 = (p1.x - p2.x) * (p1.x - p2.x);
		re2 = (p1.y - p2.y) * (p1.y - p2.y);
		re = Math.sqrt(re1 + re2);
		return re;
		
	}
}
public class AncientBerlandCircus {	
	public static void main(String args[])
	{
		DecimalFormat df=new DecimalFormat("#.000000");
		Scanner s = new Scanner(System.in);
		double x, y;
		double cosa, cosb, cosc;
		double a , b , c;
		Computing co = new Computing();
		Point p1, p2, p3;
		x = s.nextDouble();
		y = s.nextDouble();
		p1 = new Point(x,y);
		x = s.nextDouble();
		y = s.nextDouble();
		p2 = new Point(x,y);
		x = s.nextDouble();
		y = s.nextDouble();
		p3 = new Point(x,y);
		a = co.Distance(p1, p2);
		b = co.Distance(p1, p3);
		c = co.Distance(p2, p3);
		cosa = (b * b  + c * c - a * a) / (2 * b * c);
		cosb = (a * a  + c * c - b * b) / (2 * a * c);
		cosc = (a * a  + b * b - c * c) / (2 * a * b);
		if(cosa == cosb && cosc == cosb && cosb == cosc)
		{
			System.out.println(Math.sqrt(3) * a / 4);
		}
		else if((cosa < 0.001 && cosa >= 0) || (cosb < 0.001 && cosb >= 0) ||(cosc < 0.001 && cosc >= 0))
		{
			if(a > b && a > c)
			{
				System.out.println(df.format(b * c));
			}
			else if(c > b && c > a)
			{
				System.out.println(df.format(a * b));
			}
			else if(b > a && b > c)
			{
					System.out.println(df.format(a * c));
			}
		}
		else if(cosa >= 0.001 && cosb >= 0.001 && cosc >= 0.001)
		{
			double min = 0;
			double anc = 0;
			if(cosa <= cosb && cosa <= cosc)
			{
				min = cosa;
			}
			else if(cosb <= cosa && cosb <= cosc)
			{
				min = cosb;
			}
			else if(cosc <= cosb && cosc <= cosa)
			{
				min = cosc;
			}
			anc = Math.acos(min);
			
		}
		
	
		
		
	}

}
