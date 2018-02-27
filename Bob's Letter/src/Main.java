import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		int m_x,m_y,a,b;
		boolean tip;
		Scanner in = new Scanner(System.in);
		
		m_x = in.nextInt();
		m_y = in.nextInt();
		String[] letter = new String[m_x];
		boolean[][] bletter = new boolean[m_x][m_y];
		in.nextLine();
		for(a = 0 ; a < m_x ; a++)
			letter[a] = in.nextLine();
		for(a = 0 ; a < m_x ; a++){
			for(b = 0 ; b < m_y ; b++)
				if(letter[a].charAt(b) != '.')
					break;
			if(b != m_y)
				for(int c = 0 ; c < m_y ; c++)
					bletter[a][c] = true;
		}
		for(a = 0 ; a < m_y ; a++){
			for(b = 0 ; b < m_x ; b++)
				if(letter[b].charAt(a) != '.')
					break;
			if(b == m_x)
				for(int c = 0 ; c < m_x ; c++)
					bletter[c][a] = false;
		}
		for(a = 0 ; a < m_x ; a++){
			tip = false;
			for(b = 0 ; b < m_y ; b++)
				if( bletter[a][b] ){
					System.out.print(letter[a].charAt(b));
					tip = true;
				}
			if( tip )
				System.out.println("");
		}
		in.close();
	}
}
/*public class Main {
	public static void main(String[] args)
	{
		int n , m;
		int Arr[][] = new int[2][2];
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		String str[] = new String[n];
		for(int i = 0 ; i < n ; i++)
		{
			str[i] = new String();
			str[i] = s.next();
		}
		int count = 0;
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < m ; j++)
			{
				if(str[i].charAt(j) == '*'  && count == 0)
				{
					Arr[0][0] = j;
					Arr[0][1] = i;
					count ++;
				}
				else if(str[i].charAt(j) == '*' && count != 0)
				{
					Arr[1][0] = j;
					Arr[1][1] = i;
					count ++;
				}
			}
		}
		if(count == 1)
		{
			System.out.println("*");
			return;
		}
		for(int i = Arr[0][1] ; i <= Arr[1][1] ; i++)
		{
			for(int j  = Arr[0][0] ; j <= Arr[1][0] ; j++)
			{
				System.out.print(str[i].charAt(j));
			}
			System.out.println();	
		}
	}

}*/
