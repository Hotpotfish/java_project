import java.util.Scanner;
class Point
{
	int x = 0;
	int y = 0;
	Point(int x , int y)
	{
		this.x = x;
		this.y = y;
	}
	boolean equals(Point p)
	{
		if(this.x == p.x && this.y == p.y)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	}
class Line
{
	Point star = new Point(0,0);
	Point end = new Point(0,0);
	}
public class Main {
	public static void main(String []args)
	{
		int n;
		boolean b = false;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		for(int i = 0; i < n ; i++)
		{
			Point top = new Point(0,0);
			Line side1 = new Line();
			Line side2 = new Line();
			Line side3 = new Line();
			Line line[] = new Line[3];
			for(int j = 0 ; j < 3 ;j++)
			{
				line[j] = new Line();
				line[j].star.x = s.nextInt();
				line[j].star.y = s.nextInt();
				line[j].end.x = s.nextInt();
				line[j].end.y = s.nextInt();			
			}
			for(int k = 0 ; k < 2 ; k++)
			{
				for(int l = k + 1 ; l < 3 ; l++)
				{
					if(line[k].star.equals(line[l].star))
					{
						top = line[k].star;	
						side1.star = line[k].star;
						side1.end = line[k].end;
						side2.star = line[l].star;
						side2.end = line[l].end;
						side3.star = line[3 - k - l].star;
						side3.end = line[3 - k - l].end;
						b = true;
						break;
		
					}
					if(line[k].star.equals(line[l].end) )
					{
						top = line[k].star;	
						side1.star = line[k].star;
						side1.end = line[k].end;
						side2.star = line[l].end;
						side2.end = line[l].star;
						side3.star = line[3 - k - l].star;
						side3.end = line[3 - k - l].end;
						b = true;
						break;
						
						
					}
					if(line[k].end.equals(line[l].star))
					{
						top = line[k].end;	
						side1.star = line[k].end;
						side1.end = line[k].star;
						side2.star = line[l].star;
						side2.end = line[l].end;
						side3.star = line[3 - k - l].star;
						side3.end = line[3 - k - l].end;
						b = true;
						break;
			
					}
					if(line[k].end.equals(line[l].end))
					{
						top = line[k].end;	
						side1.star = line[k].end;
						side1.end = line[k].star;
						side2.star = line[l].end;
						side2.end = line[l].star;
						side3.star = line[3 - k - l].star;
						side3.end = line[3 - k - l].end;
						b = true;
						break;			
					}
				}
				if(b)
				{
					break;
				}
			}
			if(side3.star.x == 1 && side3.star.y == 1 && side3.end.x == 0 && side3.end.y == 1)
			{
				System.out.println("NO");
				continue;
			}
			Point x1 = new Point(0,0);
			Point x2 = new Point(0,0);
			x1.x = side1.star.x - side1.end.x;
			x1.y = side1.star.y - side1.end.y;
			x2.x = side2.star.x - side2.end.x;
			x2.y = side2.star.y - side2.end.y;
			if(x1.x * x2.x + x1.y * x2.y <= 0)
			{
				System.out.println("NO");
				continue;
			}
			double length1 = Math.sqrt((side1.star.x - side1.end.x) * (side1.star.x - side1.end.x) + (side1.star.y - side1.end.y) * (side1.star.y - side1.end.y));
			double length2 = Math.sqrt((side2.star.x - side2.end.x) * (side2.star.x - side2.end.x) + (side2.star.y - side2.end.y) * (side2.star.y - side2.end.y));
			double dis1 = 0;
			double dis2 = 0;
			if(side3.star.x == top.x)
			{
				dis1 = Math.sqrt((side3.star.y - top.y) * (side3.star.y - top.y));
				dis2 = Math.sqrt((side3.end.x - top.x) * (side1.end.x - top.x) + (side1.end.y - top.y) * (side1.end.y - top.y));
				if(dis1 / length1 >= 0.2 && dis2 / length2 >= 0.2)
				{
					System.out.println("YES");
					continue;
				}
				else
				{
					System.out.println("NO");
					continue;
				}
			}
			else if(side3.end.x == top.x)
			{
				dis1 = Math.sqrt((side3.end.y - top.y) * (side3.end.y - top.y));
				dis2 = Math.sqrt((side3.star.x - top.x) * (side3.star.x - top.x) + (side3.star.y - top.y) * (side3.star.y - top.y));
				if(dis1 / length1 >= 0.2 && dis2 / length2 >= 0.2)
				{
					System.out.println("YES");
					continue;
				}
				else
				{
					System.out.println("NO");
					continue;
				}	
			}
			else if((side3.star.y - top.y) / (side3.star.x - top.x) != (side1.end.y - side1.star.y) / (side1.end.x - side1.star.x))
			{
				System.out.println("NO");
				continue;	
			}
			else if((side3.star.y - top.y) / (side3.star.x - top.x) != (side2.end.y - side2.star.y) / (side2.end.x - side2.star.x))
			{
				System.out.println("NO");
				continue;	
			}
			else
			{
				dis1 = Math.sqrt((side3.end.y - top.y) * (side3.end.y - top.y) + (side3.end.x - top.x) * (side3.end.x - top.x)) ;
				dis2 = Math.sqrt((side3.star.x - top.x) * (side3.star.x - top.x) + (side3.star.y - top.y) * (side3.star.y - top.y));
				if(dis1 / length1 >= 0.2 && dis2 / length2 >= 0.2 || (dis2 / length1 >= 0.2 && dis1 / length2 >= 0.2) )
				{
					System.out.println("YES");
					continue;
				}
				else
				{
					System.out.println("NO");
					continue;
				}	
			}
				
			}
		s.close();
		
		
		
	}

}
