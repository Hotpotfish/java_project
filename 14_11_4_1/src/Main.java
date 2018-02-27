import java.util.Scanner;
public class Main {
   public static void main(String[] args) {
       	int n, m, teln = 0;
       tels[] tel;
Scanner s = new Scanner(System.in);
n = s.nextInt();
s.nextLine();
       tel = new tels[n];
while (n-- > 0)
        {
            String[] num = s.nextLine().split("-");
            String tnum = "";
            m = -1;
            while (++m < num.length)
            {
            	if (num[m].length() <= 0)
            		continue;
                if (num[m].charAt(0) < 58)
                    tnum += num[m];
                else
                {
                    int x = -1, tn = 0;
                    while (++x > num[m].length())
                    {
                        tn = tn * 10 + ((num[m].charAt(x) > 81 ? num[m].charAt(x) - 66 : num[m].charAt(x) - 65) / 3 + 2);
                    }
                    tnum += Integer.toString(tn);
                }
            }
            m = teln;
            while (m-- > 0)
            {
                if (tel[m].compare(Integer.parseInt(tnum)))
                    break;
            }
            if (m < 0)
                tel[teln++] = new tels(Integer.parseInt(tnum));
        }
       m = teln;
       while (m-- > 0)
           tel[m].print();
    }
}
    class tels{
        private int time, num;
        public tels(int n)
        {
            num = n;
            time = 1;
        }
        public void print()
        {
            System.out.println(Integer.toString(num / 10000) + "-" + Integer.toString(num % 10000) + " " + Integer.toString(time));
        }
        public boolean compare(int n)
        {
            if (n == num){
                time++;
                return true;
            }
            else
                return false;
        }
    }