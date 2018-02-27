import java.util.Scanner;
class Main {  
    public static void main(String[] args) {
    	int i , j  , k , n  ;
    	Scanner s = new Scanner( System.in ) ;
    	while( s.hasNextInt())
    	{
    		
    		n  = s.nextInt() ;
    		for( i = 1 ; i <= 1 + 2 * n ; i ++)
    		{
    			if( i == n + 1 )
    			{
    				for( j = 1 ; j <= 3 + (i - 2) * 2 ; j++ )
    				{
    					System.out.print("*");
    				}
    				System.out.println();
    			}
    			else
    			{
    				for( k = 0 ; k < n ; k ++ )
    				{
    					System.out.printf(" ");
    				}
    				System.out.println("*") ;
    			}
    		}
    	}
    }
}  