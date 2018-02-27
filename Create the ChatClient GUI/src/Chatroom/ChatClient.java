package Chatroom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ChatClient {
	public void launchFrame()
	{
		final JFrame frame = new JFrame("chat room"); //顶层容器
		int windowWidth = 800;
		int windowHeight = 600;
		frame.setBounds(50,100,windowWidth,windowHeight);   //设置屏幕的宽窄  ， 50 100 表示 距离屏幕的像素（以最低的像素为准）
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //窗口上面的X键的作用（这里是彻底的关闭）
		frame.setVisible(true); //是否可以变更大小
		JSplitPane splitPane = new JSplitPane(); //分割面板
		splitPane.setOneTouchExpandable(false); // 中间分割线没有小三角形来快速折叠分割面板
		splitPane.setPreferredSize(new Dimension(800,600));
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT); //垂直拆分
		splitPane.setDividerSize(4); //分割线的大小	
		splitPane.setDividerLocation(550); //开始时分割线的位置
		frame.getContentPane().add(splitPane,BorderLayout.CENTER); //添加分割面板到容器
		frame.pack();
		final JSplitPane splitPane1 = new JSplitPane(); //新建一个拆分版把它放到大面板的上部
		splitPane1.setOneTouchExpandable(false); // 中间分割线没有小三角形来快速折叠分割面板
		splitPane1.setPreferredSize(new Dimension(800,550));
		splitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT); //上部拆拆拆分版水平拆分
		splitPane1.setDividerSize(4); //分割线的大小	
		splitPane1.setDividerLocation(650); //开始时分割线的位置
		splitPane.setTopComponent(splitPane1);//将上面的分割块再分成横着的两块
		frame.pack();
		JTextArea textArea = new JTextArea(); //新建JTextArea于上部
		textArea.setColumns(50); // 设置列宽为50	
		textArea.setRows(10);    //设置行高为10
		JScrollPane p  =  new JScrollPane(textArea); //为JTextArea 添加滚动条
		p.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  //总是显示水平滚动条
		p.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  //总是显示垂直滚动条
		splitPane1.setLeftComponent(p);  //添加有滚动条的窗口入上半部分左边的位置
		frame.pack();
		JToolBar toolbar = new JToolBar();  //添加工具栏面板	
		GridLayout gd=new GridLayout(8,1);
		toolbar.setLayout(gd);
		JButton send = new JButton("send");

		JTextField textField = new JTextField("",15);
		splitPane.setBottomComponent(textField);
		
		toolbar.add(new JLabel());
		toolbar.add(send);   //添加发送键
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
		toolbar.add(Quit);   //添加离开键
		Quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}});
		toolbar.setOrientation(JToolBar.VERTICAL);  // 工具栏的工具竖直排列
		splitPane1.setRightComponent(toolbar); //把工具栏添加进入上部右侧的组件中

		
		frame.pack();//打包	
		
	}

	
	public static void main(String args[])
	{
		ChatClient c = new ChatClient();
		c.launchFrame();
		
	}

}
