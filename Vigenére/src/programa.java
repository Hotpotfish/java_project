import java.util.Scanner;

public class programa {
	public static  void main(String args[])
	{
		Scanner s= new Scanner(System.in);
		String name, P, D;
		for(;;)
		{
			int K[], choose;
			name = P = D = ""; //初始化明文和密文
			System.out.println("请选择想要的功能");
			System.out.println("1.加密");
			System.out.println("2.解密");
			System.out.println("3.退出");
			
			choose = s.nextInt();
			switch(choose)
			{
				case 1:     //加密
				{
					int m; //秘钥长度
					System.out.println("请输入你的秘钥（全大写）");
					name = s.next();    //键入秘钥
					s.nextLine();
					m = name.length();
					K = new int[m];  //为秘钥确定秘钥空间 转换秘钥；
					char temp;
					for(int i = 0 ; i < m ; i ++)
					{
						temp = name.charAt(i);
						K[i] = temp - 65;
					}  //此时秘钥已转换完成;
					System.out.println("请输入明文");
					String P1;
					P1 = s.nextLine();
					P = P1.replace(" ", "");//明文输入完成 去掉空格
					StringBuffer sb = new StringBuffer();
					int ki = 0;   //读到明文第几个字符
					while(ki < P.length())
					{
						char temp1; //一次加密的字符
						int count = 0;
						count = ki % 6;
						temp =(char)(((K[count] + (int)(P.charAt(ki))) - 65 ) % 26 + 65);
						sb.append(temp); //追加至sb末尾
						ki++;				
					}
					D = new String(sb);
					System.out.println(D);
					break;
				}
				case 2://解密
				{
					int m; //秘钥长度
					System.out.println("请输入你的秘钥（全大写）");
					name = s.next();    //键入秘钥
					s.nextLine();
					m = name.length();
					K = new int[m];  //为秘钥确定秘钥空间 转换秘钥；
					char temp;
					for(int i = 0 ; i < m ; i ++)
					{
						temp = name.charAt(i);
						K[i] = temp - 65;
					}  //此时秘钥已转换完成;
					System.out.println("请输入密文");
					String D1;
					D1 = s.nextLine();
					D = D1.replace(" ", "");//明文输入完成 去掉空格
					StringBuffer sb = new StringBuffer();
					int ki = 0;   //读到明文第几个字符
					while(ki < D.length())
					{
					//	char temp1; //一次解密的字符
						int count = 0;
						count = ki % 6;
						temp =(char)((((int)(D.charAt(ki))) - K[count] + 65 ) % 26 + 65);
						sb.append(temp); //追加至sb末尾
						ki++;				
					}
					P = new String(sb);
					System.out.println(P);
					break;
				}
				case 3:return;
				
				
			
			}
			
			
		}
		
		
		
		
		
		
		
	}

}
