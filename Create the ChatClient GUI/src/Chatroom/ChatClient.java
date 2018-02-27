package Chatroom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ChatClient {
	public void launchFrame()
	{
		final JFrame frame = new JFrame("chat room"); //��������
		int windowWidth = 800;
		int windowHeight = 600;
		frame.setBounds(50,100,windowWidth,windowHeight);   //������Ļ�Ŀ�խ  �� 50 100 ��ʾ ������Ļ�����أ�����͵�����Ϊ׼��
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //���������X�������ã������ǳ��׵Ĺرգ�
		frame.setVisible(true); //�Ƿ���Ա����С
		JSplitPane splitPane = new JSplitPane(); //�ָ����
		splitPane.setOneTouchExpandable(false); // �м�ָ���û��С�������������۵��ָ����
		splitPane.setPreferredSize(new Dimension(800,600));
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT); //��ֱ���
		splitPane.setDividerSize(4); //�ָ��ߵĴ�С	
		splitPane.setDividerLocation(550); //��ʼʱ�ָ��ߵ�λ��
		frame.getContentPane().add(splitPane,BorderLayout.CENTER); //��ӷָ���嵽����
		frame.pack();
		final JSplitPane splitPane1 = new JSplitPane(); //�½�һ����ְ�����ŵ��������ϲ�
		splitPane1.setOneTouchExpandable(false); // �м�ָ���û��С�������������۵��ָ����
		splitPane1.setPreferredSize(new Dimension(800,550));
		splitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT); //�ϲ�����ְ�ˮƽ���
		splitPane1.setDividerSize(4); //�ָ��ߵĴ�С	
		splitPane1.setDividerLocation(650); //��ʼʱ�ָ��ߵ�λ��
		splitPane.setTopComponent(splitPane1);//������ķָ���ٷֳɺ��ŵ�����
		frame.pack();
		JTextArea textArea = new JTextArea(); //�½�JTextArea���ϲ�
		textArea.setColumns(50); // �����п�Ϊ50	
		textArea.setRows(10);    //�����и�Ϊ10
		JScrollPane p  =  new JScrollPane(textArea); //ΪJTextArea ��ӹ�����
		p.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  //������ʾˮƽ������
		p.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  //������ʾ��ֱ������
		splitPane1.setLeftComponent(p);  //����й������Ĵ������ϰ벿����ߵ�λ��
		frame.pack();
		JToolBar toolbar = new JToolBar();  //��ӹ��������	
		GridLayout gd=new GridLayout(8,1);
		toolbar.setLayout(gd);
		JButton send = new JButton("send");

		JTextField textField = new JTextField("",15);
		splitPane.setBottomComponent(textField);
		
		toolbar.add(new JLabel());
		toolbar.add(send);   //��ӷ��ͼ�
		toolbar.add(new JLabel());
		toolbar.add(new JLabel());
		send.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String text;
				text=textArea.getText()+textField.getText()+"\n";
				textArea.setText(text);
				textField.setText("");
			}});	
		JButton Quit = new JButton("Quit");
		toolbar.add(Quit);   //����뿪��
		Quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}});
		toolbar.setOrientation(JToolBar.VERTICAL);  // �������Ĺ�����ֱ����
		splitPane1.setRightComponent(toolbar); //�ѹ�������ӽ����ϲ��Ҳ�������

		
		frame.pack();//���	
		
	}

	
	public static void main(String args[])
	{
		ChatClient c = new ChatClient();
		c.launchFrame();
		
	}

}
