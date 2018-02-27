package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JMenu;

import java.awt.ComponentOrientation;

import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

import com.mysql.jdbc.Connection;

import java.sql.Statement;

import Main.Question;
import Main.con2mysql;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;

public class question extends JFrame {

	con2mysql con;
	private JPanel contentPane;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JPanel panel;
	private JSplitPane splitPane_2;
	private JTextField textField;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private JLabel label;
	private JPanel panel_2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnA;
	private final Action action = new SwingAction();
	private JButton button;
	private JTextArea textArea_1;
	String right[] = new String[200];
	/**
	 * Launch the application.
	 */


	/*
	 * Create the frame.
	 */
	public question(con2mysql con) {
		this.con= con;
		setTitle("Onlie exam system");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 544);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		splitPane = new JSplitPane();
		splitPane.setDividerSize(4);
		splitPane.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		splitPane.setContinuousLayout(true);
		splitPane.setToolTipText("");
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		panel = new JPanel();
		splitPane_1.setRightComponent(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		button = new JButton("\u63D0\u4EA4");
		panel.add(button);
		
		label = new JLabel("");
		panel.add(label);
		
		btnNewButton_1 = new JButton("\u67E5\u770B\u7B54\u6848");
		
		panel.add(btnNewButton_1);
		
		panel_2 = new JPanel();
		splitPane_1.setLeftComponent(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		rdbtnA = new JRadioButton("A");
		panel_2.add(rdbtnA);
		
		rdbtnNewRadioButton_2 = new JRadioButton("B");
		panel_2.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_1 = new JRadioButton("C");
		panel_2.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton = new JRadioButton("D");
		panel_2.add(rdbtnNewRadioButton);
		ButtonGroup group = new ButtonGroup ();
		group.add(rdbtnA);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton);
		
		/*ButtonGroup group = new ButtonGroup ();
		JRadioButton radioButton_1 = new JRadioButton("A");
		JRadioButton radioButton_2 = new JRadioButton("B");
		JRadioButton radioButton_3 = new JRadioButton("C");
		JRadioButton radioButton_4 = new JRadioButton("D");
		group.add(radioButton_1);
		group.add(radioButton_2);
		group.add(radioButton_3);
		group.add(radioButton_4);
		splitPane_1.setTopComponent(group);
		*/
		splitPane_1.setDividerLocation(30);
		
		splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_2);
		
		panel_1 = new JPanel();
		splitPane_2.setLeftComponent(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblNewLabel = new JLabel("\u9898\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 38));
		panel_1.add(lblNewLabel);
		
		
		comboBox = new JComboBox();
		final Map<Integer,String> map = new HashMap<Integer,String>();
		ArrayList que = new ArrayList();
		try {
			String sql = "select * from questiontable;";
			Connection con2 ;
			con2=(Connection) con.con;
			Statement st = (Statement) con2.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int count = 1;
			right[0] = " ";
			comboBox.addItem("");
			while (rs.next()) {
				Question temp = new Question();
				temp.Content = rs.getString("Content");
				temp.AnswerA = rs.getString("PsbAnswer1");
				temp.AnswerB = rs.getString("PsbAnswer2");
				temp.AnswerC = rs.getString("PsbAnswer3");
				temp.AnswerD = rs.getString("PsbAnswer4");
				temp.rightAnswer = rs.getString("Answer");
				temp.queID = rs.getInt("QuestionID");
				temp.Content += "\n\n" + "A." + temp.AnswerA + "\n\n" + "B." + temp.AnswerB + "\n\n" + "C." + temp.AnswerC + "\n\n" + "D." + temp.AnswerD + "\n\n";
				comboBox.addItem(temp.queID);
				map.put(temp.queID,temp.Content);
				que.add(temp);
				right[count] = new String();
				right[count] = temp.rightAnswer;
				count ++;
			}
			
			
			
			
			
			
			
			//comboBox.addItemListener(comboBox);
			
		}
		catch(Exception e)
		{
			
		}
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setForeground(Color.RED);
		textArea_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 33));
		panel_1.add(textArea_1);
		panel_1.add(comboBox);
		//textArea_1.setText((String)comboBox.getSelectedItem());
	
		
		scrollPane = new JScrollPane();
		splitPane_2.setRightComponent(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	//	textArea.setText(map.get(comboBox.getSelectedItem()));
		comboBox.addItemListener(new ItemListener() {
		      public void itemStateChanged(final ItemEvent e) {
		        int index = comboBox.getSelectedIndex();
		        if (index != 0) {
		        	int temp = 0;
		        	temp = Integer.valueOf(comboBox.getSelectedItem().toString());
		        	textArea_1.setText("\n" + "      " +comboBox.getSelectedItem().toString());
		        	textArea.setText(map.get(temp));	        	
		        	// ==0表示选中的事第一个
		        	
		        }
		      }
		    });
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				JLabel label1 = new JLabel("正确答案为：" + right[comboBox.getSelectedIndex()] );
				frame.setBounds(100, 100, 300, 300);
				frame.add(label1);
				frame.setVisible(true);
				
			}
		});
		
		splitPane_2.setDividerLocation(120);
		
		
		splitPane.setDividerLocation(320);
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
