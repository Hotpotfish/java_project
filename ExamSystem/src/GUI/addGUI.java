package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class addGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addGUI frame = new addGUI();
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
	public addGUI() {
		setTitle("添加题目");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);
		
		JLabel label = new JLabel("请输入要加入的题目：");
		label.setFont(new Font("楷体", Font.PLAIN, 26));
		splitPane_1.setLeftComponent(label);
		
		JTextArea textArea = new JTextArea();
		splitPane_1.setRightComponent(textArea);
		splitPane_1.setDividerLocation(50);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lbla = new JLabel("添加A选项");
		panel.add(lbla);
		
		JTextArea textArea_1 = new JTextArea();
		panel.add(textArea_1);
		
		JLabel lblNewLabel_2 = new JLabel("添加B选项：");
		panel.add(lblNewLabel_2);
		
		JTextArea textArea_2 = new JTextArea();
		panel.add(textArea_2);
		
		JLabel lblNewLabel_1 = new JLabel("添加C选项");
		panel.add(lblNewLabel_1);
		
		JTextArea textArea_5 = new JTextArea();
		panel.add(textArea_5);
		
		JLabel lblNewLabel = new JLabel("添加D选项");
		panel.add(lblNewLabel);
		
		JTextArea textArea_3 = new JTextArea();
		panel.add(textArea_3);
		
		JLabel lblNewLabel_3 = new JLabel("该题目的正确答案");
		panel.add(lblNewLabel_3);
		
		JTextArea textArea_4 = new JTextArea();
		panel.add(textArea_4);
		
		JButton button = new JButton("确定");
		panel.add(button);
		
		splitPane.setDividerLocation(300);
	}
}
