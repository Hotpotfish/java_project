package cryptology;
import java.util.Scanner;
public class AES 
{      //默认为4字的加密
	public static int SBox[][] =      //AES S盒初始化
	{
		{
			0x63, 0x7C, 0x77, 0x7B, 0xF2, 0x6B, 0x6F, 0xC5,
			0x30, 0x01, 0x67, 0x2B, 0xFE, 0xD7, 0xAB, 0x76,
		},
		{
			0xCA, 0x82, 0xC9, 0x7D, 0xFA, 0x59, 0x47, 0xF0,
			0xAD, 0xD4, 0xA2, 0xAF, 0x9C, 0xA4, 0x72, 0xC0,
		},
		{
			0xB7, 0xFD, 0x93, 0x26, 0x36, 0x3F, 0xF7, 0xCC,
			0x34, 0xA5, 0xE5, 0xF1, 0x71, 0xD8, 0x31, 0x15,	
		},
		{
			0x04, 0xC7, 0x23, 0xC3, 0x18, 0x96, 0x05, 0x9A,
			0x07, 0x12, 0x80, 0xE2, 0xEB, 0x27, 0xB2, 0x75,		
		},
		{
			0x09, 0x83, 0x2C, 0x1A, 0x1B, 0x6E, 0x5A, 0xA0,
			0x52, 0x3B, 0xD6, 0xB3, 0x29, 0xE3, 0x2F, 0x84,	
		},
		{
			0x53, 0xD1, 0x00, 0xED, 0x20, 0xFC, 0xB1, 0x5B,
			0x6A, 0xCB, 0xBE, 0x39, 0x4A, 0x4C, 0x58, 0xCF,
		},
		{
			0xD0, 0xEF, 0xAA, 0xFB, 0x43, 0x4D, 0x33, 0x85,
			0x45, 0xF9, 0x02, 0x7F, 0x50, 0x3C, 0x9F, 0xA8,
		},
		{
			0x51, 0xA3, 0x40, 0x8F, 0x92, 0x9D, 0x38, 0xF5,
			0xBC, 0xB6, 0xDA, 0x21, 0x10, 0xFF, 0xF3, 0xD2,
		},
		{
			0xCD, 0x0C, 0x13, 0xEC, 0x5F, 0x97, 0x44, 0x17,
			0xC4, 0xA7, 0x7E, 0x3D, 0x64, 0x5D, 0x19, 0x73,
		},
		{
			0x60, 0x81, 0x4F, 0xDC, 0x22, 0x2A, 0x90, 0x88,
			0x46, 0xEE, 0xB8, 0x14, 0xDE, 0x5E, 0x0B, 0xDB,
		},
		{
			0xE0, 0x32, 0x3A, 0x0A, 0x49, 0x06, 0x24, 0x5C,
			0xC2, 0xD3, 0xAC, 0x62, 0x91, 0x95, 0xE4, 0x79,
		},
		{
			0xE7, 0xC8, 0x37, 0x6D, 0x8D, 0xD5, 0x4E, 0xA9,
			0x6C, 0x56, 0xF4, 0xEA, 0x65, 0x7A, 0xAE, 0x08,
		},
		{
			0xBA, 0x78, 0x25, 0x2E, 0x1C, 0xA6, 0xB4, 0xC6,
			0xE8, 0xDD, 0x74, 0x1F, 0x4B, 0xBD, 0x8B, 0x8A,
		},
		{
			0x70, 0x3E, 0xB5, 0x66, 0x48, 0x03, 0xF6, 0x0E,
			0x61, 0x35, 0x57, 0xB9, 0x86, 0xC1, 0x1D, 0x9E,
		},
		{
			0xE1, 0xF8, 0x98, 0x11, 0x69, 0xD9, 0x8E, 0x94,
			0x9B, 0x1E, 0x87, 0xE9, 0xCE, 0x55, 0x28, 0xDF,
		},
		{
			0x8C, 0xA1, 0x89, 0x0D, 0xBF, 0xE6, 0x42, 0x68,
			0x41, 0x99, 0x2D, 0x0F, 0xB0, 0x54, 0xBB, 0x16
		}
		
	};
	public static int N_SBox[][];		
	public static int allKey[][];
	public static int N_allKey[][];//逆向列混淆后的key
	public static String allKey1[][][];
	public static int RC[] = {0x01,0x02,0x04,0x08,0x10,0x20,0x40,0x80,0x1b,0x36};
	public static void main(String args[])
	{
		
		/*bulidN_SBox();
		
		String se = "328831e0435a3137f6309807a88da234";
		String se1[][] = new String[4][4];
		String key = "2b28ab097eaef7cf15d2154f16a6883c";
		String ke1[][] = new String[4][4];
		ke1 = zh16jg(key);
		addKey(ke1);
		for(int i = 0; i < 4 ; i++)
		{
			for(int j = 0 ; j < 44 ; j++)
			{
				System.out.print(Integer.toHexString(allKey[i][j]) + " ");
			}
			System.out.println();
		}
		
		se1 = zh16jg(se);
		se1 = addRoundKey(se1,0);
		se1 = SBoxReplace(se1);
		se1 = ShiftRows(se1);
		se1 = MixColumns(se1);
		se1 = N_SBoxReplace(se1);
		se1 = N_ShiftRows(se1);
		se1 = N_MixColumns(se1);
		se1  = MixColumns(se1);
		int a = 0x57;
		int b = 0x83;
		int re = gfMul2(a,b);
		//System.out.println(0x32 ^ 0x2b);
		*/
		for(;;)
		{
			int choose;
			Scanner s = new Scanner(System.in);
			System.out.println("请输入你想要的功能");
			System.out.println("1.AES加密");
			System.out.println("2.AES解密");
			System.out.println("3.退出");
			
			choose = s.nextInt();
			
			switch(choose)
			{
				
				case 1:
				{
					System.out.println("请输入你想要加密的明文");
					String mw = new String();
					mw = s.next();
					System.out.println("请输入你想要加密的秘钥");
					String key = new String();
					key = s.next();
					System.out.println("加密后的密文为：" + cp(mw,key));	
					break;
				}
				case 2:  //解密未完成
				{
					System.out.println("请输入你想要解密的密文");
					String mw = new String();
					mw = s.next();
					System.out.println("请输入你想要解密的秘钥");
					String key = new String();
					key = s.next();
					System.out.println("解密后的明文为：" + pt(mw,key));	
					break;
				}	
				case 3:
					return;
					
					default:
					{
						System.out.println("输入错误请重新输入！！！");
						break;
						
					}
			
			}
			
		}
		
		//getN_allKey();
	//System.out.println("加密后的密文为：" + pt("3902dc1925dc116a8409850b1dfb9732","2b28ab097eaef7cf15d2154f16a6883c"));
	/*	for(int i = 0; i < 4 ; i++)
		{
			for(int j = 0 ; j < 44 ; j++)
			{
				System.out.print(Integer.toHexString(allKey[i][j]) + " ");
			}
			System.out.println();
		}*/
	}
	public static String [][]zh16jg(String in)   //将String类型的字符串转换为4*4字节的矩阵返回为String矩阵
	{
		
			//System.out.println("16字节矩阵转换!\n");
			StringBuffer temp1[] = new StringBuffer[16];
			for(int i = 0 ; i < 32 ; i++)
			{
				char c = in.charAt(i);
				int number = i / 2;
				if(temp1[number] == null)
				{
					temp1[number] = new StringBuffer();
				}
				temp1[number].append(c);		
			}
			String temp2[][] = new String[4][4];
			for(int i = 0 ; i < 4 ; i++)
			{
				for(int j = 0 ; j < 4 ; j++)
				{
					temp2[i][j] = temp1[i * 4 + j].toString();
				}
			}
			return temp2;				
	}
	public static String [][]SBoxReplace(String in[][])  //S盒代换
	{
		int inr,inw;
		inr = in.length;
		inw = in[0].length;
		StringBuffer temp[][] = new StringBuffer[inr][inw];
		for(int i = 0 ; i < inr ; i++)
		{
			for(int j = 0 ; j < inw ; j++)
			{
				int r,w;
				r = Integer.parseInt(in[i][j].charAt(0)+ "",16);
				w = Integer.parseInt(in[i][j].charAt(1)+ "",16);
				temp[i][j] = new StringBuffer();
				temp[i][j].append(Integer.toHexString(SBox[r][w]));
			}
		}
		String re[][] = new String[4][4];
		for(int i = 0 ; i < inr ; i++)
		{
			for(int j = 0 ; j < inw ; j++)
			{
				re[i][j] = temp[i][j].toString();
				
			}
		}
		return re;
		
	}
	public static String [][]N_SBoxReplace(String in[][])  //逆S盒代换
	{
		int inr,inw;
		inr = in.length;
		inw = in[0].length;
		StringBuffer temp[][] = new StringBuffer[inr][inw];
		for(int i = 0 ; i < 4 ; i++)
		{
			for(int j = 0 ; j < 4 ; j++)
			{
				int r,w;
				if(in[i][j].length() == 1)
				{
					in[i][j] = "0".concat(in[i][j]);
				}
				
				r = Integer.parseInt(in[i][j].charAt(0)+ "",16);
				w = Integer.parseInt(in[i][j].charAt(1)+ "",16);
				temp[i][j] = new StringBuffer();
				temp[i][j].append(Integer.toHexString(N_SBox[r][w]));
			}
		}
		String re[][] = new String[4][4];
		for(int i = 0 ; i < inr ; i++)
		{
			for(int j = 0 ; j < inw ; j++)
			{
				re[i][j] = temp[i][j].toString();
				
			}
		}
		return re;
		
	}
	public static String [][]ShiftRows(String in[][])   //行变换
	{
		String temp[][] = new String[4][4];
		
		for(int i = 0 ; i < 4 ; i++)
		{
			for(int j = 0 ; j < 4 ; j++)
			{
				temp[i][j] = new String();
				temp[i][j] = in[i][(j + i + 4) % 4];
			}
			
		}
		return temp;	
	}
	public static String [][]N_ShiftRows(String in[][])   //逆行变换
	{
		String temp[][] = new String[4][4];
		
		for(int i = 0 ; i < 4 ; i++)
		{
			for(int j = 0 ; j < 4 ; j++)
			{
				temp[i][j] = new String();
				temp[i][j] = in[i][(j - i + 4) % 4];
			}
			
		}
		return temp;	
	}
	public static String [][]MixColumns(String in[][])  //列混淆
	{
		String temp[][] = new String[4][4];
		for(int i = 0 ; i < 4 ; i++)
		{
			temp[0][i] = new String();
			temp[0][i] = Integer.toHexString(gfMul2(Integer.valueOf(in[0][i],16),2) ^ gfMul2(Integer.valueOf(in[1][i],16),3) ^
					Integer.valueOf(in[2][i],16) ^ Integer.valueOf(in[3][i],16));
			temp[1][i] = new String();
			temp[1][i] = Integer.toHexString(Integer.valueOf(in[0][i],16) ^ gfMul2(Integer.valueOf(in[1][i],16),2) ^
					gfMul2(Integer.valueOf(in[2][i],16),3) ^ Integer.valueOf(in[3][i],16));
			temp[2][i] = new String();
			temp[2][i] = Integer.toHexString(Integer.valueOf(in[0][i],16) ^  Integer.valueOf(in[1][i],16) ^
					gfMul2(Integer.valueOf(in[2][i],16),2) ^ gfMul2(Integer.valueOf(in[3][i],16),3));
			temp[3][i] = new String();
			temp[3][i] = Integer.toHexString(gfMul2(Integer.valueOf(in[0][i],16),3) ^ Integer.valueOf(in[1][i],16) ^
					Integer.valueOf(in[2][i],16) ^ gfMul2(Integer.valueOf(in[3][i],16),2));
		}
		return temp;
		
		
	}
	public static String [][]N_MixColumns(String in[][])  //逆向列混淆
	{
		String temp[][] = new String[4][4];
		for(int i = 0 ; i < 4 ; i++)
		{
			temp[0][i] = new String();
			temp[0][i] = Integer.toHexString(gfMul2(Integer.valueOf(in[0][i],16),0x0e) ^ gfMul2(Integer.valueOf(in[1][i],16),0x0b) ^
					gfMul2(Integer.valueOf(in[2][i],16),0x0d) ^ gfMul2(Integer.valueOf(in[3][i],16),0x09));
			temp[1][i] = new String();
			temp[1][i] = Integer.toHexString(gfMul2(Integer.valueOf(in[0][i],16),0x09) ^ gfMul2(Integer.valueOf(in[1][i],16),0x0e) ^
					gfMul2(Integer.valueOf(in[2][i],16),0x0b) ^ gfMul2(Integer.valueOf(in[3][i],16),0x0d));
			temp[2][i] = new String();
			temp[2][i] = Integer.toHexString(gfMul2(Integer.valueOf(in[0][i],16),0x0d) ^  gfMul2(Integer.valueOf(in[1][i],16),0x09) ^
					gfMul2(Integer.valueOf(in[2][i],16),0x0e) ^ gfMul2(Integer.valueOf(in[3][i],16),0x0b));
			temp[3][i] = new String();
			temp[3][i] = Integer.toHexString(gfMul2(Integer.valueOf(in[0][i],16),0x0b) ^ gfMul2(Integer.valueOf(in[1][i],16),0x0d) ^
					gfMul2(Integer.valueOf(in[2][i],16),0x09) ^ gfMul2(Integer.valueOf(in[3][i],16),0x0e));
		}
		return temp;
		
		
	}
	public static int gfMul(String in, int b)//伽罗华域计算
	{
		String temp1 = new String();
		temp1 = hexString2binaryString(in);
		StringBuffer temp2 = new StringBuffer();
		if(b == 2)
		{
			if(temp1.charAt(0) =='0')
			{
				for(int i = 0 ; i < 7 ; i++)
				{
					temp2.append(temp1.charAt(i+1));
				}
				temp2.append(0);
				String temp3 = new String(temp2);
				return Integer.valueOf(temp3,2);
			}
			else if(temp1.charAt(0) == '1')
			{
				for(int i = 0 ; i < 7 ; i++)
				{
					temp2.append(temp1.charAt(i+1));
				}
				temp2.append(0);
				String temp3 = new String(temp2);
				int re;
				re = Integer.valueOf(temp3,2) ^ 0x1b;
				return re;
			}
		}
		else if(b == 3)
		{
			if(temp1.charAt(0) =='0')
			{
				for(int i = 0 ; i < 7 ; i++)
				{
					temp2.append(temp1.charAt(i+1));
				}
				temp2.append(0);
				String temp3 = new String(temp2);
				int re;
				re = Integer.valueOf(temp3,2) ^ Integer.valueOf(temp1,2);
				return re;
			}
			else if(temp1.charAt(0) == '1')
			{
				for(int i = 0 ; i < 7 ; i++)
				{
					temp2.append(temp1.charAt(i+1));
				}
				temp2.append(0);
				String temp3 = new String(temp2);
				int re;
				re = Integer.valueOf(temp3,2) ^ 0x1b ^ Integer.valueOf(temp1,2);
				
				return re;
			}	
		}
		return -1;	
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
	public static void addKey(String key[][])   //秘钥生成
	{
		allKey = new int[4][44];
		for(int i = 0 ; i < 4 ; i++)
		{
			for(int j = 0 ; j < 4 ; j++)
			{
				allKey[i][j] = Integer.parseInt(key[i][j],16);
			}
		}
		for(int i = 4 ; i < 44 ;i++)
		{
			String wi[] = new String[4];
			if(i % 4 == 0)
			{
				String wi_4[] = new String[4];
				wi_4[0] = new String();
				wi_4[0] = Integer.toHexString(allKey[0][i - 4]);
				wi_4[1] = new String();
				wi_4[1] = Integer.toHexString(allKey[1][i - 4]);
				wi_4[2] = new String();
				wi_4[2] = Integer.toHexString(allKey[2][i - 4]);
				wi_4[3] = new String();
				wi_4[3] = Integer.toHexString(allKey[3][i - 4]);
				wi[0] = new String();
				wi[0] = Integer.toHexString(allKey[1][i - 1]);
				wi[1] = new String();
				wi[1] = Integer.toHexString(allKey[2][i - 1]);
				wi[2] = new String();
				wi[2] = Integer.toHexString(allKey[3][i - 1]);
				wi[3] = new String();
				wi[3] = Integer.toHexString(allKey[0][i - 1]);//列移位完成
				for(int j = 0 ; j < 4 ; j++)
				{
					if(wi[j].length() == 1)
					{
						wi[j] = "0".concat(wi[j]); //一位的补零		
					}
				}
				for(int j = 0 ; j < 4 ; j++)   //S盒代换
				{
					int r,w;
					r =Integer.valueOf(wi[j].charAt(0) + "",16); 
					w = Integer.valueOf(wi[j].charAt(1) + "",16);
					wi[j] = Integer.toHexString(SBox[r][w]);
				}
				allKey[0][i] = Integer.valueOf(wi_4[0],16) ^ Integer.valueOf(wi[0],16) ^ RC[i / 4 - 1];
				allKey[1][i] = Integer.valueOf(wi_4[1],16) ^ Integer.valueOf(wi[1],16) ^ 0x0;
				allKey[2][i] = Integer.valueOf(wi_4[2],16) ^ Integer.valueOf(wi[2],16) ^ 0x0;
				allKey[3][i] = Integer.valueOf(wi_4[3],16) ^ Integer.valueOf(wi[3],16) ^ 0x0;	
			}
			else
			{
				String wi_4[] = new String[4];
				wi_4[0] = new String();
				wi_4[0] = Integer.toHexString(allKey[0][i - 4]);
				wi_4[1] = new String();
				wi_4[1] = Integer.toHexString(allKey[1][i - 4]);
				wi_4[2] = new String();
				wi_4[2] = Integer.toHexString(allKey[2][i - 4]);
				wi_4[3] = new String();
				wi_4[3] = Integer.toHexString(allKey[3][i - 4]);
				wi[0] = new String();
				wi[0] = Integer.toHexString(allKey[0][i - 1]);
				wi[1] = new String();
				wi[1] = Integer.toHexString(allKey[1][i - 1]);
				wi[2] = new String();
				wi[2] = Integer.toHexString(allKey[2][i - 1]);
				wi[3] = new String();
				wi[3] = Integer.toHexString(allKey[3][i - 1]);
				allKey[0][i] = Integer.valueOf(wi_4[0],16) ^ Integer.valueOf(wi[0],16);
				allKey[1][i] = Integer.valueOf(wi_4[1],16) ^ Integer.valueOf(wi[1],16);
				allKey[2][i] = Integer.valueOf(wi_4[2],16) ^ Integer.valueOf(wi[2],16);
				allKey[3][i] = Integer.valueOf(wi_4[3],16) ^ Integer.valueOf(wi[3],16);	
			}
		}
		
		
	}
	public static int gfMul2(int a, int b)   //通用伽罗华域运算

	{
		String in1 = new String();
		String in2 = new String();
		String all[] = new String[8];
		if(Integer.toHexString(a).length() == 1)
		{
			String s = new String();
			s = "0".concat(Integer.toHexString(a));
			in1 = hexString2binaryString(s);
		}
		else
		{
			in1 = hexString2binaryString(Integer.toHexString(a));   //将a,b转化为8位2进制
		}
		if(Integer.toHexString(b).length() == 1)
		{
			String s = new String();
			s = "0".concat(Integer.toHexString(b));
			in2 = hexString2binaryString(s);
		}
		else
		{
			in2 = hexString2binaryString(Integer.toHexString(b));
		}
	//	in1 = hexString2binaryString(Integer.toHexString(a));   //将a,b转化为8位2进制
		//in2 = hexString2binaryString(Integer.toHexString(b));
		for(int i = 0 ; i < 8 ; i++)
		{
			
			if(i == 0)
			{
				all[i] = new String();
				all[i] = in1;
			}
			else
			{
				StringBuffer temp = new StringBuffer();
				if(all[i - 1].charAt(0) == '0')   //左移补0
				{
					for(int j = 0 ; j < 7 ; j++)
					{
						temp.append(all[i - 1].charAt(j + 1));
					}
					temp.append(0);
					all[i] = new String(temp);
				}
				else if(all[i - 1].charAt(0) == '1')
				{
					for(int j = 0 ; j < 7 ; j++)
					{
						temp.append(all[i - 1].charAt(j + 1));
					}
					temp.append(0);
					String temp2 = new String(temp);
					int re ;
					re = Integer.valueOf(temp2,2) ^ 0x1b; //异或
					all[i] = new String();
					
					if(Integer.toHexString(re).length() == 1)
					{
						String s = new String();
						s ="0".concat(Integer.toHexString(re));
						all[i] = hexString2binaryString(s);
					}
					else
					all[i] = hexString2binaryString(Integer.toHexString(re));
				}
			}	
		}
		int sum = 0;
		boolean bo = false;
		for(int i = 7 ; i >= 0 ; i--)
		{
			if(in2.charAt(i) == '1' && bo == false)
			{
				sum = Integer.valueOf(all[7 - i],2);
				bo = true;
			}
			else if(in2.charAt(i) == '1' && bo == true)
			{
				sum = sum ^ Integer.valueOf(all[7 - i],2);
			}			
		}
		return sum;		
	}
	public static String [][]addRoundKey(String in[][], int round)  //明文秘钥异或过程 
	{
		String out[][] = new String[4][4];
		for(int i = 0 ; i < 4 ; i++)
		{
			for(int j = 0 ; j < 4 ; j++)
			{
				out[i][j] = new String();
				out[i][j] = Integer.toHexString(Integer.valueOf(in[i][j],16) ^ allKey[i][j + round * 4]);
				if(out[i][j].length() == 1)
				{
					out[i][j] = "0".concat(out[i][j]);
				}
			}	
		}
		return out;
	}
	public static String [][]N_addRoundKey(String in[][], int round)  //密文秘钥异或过程 
	{
		String out[][] = new String[4][4];
		for(int i = 0 ; i < 4 ; i++)
		{
			for(int j = 0 ; j < 4 ; j++)
			{
				out[i][j] = new String();
				out[i][j] = Integer.toHexString(Integer.valueOf(in[i][j],16) ^ N_allKey[i][j + round * 4]);
				if(out[i][j].length() == 1)
				{
					out[i][j] = "0".concat(out[i][j]);
				}
			}	
		}
		return out;
	}
	public static String cp(String pt, String key)   //加密函数汇总
	{
		pt = pt.toLowerCase();
		key = key.toLowerCase();
		int round = 0;
		if(pt.length() != 32 || key.length() != 32)
		{
			System.out.println("明文或秘钥格式错误");
			return null;
		}
		else
		{
			addKey(zh16jg(key)); //生成全局秘钥
			String pt1[][] = new String[4][4];
			pt1 = zh16jg(pt);
			pt1 = addRoundKey(pt1,round);
			
			for(int i = 0 ; i < 9 ; i++)
			{
				round ++;
				
				pt1 = SBoxReplace(pt1);
				pt1 = ShiftRows(pt1);
				pt1 = MixColumns(pt1);
				pt1 = addRoundKey(pt1,round);			
			}
			round ++;
			pt1 = SBoxReplace(pt1);
			pt1 = ShiftRows(pt1);
			pt1 = addRoundKey(pt1,round);
			String re = new String();
			for(int i = 0 ; i < 4 ; i++)
			{
				for(int j = 0 ; j < 4 ; j++)
				{
					re = re.concat(pt1[i][j]);
				}
			}
			return re;
		}
	}
	public static String pt(String cp, String key)   //解密函数汇总
	{
		key = key.toLowerCase();
		cp = cp.toLowerCase();
		bulidN_SBox();
		getN_allKey();
		int round = 0;
		if(cp.length() != 32 || key.length() != 32)
		{
			System.out.println("密文或秘钥格式错误");
			return null;
		}
		else
		{
			addKey(zh16jg(key)); //生成全局秘钥
			String pt1[][] = new String[4][4];
			pt1 = zh16jg(cp);
			pt1 = N_addRoundKey(pt1,round);
			
			for(int i = 0 ; i < 9 ; i++)
			{
				round ++;
				
				pt1 = N_SBoxReplace(pt1);
				pt1 = N_ShiftRows(pt1);
				pt1 = N_MixColumns(pt1);
				pt1 = N_addRoundKey(pt1,round);			
			}
			round ++;
			pt1 = N_SBoxReplace(pt1);
			pt1 = N_ShiftRows(pt1);
			pt1 = N_addRoundKey(pt1,round);
			String re = new String();
			for(int i = 0 ; i < 4 ; i++)
			{
				for(int j = 0 ; j < 4 ; j++)
				{
					re = re.concat(pt1[i][j]);
				}
			}
			return re;
		}
	}
	public static void  bulidN_SBox()   //逆S盒构建
	{
		N_SBox = new int[16][16];
		for(int i = 0 ; i < 16 ; i++)
		{
			for(int j = 0 ; j < 16 ; j++)
			{
				
				String ad = new String();
				ad = Integer.toHexString(SBox[i][j]);
				if(ad.length() == 1)
				{
					ad = "0".concat(ad);
				}
				N_SBox[Integer.valueOf(ad.charAt(0) + "",16)][Integer.valueOf(ad.charAt(1) + "",16)] = i * 16 + j;
				
			}
		}
		
	}
	public static void getN_allKey()
	{
		N_allKey = new int[4][44];
		for(int i = 0 ; i < 4 ; i++)
		{
			for(int j = 0 ; j < 4 ; j++)
			{
				N_allKey[i][j] = allKey[i][40 + j];  //
			}
		}
		int count = 36;
		while(count >=4)
		{
			for(int i = 0 ; i < 4 ; i++)
			{
				N_allKey[0][40 - count + i] = gfMul2(allKey[0][count + i],0x0e) ^ gfMul2(allKey[1][count + i],0x0b)
						^ gfMul2(allKey[2][count + i],0x0d) ^ gfMul2(allKey[3][count + i],0x09);
				N_allKey[1][40 - count + i] = gfMul2(allKey[0][count + i],0x09) ^ gfMul2(allKey[1][count + i],0x0e)
						^ gfMul2(allKey[2][count + i],0x0b) ^ gfMul2(allKey[3][count + i],0x0d);
				N_allKey[2][40 - count + i] = gfMul2(allKey[0][count + i],0x0d) ^ gfMul2(allKey[1][count + i],0x09)
						^ gfMul2(allKey[2][count + i],0x0e) ^ gfMul2(allKey[3][count + i],0x0b);
				N_allKey[3][40 - count + i] = gfMul2(allKey[0][count + i],0x0b) ^ gfMul2(allKey[1][count + i],0x0d)
						^ gfMul2(allKey[2][count + i],0x09) ^ gfMul2(allKey[3][count + i],0x0e);
			}
			count -=4;
		}
		for(int i = 0 ; i < 4 ; i++)
		{
			for(int j = 0 ; j < 4 ; j++)
			{
				N_allKey[i][j+40] = allKey[i][j];
			}
		}
			
	
		
		
	}
	
	
	
}
