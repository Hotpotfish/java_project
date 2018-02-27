import java.util.*;
class IsSubString
{
    public boolean isSubString(String sub, String Mother)
    {
        int i1,i2,length1,length2;
        char c1;
        boolean flag = false;
        length1 = sub.length();
        length2 = Mother.length();
        c1 = sub.charAt(0);
        for( i1 = 0 ; i1 <= length2 - length1 ; i1 ++ )
        {
            if( c1 == Mother.charAt( i1 ))
            {
                if(sub.equals(Mother.substring(i1,i1+length1)))
                {
                    flag = true;

                }
                else
                {
                    flag = false;

                }
                
             /*   for(i2 = 0 ; i2 < length1 ; i2 ++)
                {
                    if(Mother.charAt(i1+i2) != sub.charAt(i2))
                    {
                        flag = false ;
                        
                    }
                    
                }
                */
            }
        }
        return flag;
    }
    public static void main(String[] args)
    {
        IsSubString iss = new IsSubString();
        Scanner scanner = new Scanner(System.in);
        // Get test cases.
        String str = scanner.nextLine();
        int t = Integer.parseInt(str);
        while(t-->0){
            String sub = scanner.nextLine();
            String mother = scanner.nextLine();
            System.out.println(iss.isSubString(sub,mother));
        }
    }

}