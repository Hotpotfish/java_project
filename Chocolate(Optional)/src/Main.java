import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		int AliceTime = 0 , BobTime = 0 , Alice = 0 , Bob = 0 , Alicem = 0 , Bobm = 0;
		int nu = 0;
		Scanner s = new Scanner(System.in);
		nu = s.nextInt();
		int ch[] = new int[nu];
		if(nu == 1)
		{
			ch[0] = s.nextInt();
			Alice = 1;
			System.out.println(Alice +" " + Bob);
			return;
		}
		for(int i = 0 ; i < nu ; i++)
		{
			ch[i] = s.nextInt();
		}
		for(int i = 0 ; i < nu ; i++)
		{
			if(Alicem == nu -Bobm - 1 && BobTime == AliceTime)
			{
				Alice += 1;
				AliceTime += ch[i];
				Alicem += 1;
				break;
			}
			if(AliceTime > BobTime)
			{
				Bob += 1;
				BobTime += ch[nu - Bobm - 1];
				Bobm += 1;
			}
			else if(AliceTime < BobTime)
			{
				Alice += 1;
				AliceTime += ch[Alicem];
				Alicem += 1;
			}
			else if(AliceTime == BobTime)
			{
				Bob += 1;
				BobTime += ch[nu - Bobm - 1];
				Bobm += 1;
				Alice += 1;
				AliceTime += ch[Alicem];
				Alicem += 1;
			}
			if(Alicem > nu - Bobm - 1)
			{
				break;
			}
			
		}
		System.out.println(Alice + " " + Bob);
	}

}
