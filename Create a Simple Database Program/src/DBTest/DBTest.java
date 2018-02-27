package DBTest;
import java.util.Scanner;
import java.io.RandomAccessFile;;
class product
{
	String name = "";
	int number = 0;
}
public class DBTest {
	public static void main(String []args) throws Exception
	{
		Scanner s = new Scanner(System.in);
		RandomAccessFile raf = new RandomAccessFile("Database.flat","rw");
		for(;;)
		{
			int n;
			System.out.println("输入1检索产品");
			System.out.println("输入2存入一个产品");
			System.out.println("输入3显示所有产品的信息(按名字数量显示)");
			n = s.nextInt();
			switch(n)
			{
			case 1:
				for(;;)
				{
					String tar = s.nextLine();
					while(raf.readLine() != null)
					{
						String str = raf.readLine();
						String str1[] = str.split(" ");
						if(tar.equals(str1[0]))
						{
							
						}
					}
				}
			}
		}
		
	}

}
