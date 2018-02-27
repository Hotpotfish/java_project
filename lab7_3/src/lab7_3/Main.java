package lab7_3;

import java.util.Scanner;  
public class Main {    
    public static void main(String[] args)    
    {    
        int max4 , max7 , c4 , c7;    
        int i , j , k ,l;    
        int n , nu , sum;    
        boolean b;    
        Scanner s = new Scanner(System.in);    
        n = s.nextInt();    
        for(i = 0 ; i < n ; i++)    
        {  
            k =0 ;  
            b = false;    
            nu = 0;    
            sum = 0;    
            nu = s.nextInt();    
            max4 = nu / 4;    
            max7 = nu / 7;    
            for(j = 0 ; j <= max4 ; j++)    
            {    
                for(k = 0 ; k <= max7 ; k++)    
                {      
                    if( j * 4 + k * 7 == nu)    
                    {     
                        b = true;  
                        break;  
                    }  
                }  
                if(b == true) break;  
            }    
            if(b == true)    
            {
            	StringBuffer sb = new StringBuffer();
                for(l = 1 ; l <= j ; l++)    
                {
                	sb.append(4);
                      
                }    
                for(l = 1 ; l <= k ; l++)    
                {    
                    sb.append(7);
                }    
                System.out.println(sb);    
            }    
            if(b == false)    
            {    
                System.out.println("-1");    
            }    
        }    
            
    }    
    
}  