package lab6_7;
import java.util.Scanner;  

public class Main {  
    public static void main(String[] args)  
    {  
        int i ,j;  
        int n;  
        int length;  
        char c;  
        StringBuffer str1;  
        String str2;  
        Scanner s = new Scanner(System.in);  
        n = s.nextInt();  
        s.nextLine();  
        for(i = 0 ; i < n ; i++)  
        {  
            length = 0;  
            str2 = "";  
            c = ' ';  
            str2 = s.nextLine();  
            length = str2.length();  
            str1 = new StringBuffer(str2);  
            for(j = 0 ; j < length ; j++)  
            {  
                if(length == 0)
                {
                	break;
                }
                c = str1.charAt(j);  
                if(c == '.' || c == ',' || c == '?' ||  c== '!')  
                {  
                    str1.deleteCharAt(j); 
                    length = str1.length(); 
                    j = j - 1;
                    continue;  
                }  
                if(c >= 'A' && c <= 'Z')  
                {  
                    c =  Character.toLowerCase(c);  
                    str1.setCharAt(j , c);  
                }  
                if(c == 'a' || c == 'A')  
                {  
                    if(str1.charAt(j + 1) == 't' || str1.charAt(j + 1) == 'T')  
                    {  
                        if(str1.charAt(j + 2) != 'e' && str1.charAt(j + 2) != 'E')  
                        {  
                            str1.setCharAt(j , '@');  
                            str1.delete(j + 1 , j + 2);
                            length = str1.length(); 
                            continue ;  
                        }  
                        if(str1.charAt(j + 2) == 'e' ||  str1.charAt(j + 2) == 'E')  
                        {  
                            str1.setCharAt(j , '8');  
                            str1.delete(j + 1 , j + 3); 
                            length = str1.length();
                            continue;  
                        }  
                          
                    }  
                    if(str1.charAt(j + 1) == 'n' ||  str1.charAt(j + 1) == 'N')  
                    {  
                        if(str1.charAt(j + 2) == 'd' || str1.charAt(j + 1) == 'D')  
                        {  
                            str1.setCharAt(j , '&');  
                            str1.delete(j + 1 , j + 3); 
                            length = str1.length();
                            continue;  
                        }  
                    }  
                }  
                if(c == 'y')  
                {  
                    if(str1.charAt(j + 1) == 'o' ||  str1.charAt(j + 1) == 'O')  
                    {  
                        if(str1.charAt(j + 2) == 'u' ||  str1.charAt(j + 2) == 'U')  
                        {  
                            str1.setCharAt(j , 'U');  
                            str1.delete(j + 1 , j + 3);  
                            length = str1.length(); 
                            continue;  
                        }  
                    }  
                }  
            }  
            System.out.println(str1);  
              
              
        }  
          
    }  
  
}  