package cryptology;
import java.util.Scanner;
public class TheBlockCipherMode {
	public static void main(String args[])
	{
		String a = "aaaabbbbaaaabbbbaaaabbbbaaaabbbb";
		String a1 = "aaaabbbbaaaabbbb";
		String a2 = "ffffffffffffffff";
		String a3 = "aaaaaaaaaaaaaaaa";
		String a4 = "eafb9a8c0469c6c7";
		
		String a5 = "2d25e87aeb9a50c0d80efd5e33710172";
		System.out.println(yh(a2,a3));
		System.out.println(ECB(a,a1));
		System.out.println(N_ECB(a4,a1));
		System.out.println(CBC(a,a1));
		System.out.println(N_CBC(a4,a1));
		System.out.println(OFB(a,a1));
		System.out.println(OFB(a5,a1));
		System.out.println(PKCS7("4235454654231312321321432423abababa"));
		System.out.println(ISO_9797M2("4235454654231312321321432423abababa"));
		System.out.println(ANSI_X9_23("4235454654231312321321432423abababa"));
		/*for(;;)
		{
			int choose = 0;
			Scanner s = new Scanner(System.in);
			choose = s.nextInt();
			s.next();
			switch(choose)
			{
			case 1:
			case 2:
			case 3:
			
			}
		}*/
		
		
	}
	public static String ECB(String p, String key)  //ECB加密
	{
		StringBuffer re = new StringBuffer();
		if(p.length() % 16 != 0)
		{
			System.out.println("填充长度出错!!!");
			return null;
		}
		if(key.length() != 16)
		{
			System.out.println("秘钥格式错误!!!");
			return null;
		}
		int nu ;
		nu = p.length() / 16;
		String temp[] = new String[nu];
		int round = 0;
		while(round < nu)
		{
			temp[round] = new String();
			temp[round]  = p.substring(round * 16, round * 16 + 16);
			re.append(DES.cp(temp[round],key));
			round ++;
		}
		return re.toString();		
	}
	public static String N_ECB(String p, String key)  //ECB解密
	{
		StringBuffer re = new StringBuffer();
		if(p.length() % 16 != 0)
		{
			System.out.println("填充长度出错!!!");
			return null;
		}
		if(key.length() != 16)
		{
			System.out.println("秘钥格式错误!!!");
			return null;
		}
		int nu ;
		nu = p.length() / 16;
		String temp[] = new String[nu];
		int round = 0;
		while(round < nu)
		{
			temp[round] = new String();
			temp[round]  = p.substring(round * 16, round * 16 + 16);
			re.append(DES.pt(temp[round],key));
			round ++;
		}
		return re.toString();		
	}
	public static String CBC(String p, String key)//CBC模式 加密
	{
		StringBuffer re = new StringBuffer();
		if(p.length() % 16 != 0)
		{
			System.out.println("填充长度出错!!!");
			return null;
		}
		if(key.length() != 16)
		{
			System.out.println("秘钥格式错误!!!");
			return null;
		}
		int nu ;
		nu = p.length() / 16;
		String temp[] = new String[nu];
		int round = 0;
		String temp1 = new String("0000000000000000");//初值
		//String cn = new String();
		while(round < nu)
		{
			temp[round] = new String();
			temp[round]  = p.substring(round * 16, round * 16 + 16);
			temp1 = yh(temp1,temp[round]); 
			re.append(DES.cp(temp1,key));
			round ++;
		}
		return re.toString();	
		
		
	}
	public static String N_CBC(String p, String key)//CBC模式 解密
	{
		StringBuffer re = new StringBuffer();
		if(p.length() % 16 != 0)
		{
			System.out.println("填充长度出错!!!");
			return null;
		}
		if(key.length() != 16)
		{
			System.out.println("秘钥格式错误!!!");
			return null;
		}
		int nu ;
		nu = p.length() / 16;
		String temp[] = new String[nu];
		int round = 0;
		String temp1 = new String("0000000000000000");//初值
		//String cn = new String();
		while(round < nu)
		{
			temp[round] = new String();
			temp[round]  = p.substring(round * 16, round * 16 + 16);
			re.append(yh(DES.pt(temp[round],key),temp1));
			temp1 = temp[round];
			
			round ++;
		}
		return re.toString();	
		
		
	}
	public static String yh(String s0, String s1)
	{
		StringBuffer temp = new StringBuffer();
		if(s0.length() != 16 && s1.length() != 16)
		{
			System.out.println("格式错误，返回");
			return null;
		}
		for(int i = 0 ; i < 16 ; i++)
		{
			int re;
			re = Integer.valueOf(s0.charAt(i)+"",16) ^ Integer.valueOf(s1.charAt(i)+"",16);
			temp.append(Integer.toHexString(re));
		}
		return temp.toString();
		
	}
	public static String OFB(String p ,String key)
	{
		StringBuffer re = new StringBuffer();
		if(p.length() % 16 != 0)
		{
			System.out.println("填充长度出错!!!");
			return null;
		}
		if(key.length() != 16)
		{
			System.out.println("秘钥格式错误!!!");
			return null;
		}
		int nu ;
		nu = p.length() / 16;
		String temp[] = new String[nu];
		int round = 0;
		String temp1 = new String("0000000000000000");//初值
		//String cn = new String();
		while(round < nu)
		{
			temp[round] = new String();
			temp[round]  = p.substring(round * 16, round * 16 + 16);
			re.append(yh(DES.cp(temp1, key),temp[round]));
			temp1 = DES.cp(temp1, key);
			
			round ++;
		}
		return re.toString();	
		
	}
	public static String N_OFB(String p ,String key)
	{
		StringBuffer re = new StringBuffer();
		if(p.length() % 16 != 0)
		{
			System.out.println("填充长度出错!!!");
			return null;
		}
		if(key.length() != 16)
		{
			System.out.println("秘钥格式错误!!!");
			return null;
		}
		int nu ;
		nu = p.length() / 16;
		String temp[] = new String[nu];
		int round = 0;
		String temp1 = new String("0000000000000000");//初值
		//String cn = new String();
		while(round < nu)
		{
			temp[round] = new String();
			temp[round]  = p.substring(round * 16, round * 16 + 16);
			re.append(yh(DES.cp(temp1, key),temp[round]));
			temp1 = DES.cp(temp1, key);
			
			round ++;
		}
		return re.toString();	
		
	}
	
