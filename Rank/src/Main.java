import java.io.*;
import java.text.SimpleDateFormat; 
import java.util.*;

class Question
{
	SimpleDateFormat bartDateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
	int ID = 0;
	boolean AC = false;
	int Submit = 0;
	int difference = 0;
	Date e = new Date() ;
	void setID(int ID)
	{
		this.ID = ID;
	}
	void Sub(boolean ac , Date e)
	{
		AC = ac;
		if(AC == false)
		{
			this.e.setMinutes(e.getMinutes() + 20);
			Submit++;
			
		}
		else
		{
			this.e = e;
		}
	}
	long retTime()
	{
		return e.getTime();
	}
	
/*	long retDifferce()
	{
		if(AC == false)
		{
			return 0;
		}
		else if( AC == true && Submit == 1)
		{
			 long l=e[0].getTime()-s.getTime();	
			 long day=l/(24*60*60*1000);
			 long hour=(l/(60*60*1000)-day*24);
			 long min=((l/(60*1000))-day*24*60-hour*60);
			 return (min);
		}
		else
		{
			 long l=e[0].getTime()-s.getTime();	
			 long day=l/(24*60*60*1000);
			 long hour=(l/(60*60*1000)-day*24);
			 long min=((l/(60*1000))-day*24*60-hour*60);
			 difference = (Submit - 1) * 20;
			return(difference + min); 
		}
		
	}
	*/	
}

class Player
{
	
	int ID = 0;
	String name = "";
	Question q[] = new Question[10000];
}



public class Main {
	public static void main(String args[])
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		Date d1;
		Date d2;
		String str1[];
		Player p[] = new Player[10000];
		Map<String , Integer> map = new HashMap<String , Integer>();
		try
		{
			FileReader fr = new FileReader("text.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = new String();
			str = br.readLine();
			str1 = str.split(" ");
			String temp = "";
			temp = str1[0] + " " + str1[1];
			d1 = sdf.parse(temp);
			temp = str1[2] + " " + str1[3];
			d2 = sdf.parse(temp);
			str = br.readLine();
			str1 = str.split(" ");
			Question q[] = new Question[100000];
			for(int i = 0 ; i < str1.length ; i++)
			{
				q[i] = new Question();
				q[i].ID = Integer.parseInt(str1[i]);
				
			}
			int number = 0;
			while((str = br.readLine()) != null)
			{
				str1 = str.split(" ");
				
				if(map.get(p[number].) != 1)
				{
					p[number] = new Player();
					map.put(p[number], 1);
				}
			}
			br.close();
			
		}
		
		catch(Exception e)
		{
			
		}
		
	}
	

}
