package lab7_8;

import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int count = 0;
		int length = 0;
		String str[] = new String[1000];
		Scanner s = new Scanner(System.in);
		boolean left = true;
		while(s.hasNextLine())
		{
			str[count] = new String();
			str[count] = s.nextLine();
			count ++;
		}
		length = str[0].length();
		for(int i = 0 ; i < count ; i++)
		{
			if(str[i].length() > length)
			{
				length = str[i].length();
			}
		}
		length += 2;
		StringBuffer sb = new StringBuffer();
		StringBuffer sb1[] = new StringBuffer[1000];
		StringBuffer sb2[] = new StringBuffer[1000];
		for(int j = 0 ; j < length ; j++)
		{
			sb.append("*");
		}
		for(int k = 0 ; k < count  ; k++)
		{
			int ep = length - 2 - str[k].length();
			sb1[k] = new StringBuffer();
			sb2[k] = new StringBuffer();
			if(ep % 2 == 0)
			{
				for(int l = 0 ; l < ep / 2 ; l++)
				{
					sb1[k].append(" ");
					sb2[k].append(" ");
				}
			}
			else if(ep % 2 == 1 && left == false )
			{
				for(int l = 0 ; l < (ep + 1) / 2 ; l++)
				{
					sb1[k].append(" ");
				}
				for(int l = 0 ; l < (ep - 1) / 2 ; l++)
				{
					sb2[k].append(" ");
				}
				left = true;
			}
			else if(ep % 2 == 1 && left == true )
			{
				for(int l = 0 ; l < (ep - 1) / 2 ; l++)
				{
					sb1[k].append(" ");
				}
				for(int l = 0 ; l < (ep + 1) / 2 ; l++)
				{
					sb2[k].append(" ");
				}
				left = false;
			}
		}
		System.out.println(sb);
		for(int l = 0 ; l < count ; l++)
		{
			System.out.println("*" + sb1[l] + str[l] + sb2[l] + "*");
		}
		System.out.println(sb);
		
	}

}
