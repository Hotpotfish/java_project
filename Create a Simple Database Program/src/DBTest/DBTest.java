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
			System.out.println("����1������Ʒ");
			System.out.println("����2����һ����Ʒ");
			System.out.println("����3��ʾ���в�Ʒ����Ϣ(������������ʾ)");
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
