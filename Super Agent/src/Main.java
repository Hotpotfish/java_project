import java.util.Scanner;  
public class Main {  
    public static void main(String[] args)  
    {  
        Scanner s = new Scanner(System.in);  
        String str[] = new String[3];  
        boolean isSymmetry = true;  
        for(int i = 0 ; i < 3 ; i++)  
        {  
            str[i] = new String();  
            str[i] = s.next();  
        }  
        for(int i = 0 ; i <= 2 ; i++)  
        {  
            for(int j = 0 ; j <= 2 ; j++)  
            {  
                if(str[i].charAt(j) != str[2 - i].charAt(2 - j))  
                {  
                    isSymmetry = false;
                }  
                  
            }  
        }  
        if(isSymmetry == true)  
        {  
            System.out.println("YES");  
        }  
        else 
        {  
            System.out.println("NO");  
        }  
          
    }  
  
}  
