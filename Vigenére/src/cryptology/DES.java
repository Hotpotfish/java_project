
package cryptology;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.Integer;


public class DES {
	static Map<Character, String> binaryArray;  	
	static char subkey[][] = new char[16][48];   //暂存子秘钥 16 * 48   2进制存储
	static char subkey16[][] = new char[16][16];   //暂存子秘钥 16 * 48
	static char L[][] = new char[17][32];
	static char R[][] = new char[17][32];
	public static final int PBox[]=
			{
		16,7,20,21,29,12,28,17,
		1,15,23,26,5,18,31,10,
		2,8,24,14,32,27,3,9,
		19,13,30,6,22,11,4,25
			};
	public static final int DES_IP[] =    //明文的ip置换
	    {
	        58, 50, 42, 34, 26, 18, 10, 2, 
	        60, 52, 44, 36, 28, 20, 12, 4,
	        62, 54, 46, 38, 30, 22, 14, 6,
	        64, 56, 48, 40, 32, 24, 16, 8,
	        57, 49, 41, 33, 25, 17, 9, 1,
	        59, 51, 43, 35, 27, 19, 11, 3,
	        61, 53, 45, 37, 29, 21, 13, 5,
	        63, 55, 47, 39, 31, 23, 15, 7
	    };
	public static final int DES_NIP[] =    //明文的ip逆置换
		    {
		        40, 8, 48, 16, 56, 24, 64, 32,
		        39, 7, 47, 15, 55, 23, 63, 31,
		        38, 6, 46, 14, 54, 22, 62, 30,
		        37, 5, 45, 13, 53, 21, 61, 29,
		        36, 4, 44, 12, 52, 20, 60, 28,
		        35, 3, 43, 11, 51, 19, 59, 27,
		        34, 2, 42, 10, 50, 18, 58, 26,
		        33, 1, 41, 9, 49, 17, 57, 25
		    };
	static void setMap()   //16 to 2
	{
	
		binaryArray = new HashMap<Character, String>();
		binaryArray.put('0', "0000");
		binaryArray.put('1', "0001");
		binaryArray.put('2', "0010");
		binaryArray.put('3', "0011");
		binaryArray.put('4', "0100");
		binaryArray.put('5', "0101");
		binaryArray.put('6', "0110");
		binaryArray.put('7', "0111");
		binaryArray.put('8', "1000");
		binaryArray.put('9', "1001");
		binaryArray.put('a', "1010");
		binaryArray.put('b', "1011");
		binaryArray.put('c', "1100");
		binaryArray.put('d', "1101");
		binaryArray.put('e', "1110");
		binaryArray.put('f', "1111");
	}
	public static final int PC1[] =   //pc-1置换表(56)
		{
			57,49,41,33,25,17,9,
			1,58,50,42,34,26,18,
			10,2,59,51,43,35,27,
			19,11,3,60,52,44,36,
			63,55,47,39,31,23,15,
			7,62,54,46,38,30,22,
			14,6,61,53,45,37,29,
			21,13,5,28,20,12,4
		};
	public static final int PC2[] =    //pc-2置换表(48)
		{
			14,17,11,24,1,5,3,28,
			15,6,21,10,23,19,12,4,
			26,8,16,7,27,20,13,2,
			41,52,31,37,47,55,30,40,
			51,45,33,48,44,49,39,56,
			34,53,46,42,50,36,29,32
		};
	public static final int leftmove[] =  //左移表
		{
			1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1
		};
	/*private static String[] binaryArray =     //16 to 2
        {"0000","0001","0010","0011",  
        "0100","0101","0110","0111",  
        "1000","1001","1010","1011",  
        "1100","1101","1110","1111"};*/
	public static final int SBox[][][] =     //S盒的初始化
		{
			{//s1
				{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
				{0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
				{4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
				{15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
			},
			{//s2
				{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
				{3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
				{0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
				{13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
			},
			{//s3
				{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
				{13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
				{13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
				{1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
			},
			{//s4
				{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
				{13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
				{10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
				{3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
			},
			{//s5
				{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
				{14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
				{4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
				{11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
			},
			{//s6
				{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
				{10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
				{9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
				{4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
			},
			{//s7
				{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
				{13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
				{1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
				{6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
			},
			{//s8
				{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
				{1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
				{7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
				{2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
			}
		};
	public static final int RnPlus[] =
			{
				32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10,11,
				12,13,12,13,14,15,16,17,16,17,18,19,20,21,20,21,
				22,23,24,25,24,25,26,27,28,29,28,29,30,31,32, 1,
		
			};
	public static void main(String args[])
	{
		setMap();
		for(;;)
		{
			
			int choose;
			Scanner s = new Scanner(System.in);
			System.out.println("请输入你要录入的功能");
			System.out.println("1.DES加密");
			System.out.println("2.DES解密");
			System.out.println("3.3重DES加密");
			System.out.println("4.退出");
			choose = s.nextInt();
			s.nextLine();
			switch(choose)
			{
				case 1:
				{
					System.out.println("请输入你想要的秘钥!(16位16进制数)");
					String key = new String();
					String LR = new String();
					key = s.next();
					s.nextLine();
					System.out.println("请输入你想要加密的明文");
					LR = s.next();    //获取明文
					s.nextLine();
					System.out.println("加密后的密文为:" + cp(LR,key));
					break;		
				}
				case 2:
				{
					
					System.out.println("请输入你想要的秘钥!(16位16进制数)");
					String key = new String();
					String LR = new String();
					key = s.next();
					s.nextLine();
					System.out.println("请输入你想要解密的密文");
					LR = s.next();    //获取密文
					s.nextLine();
					System.out.println("解密后的明文为:" + pt(LR,key));		
					break;					
				}
				
				case 3:
				{
					System.out.println("输入秘钥K1！");
					String key = new String();
					String key2 = new String();
					String LR = new String();
					key = s.next();
					//s.nextLine();
					System.out.println("输入秘钥K2！");
					key2 = s.next();
					//s.nextLine();
					System.out.println("请输入你想要加密的明文");
					LR = s.next();    //获取密文
					s.nextLine();
					System.out.println("解密后的明文为:" +cp(pt(cp(LR,key),key2),key));	
					
					
					
				}
				default :
					System.out.println("输入错误请重新输入");
					break;	
			}
			//s.close();
		}
		

	}

	public static char []c0d0(String key)   //c0d0生成算法(56)
	{
		//setMap();
		
		if(key.length() != 16)
		{
			System.out.println("输入格式错误请重新输入!");
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < 16 ; i++)               //16 to 2 存入StringBuffer(64)
		{
			char temp;
		    temp = key.charAt(i);
		    sb.append(binaryArray.get(temp));
		  
		}
		char c0d0[] = new char[56];
		for(int i = 0 ; i < 56 ; i++)  //pc-1置换
		{
			c0d0[i] = sb.charAt(PC1[i] - 1);   //
		}
		return c0d0;		
	}
	public static void sk(char []c0d0)   //详细子秘钥生成算法 char(48)  生成第round个秘钥  输入的c0d0为56位

	{
		int round = 1;
		char c[][] = new char[17][28];   //将C0DO存入了其中
		char d[][] = new char[17][28];
		for(int i = 0 ; i < 28 ; i++)  //分成c0 和    d0
		{
			c[0][i] = c0d0[i];
			d[0][i]= c0d0[i+ 28];		
		}
		while(round <= 16)
		{
			for(int i = 0 ; i < 28 ; i++)
			{
				c[round][i] = c[round - 1][(i + leftmove[round - 1] + 28) % 28];  //c和d循环左移
				d[round][i] = d[round - 1][(i + leftmove[round - 1] + 28) % 28];
			}
			char temp[] = new char[56];
			for(int i = 0 ; i < 28 ; i++)   //暂存左移后的CD(56)
			{
				temp[i] = c[round][i];
				temp[i + 28] = d[round][i];
				
			}			
			for(int i = 0 ; i < 48 ; i++)
			{
				subkey[round - 1][i] = temp[PC2[i] - 1];
				
			}
			round ++;	
		}
		//System.out.println("子秘钥生成完毕");	
	}
	public static void changeformat()
	{
		for(int i = 0 ; i < 16 ; i ++)
		{
			String temp = new String();
			temp = String.valueOf(subkey[i]);
		//	temp = Long.toHexString(Long.parseLong(temp,2));
			temp = binaryString2hexString(temp);
			subkey16[i] = temp.toCharArray();
		}
	}
	public static void cmpsk(String key)   //子秘钥生成算法
	{
		sk(c0d0(key));
		changeformat();
		
	}
	public static String binaryString2hexString(String bString)   //2转16函数
	{
		if (bString == null || bString.equals("") || bString.length() % 8 != 0)
			return null;
		StringBuffer tmp = new StringBuffer();
		int iTmp = 0;
		for (int i = 0; i < bString.length(); i += 4)
		{
			iTmp = 0;
			for (int j = 0; j < 4; j++)
			{
				iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
			}
			tmp.append(Integer.toHexString(iTmp));
		}
		return tmp.toString();
	}
	public static String hexString2binaryString(String hexString)  //16 to 2
	{
		if (hexString == null || hexString.length() % 2 != 0)
			return null;
		String bString = "", tmp;
		for (int i = 0; i < hexString.length(); i++)
		{
			tmp = "0000"
					+ Integer.toBinaryString(Integer.parseInt(hexString
							.substring(i, i + 1), 16));
			bString += tmp.substring(tmp.length() - 4);
		}
		return bString;
	}

	public static String pe(String LR)  //对明文加密
	{
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < 64 ; i++)
		{
			sb.append(LR.charAt(DES_IP[i]-1));   
			
		}//得出的经过IP置换变化后的明文
		for(int i = 0 ; i < 32 ; i++)
		{
			L[0][i] = sb.charAt(i);
			R[0][i] = sb.charAt(i + 32);
		} //得出L0R0
		int round = 1;
		while(round <= 16)   
		{
			char f[] = new char[32];
			for(int i = 0 ; i < 32 ; i++)
			{
				L[round][i] = R[round - 1][i];  //Li = Ri-1
			}
			char EA[] = new char[48];
			for(int i = 0 ; i < 48 ; i++)
			{
				EA[i] = R[round - 1][RnPlus[i] - 1];  //32to48
			}
			int B[][] = new int[8][6];
			for(int i = 0 ; i < 8 ; i++)
			{
				for(int j = 0 ; j < 6 ; j++)
				{
					B[i][j] = Integer.parseInt(String.valueOf(EA[j + i * 6]))  ^
							Integer.parseInt(String.valueOf(subkey[round - 1][j + i * 6]));  //作异或
				}
				
			} //B0到B7
			StringBuffer sb1 = new StringBuffer();
			for(int i = 0 ; i < 8 ; i++)
			{
				int r = B[i][0] * 2 + B[i][5];  //行  
				int c = B[i][1] * 8 + B[i][2] * 4 + B[i][3] * 2 + B[i][4];						//列
				int re = SBox[i][r][c];
				sb1.append(binaryArray.get(Integer.toHexString(re).toCharArray()[0]));
			} //为计算出f的过程
			String str = new String(sb1);
			for(int i = 0 ; i < 32 ; i++)
			{
				f[i] = str.charAt(PBox[i] - 1);
			}//f生成完毕
		//	f = str.toCharArray();   //此时f作异或完毕
			for(int i = 0 ; i < 32 ; i++)
			{
				String s = String.valueOf( (Integer.parseInt(String.valueOf(f[i])) ^
						Integer.parseInt(String.valueOf(L[round - 1][i]))));
				R[round][i] = s.charAt(0);
			}
			round ++;
		}
		char L16R16[] = new char[64];
		for(int i = 0 ; i < 32 ; i++)
		{
			L16R16[i] = R[16][i];
			L16R16[i + 32] = L[16][i];	
		}
		
		char NIP[] =new char[64];
		for(int i = 0 ; i < 64 ;i++)
		{
			NIP[i] = L16R16[DES_NIP[i] - 1];
		}
		String str;
		str = String.valueOf(NIP);
		str = binaryString2hexString(str);
		return str;
		
		
		
		
		
	}
    public static String mz2(String LR)
    {
    	StringBuffer sb = new StringBuffer();
    	for(int i = 0 ; i < 16 ; i++)
    	{
    		sb.append(binaryArray.get(LR.charAt(i)));
    	}
    	return sb.toString();
    }

    public static String De(String LR)  //对密文解密
	{
    	StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < 64 ; i++)
		{
			sb.append(LR.charAt(DES_IP[i]-1));   
			
		}//得出的经过IP置换变化后的明文
		for(int i = 0 ; i < 32 ; i++)
		{
			L[0][i] = sb.charAt(i);
			R[0][i] = sb.charAt(i + 32);
		} //得出L0R0
		int round = 1;
		while(round <= 16)   
		{
			char f[] = new char[32];
			for(int i = 0 ; i < 32 ; i++)
			{
				L[round][i] = R[round - 1][i];  //Li = Ri-1
			}
			char EA[] = new char[48];
			for(int i = 0 ; i < 48 ; i++)
			{
				EA[i] = R[round - 1][RnPlus[i] - 1];  //32to48
			}
			int B[][] = new int[8][6];
			for(int i = 0 ; i < 8 ; i++)
			{
				for(int j = 0 ; j < 6 ; j++)
				{
					B[i][j] = Integer.parseInt(String.valueOf(EA[j + i * 6]))  ^
							Integer.parseInt(String.valueOf(subkey[16-round][j + i * 6]));  //作异或
				}
				
			} //B0到B7
			StringBuffer sb1 = new StringBuffer();
			for(int i = 0 ; i < 8 ; i++)
			{
				int r = B[i][0] * 2 + B[i][5];  //行  
				int c = B[i][1] * 8 + B[i][2] * 4 + B[i][3] * 2 + B[i][4];						//列
				int re = SBox[i][r][c];
				sb1.append(binaryArray.get(Integer.toHexString(re).toCharArray()[0]));
			} //为计算出f的过程
			String str = new String(sb1);
			for(int i = 0 ; i < 32 ; i++)
			{
				f[i] = str.charAt(PBox[i] - 1);
			}//f生成完毕
		//	f = str.toCharArray();   //此时f作异或完毕
			for(int i = 0 ; i < 32 ; i++)
			{
				String s = String.valueOf( (Integer.parseInt(String.valueOf(f[i])) ^
						Integer.parseInt(String.valueOf(L[round - 1][i]))));
				R[round][i] = s.charAt(0);
			}
			round ++;
		}
		char L16R16[] = new char[64];
		for(int i = 0 ; i < 32 ; i++)
		{
			L16R16[i] = R[16][i];
			L16R16[i + 32] = L[16][i];	
		}
		
		char NIP[] =new char[64];
		for(int i = 0 ; i < 64 ;i++)
		{
			NIP[i] = L16R16[DES_NIP[i] - 1];
		}
		String str;
		str = String.valueOf(NIP);
		str = binaryString2hexString(str);
		return str;
	}
    public static String cp(String pt, String key)//加密汇总
    {
    	setMap(); 
    	key = key.toLowerCase();   //转换为小写
    	cmpsk(key);   //生成子秘钥
    	pt = pt.toLowerCase();
    	pt = mz2(pt);
    	String res = new String();
		res =pe(pt);
		return res;
    }
    public static String pt(String cp, String key)  //解密汇总
    {
    	setMap() ;
    	key = key.toLowerCase();   //转换为小写
    	cmpsk(key);   //生成子秘钥
    	cp = cp.toLowerCase();
    	cp = mz2(cp);
    	String res = new String();
    	res =De(cp);
    	return res;
    	
    }
}