	public static String trebDes(String pt, String key1, String key2)  //三重des
	{
		return DES.cp(DES.pt(DES.cp(pt,key1),key2),key1);
	}
	public static  String PKCS7(String p)//PKCS7填充

	{
		
		if(p.length() % 16 == 0)
		{
			return p;
		}
		else if(p.length() % 2 != 0)
		{
			p = p+"0";
			int nu =0;
			nu =(16 - p.length() % 16)/2;
			for(int i = 0 ; i < nu ; i++)
			{
				p = p + "0"+nu;
			}
			return p;
		}
		else
		{
			int nu =0;
			nu =(16 - p.length() % 16)/2;
			for(int i = 0 ; i < nu ; i++)
			{
				p = p + "0"+nu;
			}
			return p;
			
		}
		
	}
	public static  String ISO_9797M2(String p) //ISO_9797M2

	{
		if(p.length() % 16 == 0)
		{
			return p;
		}
		else
		{
			int nu;
			nu = 16 - p.length() % 16;
			for(int i = 0 ; i < nu ; i++)
			{
				p = p+"0";
			}
			return p;
		}
		
	}
	public static  String ANSI_X9_23(String p)//ANSI_X9_23填充

	{
		
		if(p.length() % 16 == 0)
		{
			return p;
		}
		else if(p.length() % 2 != 0)
		{
			p = p+"0";
			int nu =0;
			nu =(16 - p.length() % 16)/2;
			for(int i = 0 ; i < nu - 1 ; i++)
			{
				p = p + "00";
			}
			p = p + "0" + nu;
			return p;
		}
		else
		{
			int nu =0;
			nu =(16 - p.length() % 16)/2;
			for(int i = 0 ; i < nu - 1 ; i++)
			{
				p = p + "00";
			}
			p = p + "0" + nu;
			return p;
			
		}
		
	}
	
	

}
