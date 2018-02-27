class Replace{
 static String replace(String str,String str1,String str2){
  int a = str.indexOf(str1);
  int b = str1.length();
  StringBuffer buf = new StringBuffer(str);
  buf.replace(a,a+b,str2);
  return buf.toString();
 }
}
public class timuyi {
	public static void main(String []args)
	{
		  System.out.println(Replace.replace("abcdefg","cde","def"));
	}
	
}


