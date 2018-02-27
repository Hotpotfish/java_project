package cryptology;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class coin extends JFrame {
	int pa,pb,qa,qb,na,nb,phia,phib,ea,eb,da,db,ma[];
	double ma1[];
	String mesend,bsel,bselAf,are,re;
	double bmas[];
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;

	/**
	 * Launch the application.
	 */
	 /**
		 * 随机指定范围内N个不重复的数
		 * 最简单最基本的方法
		 * @param min 指定范围最小值
		 * @param max 指定范围最大值
		 * @param n 随机数个数
		 */
		public static int[] randomCommon(int min, int max, int n){
			if (n > (max - min + 1) || max < min) {
	            return null;
	        }
			int[] result = new int[n];
			int count = 0;
			while(count < n) {
				int num = (int) (Math.random() * (max - min)) + min;
				boolean flag = true;
				for (int j = 0; j < n; j++) {
					if(num == result[j]){
						flag = false;
						break;
					}
				}
				if(flag){
					result[count] = num;
					count++;
				}
			}
			return result;
		}
	public static boolean check(int m,int n){
	    int k=0;	
	    for(k = m;0 != k%n;k+=m);   
	    if(k==m*n){
	      return true;
	    }else{
	      return false;
	    }
	  }
	public static long createRadomPrimeNunber(int n){
        long recLong = 0;
        List list = listAllPrimeNumber(n);
        Random rd = new Random();
        int randomIndex = Math.abs( rd.nextInt()%list.size());
        recLong = ((Long)list.get(randomIndex)).longValue();
        return recLong;
       
    }
	public static List listAllPrimeNumber(int n){
        List list = new ArrayList();
        long low = (long)Math.pow(10,n-1);
        long high = (long)Math.pow(10,n) - 1;
        for(long i= low;i < high;i++){
            if( isSushu(i)) {
                list.add(new Long(i));
            }
        }
        return list;
    }
	public static boolean isSushu(long x){//定义一个判断一个数是否是素数的函数
        if(x<2) return false;
        if( x==2)return true;
        for(long i=2;i<= (long)Math.sqrt(x);i++)
            if(x%i==0) return false;
        return true;
    }
	public static int []ext_euclid(int a, int b)
	{
		int big,small;
		big = a;
		small = b;
		int x1,x2,x3,y1,y2,y3,t1,t2,t3,q;
		x1 = 1;
		x2 = 0;
		x3 = big;
		y1 = 0;
		y2 = 1;
		y3 = small;
		int re[] = new int[2];
		while(true)
		{
			if(y3 == 0)
			{
				re[0] = x3;
				re[1] = -999999;
				return re;
			}
			if(y3 == 1)
			{
				re[0] = y3 ;
				re[1] = y2 ;
				return re;
			}
			q = x3 / y3;
			t1 = x1 - q*y1;
			t2 = x2 - q*y2;
			t3 = x3 - q*y3;
			x1 = y1;			
			x2 = y2;
			x3 = y3;
			y1 = t1;
			y2 = t2;
			y3 = t3;		
		}	
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coin frame = new coin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public coin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 903);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alice:");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 173, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("选取两个素数");
		lblNewLabel_1.setBounds(10, 79, 102, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("p:");
		lblNewLabel_2.setBounds(10, 120, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(42, 117, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQ = new JLabel("q:");
		lblQ.setBounds(10, 145, 54, 15);
		contentPane.add(lblQ);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(42, 145, 66, 21);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("生成p");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				long p = createRadomPrimeNunber(1);
				pa = (int) p;
				textField.setText(""+p);
				
				
			}
		});
		btnNewButton.setBounds(115, 116, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnq = new JButton("生成q");
		btnq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				long q;
				while(true)
				{
					q = createRadomPrimeNunber(1);
					if(q != pa)
					{
						
						 break;
						 
					}
				}
				qa =(int) q;
				textField_1.setText(""+q);
			}
		});
		btnq.setBounds(115, 141, 93, 23);
		contentPane.add(btnq);
		
		JLabel lbln = new JLabel("φ(n)");
		lbln.setBounds(0, 246, 54, 15);
		contentPane.add(lbln);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(42, 243, 66, 21);
		contentPane.add(textField_2);
		
		JLabel lblN = new JLabel("n:");
		lblN.setBounds(10, 221, 54, 15);
		contentPane.add(lblN);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(42, 215, 66, 21);
		contentPane.add(textField_3);
		
		JButton btnNewButton_1 = new JButton("计算n");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long n,p,q;
				p = Long.parseLong(textField.getText());
				q = Long.parseLong(textField_1.getText());
				n = p * q;
				na = (int) n;
				textField_3.setText(""+n);
			}
		});
		btnNewButton_1.setBounds(115, 217, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("计算φ(n)");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long fhi,p,q;
				p = Long.parseLong(textField.getText());
				q = Long.parseLong(textField_1.getText());
				fhi = (p-1) * (q-1);
				textField_2.setText(""+fhi);//fhi
			}
		});
		btnNewButton_2.setBounds(115, 242, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lble = new JLabel("选取e");
		lble.setBounds(10, 367, 54, 15);
		contentPane.add(lble);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(42, 364, 66, 21);
		contentPane.add(textField_4);
		
		JButton btnNewButton_3 = new JButton("选取e");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long ex = -1;//e
				Random rand = new Random();
				while(ex != 0)
				{
					int t = rand.nextInt((int)Long.parseLong(textField_2.getText()));
					if(check(t,(int)Long.parseLong(textField_2.getText())) && t!= 0)  //互素
					{
						ex = t;
						break;
					}
					
				}
				ea = (int) ex;
				
				
				textField_4.setText(""+ex); //e
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.setBounds(125, 363, 93, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("其中n = p*q φ(n)=(p-1)*(q-1)");
		lblNewLabel_3.setBounds(10, 196, 210, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("公钥:1<e<φ(n)，且gcd(φ(n),e)=1");
		lblNewLabel_4.setBounds(10, 337, 198, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lbld = new JLabel("计算d");
		lbld.setBounds(10, 433, 54, 15);
		contentPane.add(lbld);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(42, 430, 66, 21);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_5 = new JLabel("私钥:d•e≡1 mod φ(n)");
		lblNewLabel_5.setBounds(10, 408, 198, 15);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("计算d");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long d;
				d = ext_euclid((int)Long.parseLong(textField_2.getText()),(int)Long.parseLong(textField_4.getText()))[1];
				if(d < 0)
				{
					d += (int)Long.parseLong(textField_2.getText()); 
				}
				da = (int) d;
				textField_5.setText(""+d);   //d
				
				
			}
		});
		btnNewButton_4.setBounds(125, 429, 93, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblBob = new JLabel("Bob:");
		lblBob.setHorizontalAlignment(SwingConstants.CENTER);
		lblBob.setFont(new Font("黑体", Font.BOLD, 50));
		lblBob.setBounds(305, 10, 173, 58);
		contentPane.add(lblBob);
		
		JLabel label_1 = new JLabel("选取两个素数");
		label_1.setBounds(305, 79, 102, 36);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("p:");
		label_2.setBounds(305, 120, 54, 15);
		contentPane.add(label_2);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(337, 117, 66, 21);
		contentPane.add(textField_6);
		
		JLabel label_3 = new JLabel("q:");
		label_3.setBounds(305, 145, 54, 15);
		contentPane.add(label_3);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(337, 145, 66, 21);
		contentPane.add(textField_7);
		
		JButton button = new JButton("生成p");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long p = createRadomPrimeNunber(1);
				pb = (int) p;
				textField_6.setText(""+p);
				
				
			}
		});
		button.setBounds(410, 116, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("生成q");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long q;
				while(true)
				{
					q = createRadomPrimeNunber(1);
					if(q != pb)
					{
						
						 break;
						 
					}
				}
				qb =(int) q;
				textField_7.setText(""+q);
			
				
			}
		});
		button_1.setBounds(410, 141, 93, 23);
		contentPane.add(button_1);
		
		JLabel label_4 = new JLabel("φ(n)");
		label_4.setBounds(295, 246, 54, 15);
		contentPane.add(label_4);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(337, 243, 66, 21);
		contentPane.add(textField_8);
		
		JLabel label_5 = new JLabel("n:");
		label_5.setBounds(305, 221, 54, 15);
		contentPane.add(label_5);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(337, 215, 66, 21);
		contentPane.add(textField_9);
		
		JButton button_2 = new JButton("计算n");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long n,p,q;
				p = pb;
				q = qb;
				n = p * q;
				nb = (int) n;
				textField_9.setText(""+n);
			}
		});
		button_2.setBounds(410, 217, 93, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("计算φ(n)");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long fhi,p,q;
				p = pb;
				q = qb;
				fhi = (p-1) * (q-1);
				textField_8.setText(""+fhi);//fhi
			}
		});
		button_3.setBounds(410, 242, 93, 23);
		contentPane.add(button_3);
		
		JLabel label_6 = new JLabel("选取e");
		label_6.setBounds(305, 367, 54, 15);
		contentPane.add(label_6);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(337, 364, 66, 21);
		contentPane.add(textField_10);
		
		JButton button_4 = new JButton("选取e");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long ex = -1;//e
				Random rand = new Random();
				while(ex != 0)
				{
					int t = rand.nextInt((int)Long.parseLong(textField_8.getText()));
					if(check(t,(int)Long.parseLong(textField_8.getText())))  //互素
					{
						ex = t;
						break;
					}
					
				}
				eb = (int) ex;
				
				
				textField_10.setText(""+ex); //e
			}
		});
		button_4.setBounds(420, 363, 93, 23);
		contentPane.add(button_4);
		
		JLabel label_7 = new JLabel("其中n = p*q φ(n)=(p-1)*(q-1)");
		label_7.setBounds(305, 196, 210, 15);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("公钥:1<e<φ(n)，且gcd(φ(n),e)=1");
		label_8.setBounds(305, 337, 198, 15);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("计算d");
		label_9.setBounds(305, 433, 54, 15);
		contentPane.add(label_9);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(337, 430, 66, 21);
		contentPane.add(textField_11);
		
		JLabel lbldeModn = new JLabel("私钥:d•e≡1 mod φ(n)");
		lbldeModn.setBounds(305, 408, 198, 15);
		contentPane.add(lbldeModn);
		
		JButton button_5 = new JButton("计算d");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long d;
				d = ext_euclid((int)Long.parseLong(textField_8.getText()),(int)Long.parseLong(textField_10.getText()))[1];
				if(d < 0)
				{
					d += (int)Long.parseLong(textField_8.getText()); 
				}
				db = (int) d;
				textField_11.setText(""+d);   //d
			}
		});
		button_5.setBounds(420, 429, 93, 23);
		contentPane.add(button_5);
		
		JLabel lblNewLabel_6 = new JLabel("Alice产生的消息串0:");
		lblNewLabel_6.setBounds(10, 464, 129, 36);
		contentPane.add(lblNewLabel_6);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setBounds(10, 499, 129, 21);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblAlice = new JLabel("Alice产生的消息串1:");
		lblAlice.setBounds(149, 464, 129, 36);
		contentPane.add(lblAlice);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(149, 499, 129, 21);
		contentPane.add(textField_13);
		
		JLabel lblAlice_1 = new JLabel("Alice产生的随机串:");
		lblAlice_1.setBounds(288, 464, 129, 36);
		contentPane.add(lblAlice_1);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(288, 499, 139, 21);
		contentPane.add(textField_14);
		
		JButton btnNewButton_5 = new JButton("生成上述三个消息");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int m[];
				ma = new int[3];
				//java.util.Random random=new java.util.Random();
				m = new int[3];
				m = randomCommon(2,22,3);
				ma[0] = m[0];
				ma[1] = m[1];
				ma[2] = m[2];
				textField_12.setText(""+m[0]);
				textField_13.setText(""+m[1]);
				textField_14.setText(""+m[2]);
				
				
				
				
			}
		});
		btnNewButton_5.setBounds(10, 530, 417, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblAlice_2 = new JLabel("Alice发送下述消息串给Bob");
		lblAlice_2.setBounds(10, 662, 417, 36);
		contentPane.add(lblAlice_2);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		textField_15.setColumns(10);
		textField_15.setBounds(10, 708, 417, 21);
		contentPane.add(textField_15);
		
		JLabel lblNewLabel_7 = new JLabel("Bob选择其中一个消息串，以及后面的随机串用自己公钥加密");
		lblNewLabel_7.setBounds(10, 739, 326, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblAlice_3 = new JLabel("Alice公钥加密消息串0:");
		lblAlice_3.setBounds(10, 563, 129, 36);
		contentPane.add(lblAlice_3);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(10, 598, 129, 21);
		contentPane.add(textField_16);
		
		JLabel lblAlice_4 = new JLabel("Alice公钥加密消息串1:");
		lblAlice_4.setBounds(149, 563, 129, 36);
		contentPane.add(lblAlice_4);
		
		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setBounds(149, 598, 129, 21);
		contentPane.add(textField_17);
		
		JLabel lblAlice_5 = new JLabel("Alice公钥加密随机串:");
		lblAlice_5.setBounds(288, 563, 129, 36);
		contentPane.add(lblAlice_5);
		
		textField_18 = new JTextField();
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBounds(288, 598, 139, 21);
		contentPane.add(textField_18);
		
		JButton button_6 = new JButton("加密");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ma1 = new double[3];
				ma1[0] = Math.pow(ma[0], ea)%na;
				ma1[1] = Math.pow(ma[1], ea)%na;
				ma1[2] = Math.pow(ma[2], ea)%na;
				textField_16.setText(""+ma1[0]);
				textField_17.setText(""+ma1[1]);
				textField_18.setText(""+ma1[2]);
			}
		});
		button_6.setBounds(10, 629, 417, 23);
		contentPane.add(button_6);
		
		JLabel lblNewLabel_8 = new JLabel("Bob选择为:");
		lblNewLabel_8.setBounds(10, 764, 98, 15);
		contentPane.add(lblNewLabel_8);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(10, 794, 417, 21);
		contentPane.add(textField_19);
		
		JLabel lblNewLabel_9 = new JLabel("Bob加密后的串为");
		lblNewLabel_9.setBounds(539, 22, 119, 15);
		contentPane.add(lblNewLabel_9);
		
		textField_20 = new JTextField();
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBounds(539, 47, 210, 21);
		contentPane.add(textField_20);
		
		JLabel lblNewLabel_10 = new JLabel("转发上述串给Alice");
		lblNewLabel_10.setBounds(543, 79, 115, 15);
		contentPane.add(lblNewLabel_10);
		
		JButton btnNewButton_6 = new JButton("执行");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String s = new String();
				s = "" + ma1[0]+"@"+ma1[1]+"@"+ma1[2];
				mesend = s;
				textField_15.setText(s);
				
			}
		});
		btnNewButton_6.setBounds(337, 739, 93, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("加密");
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String st[] = new String[2];
				st = bsel.split("@");
				double d1 = Double.parseDouble(st[0]);
				double d2 = Double.parseDouble(st[1]);
				double r[] = new double[2];
				r[0] = Math.pow(d1, eb)%nb;
				r[1] = Math.pow(d2, eb)%nb;
				bselAf = ""+r[0]+"@"+r[1];
				textField_20.setText(bselAf);
				
				
			}
		});
		btnNewButton_7.setBounds(643, 18, 93, 23);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel_11 = new JLabel("Alice用自己私钥解密上述串结果为:");
		lblNewLabel_11.setBounds(543, 104, 206, 15);
		contentPane.add(lblNewLabel_11);
		
		textField_21 = new JTextField();
		textField_21.setEditable(false);
		textField_21.setColumns(10);
		textField_21.setBounds(543, 128, 210, 21);
		contentPane.add(textField_21);
		
		JLabel lblNewLabel_12 = new JLabel("将上述串转回Bob");
		lblNewLabel_12.setBounds(543, 159, 153, 15);
		contentPane.add(lblNewLabel_12);
		
		JButton button_8 = new JButton("转发");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String st[] = new String[2];
				st = are.split("@");
				double d1 = Double.parseDouble(st[0]);
				double d2 = Double.parseDouble(st[1]);
				double r[] = new double[2];
				r[0] = Math.pow(d1, db) % nb;
				r[1] = Math.pow(d2, db) % nb;
				re = ""+r[0]+"@"+r[1];
				textField_22.setText(re);				
			}
		});
		button_8.setBounds(656, 155, 93, 23);
		contentPane.add(button_8);
		
		JLabel lblNewLabel_13 = new JLabel("Bob通过自己私钥解密，返回给Alice");
		lblNewLabel_13.setBounds(543, 196, 206, 15);
		contentPane.add(lblNewLabel_13);
		
		textField_22 = new JTextField();
		textField_22.setEditable(false);
		textField_22.setColumns(10);
		textField_22.setBounds(539, 218, 210, 21);
		contentPane.add(textField_22);
		
		JLabel lblNewLabel_14 = new JLabel("Alice验证随机串，并得知结果");
		lblNewLabel_14.setBounds(543, 249, 206, 15);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Alice和Bob公开秘钥");
		lblNewLabel_15.setBounds(543, 274, 206, 15);
		contentPane.add(lblNewLabel_15);
		
		JButton btnNewButton_8 = new JButton("生成选择");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = (Math.random()>0.5?1:0) ;
				String st[] = new String[3];
				st = mesend.split("@");
				bsel = ""+st[select]+"@"+st[2];
				textField_19.setText(bsel);
				
				
			}
		});
		btnNewButton_8.setBounds(74, 760, 93, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("转发并解密");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String st[] = new String[2];
				st = bselAf.split("@");
				double d1 = Double.parseDouble(st[0]);
				double d2 = Double.parseDouble(st[1]);
				double r[] = new double[2];
				r[0] = Math.pow(d1, da) % na;
				r[1] = Math.pow(d2, da) % na;
				are = ""+ r[0] +"@"+r[1];
				textField_21.setText(are);
			}
		});
		btnNewButton_9.setBounds(656, 75, 93, 23);
		contentPane.add(btnNewButton_9);
	}
}
