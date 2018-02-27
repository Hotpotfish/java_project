package GUI;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.GridLayout;

import Main.con2mysql;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.SpringLayout;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import net.miginfocom.swing.MigLayout;

import java.awt.Font;
import java.sql.ResultSet;

public class TeacherGUI extends JFrame {

	con2mysql con ;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public TeacherGUI(con2mysql connec) {
		this.con=connec;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[53px][53px][53px][53px][53px][53px][53px]", "[16px][][16px][16px][16px][16px][][16px][16px][][16px][][16px][][16px][][16px][16px][16px][16px][16px][16px][16px][16px][16px][16px][16px]"));
		
		JLabel label_61 = new JLabel("");
		contentPane.add(label_61, "cell 6 0,grow");
		
		JLabel label = new JLabel("欢迎你！");
		label.setFont(new Font("宋体", Font.PLAIN, 28));
		contentPane.add(label, "cell 3 1,grow");
		
		JLabel label_67 = new JLabel("");
		contentPane.add(label_67, "cell 0 2,grow");
		
		JLabel label_68 = new JLabel("");
		contentPane.add(label_68, "cell 1 2,grow");
		
		JLabel label_69 = new JLabel("");
		contentPane.add(label_69, "cell 2 2,grow");
		
		JLabel label_70 = new JLabel("");
		contentPane.add(label_70, "cell 3 2,grow");
		
		JLabel label_71 = new JLabel("");
		contentPane.add(label_71, "cell 4 2,grow");
		
		JLabel label_72 = new JLabel("");
		contentPane.add(label_72, "cell 5 2,grow");
		
		JLabel label_73 = new JLabel("");
		contentPane.add(label_73, "cell 6 2,grow");
		
		JLabel label_74 = new JLabel("");
		contentPane.add(label_74, "cell 0 3,grow");
		
		JLabel label_75 = new JLabel("");
		contentPane.add(label_75, "cell 1 3,grow");
		
		JLabel label_76 = new JLabel("");
		contentPane.add(label_76, "cell 2 3,grow");
		
		JLabel label_77 = new JLabel("");
		contentPane.add(label_77, "cell 3 3,grow");
		
		JLabel label_78 = new JLabel("");
		contentPane.add(label_78, "cell 4 3,grow");
		
		JLabel label_79 = new JLabel("");
		contentPane.add(label_79, "cell 5 3,grow");
		
		JLabel label_80 = new JLabel("");
		contentPane.add(label_80, "cell 6 3,grow");
		
		JLabel label_81 = new JLabel("");
		contentPane.add(label_81, "cell 0 4,grow");
		
		JLabel label_82 = new JLabel("");
		contentPane.add(label_82, "cell 1 4,grow");
		
		JLabel label_83 = new JLabel("");
		contentPane.add(label_83, "cell 2 4,grow");
		
		JLabel label_84 = new JLabel("");
		contentPane.add(label_84, "cell 3 4,grow");
		
		JLabel label_85 = new JLabel("");
		contentPane.add(label_85, "cell 4 4,grow");
		
		JLabel label_86 = new JLabel("");
		contentPane.add(label_86, "cell 5 4,grow");
		
		JLabel label_87 = new JLabel("");
		contentPane.add(label_87, "cell 6 4,grow");
		
		JLabel label_88 = new JLabel("");
		contentPane.add(label_88, "cell 0 5,grow");
		
		JLabel label_89 = new JLabel("");
		contentPane.add(label_89, "cell 1 5,grow");
		
		JLabel label_90 = new JLabel("");
		contentPane.add(label_90, "cell 2 5,grow");
		
		JLabel label_91 = new JLabel("");
		contentPane.add(label_91, "cell 3 5,grow");
		
		JLabel label_92 = new JLabel("");
		contentPane.add(label_92, "cell 4 5,grow");
		
		JLabel label_93 = new JLabel("");
		contentPane.add(label_93, "cell 5 5,grow");
		
		JLabel label_94 = new JLabel("");
		contentPane.add(label_94, "cell 6 5,grow");
		
		JButton btnNewButton_1 = new JButton("答题情况");
		
		contentPane.add(btnNewButton_1, "cell 3 6,grow");
		
		JLabel label_95 = new JLabel("");
		contentPane.add(label_95, "cell 0 7,grow");
		
		JLabel label_96 = new JLabel("");
		contentPane.add(label_96, "cell 1 7,grow");
		
		JLabel label_97 = new JLabel("");
		contentPane.add(label_97, "cell 2 7,grow");
		
		JLabel label_98 = new JLabel("");
		contentPane.add(label_98, "cell 3 7,grow");
		
		JLabel label_99 = new JLabel("");
		contentPane.add(label_99, "cell 4 7,grow");
		
		JLabel label_100 = new JLabel("");
		contentPane.add(label_100, "cell 5 7,grow");
		
		JLabel label_101 = new JLabel("");
		contentPane.add(label_101, "cell 6 7,grow");
		
		JLabel label_102 = new JLabel("");
		contentPane.add(label_102, "cell 0 8,grow");
		
		JLabel label_103 = new JLabel("");
		contentPane.add(label_103, "cell 1 8,grow");
		
		JLabel label_104 = new JLabel("");
		contentPane.add(label_104, "cell 2 8,grow");
		
		JLabel label_105 = new JLabel("");
		contentPane.add(label_105, "cell 3 8,grow");
		
		JLabel label_106 = new JLabel("");
		contentPane.add(label_106, "cell 4 8,grow");
		
		JLabel label_107 = new JLabel("");
		contentPane.add(label_107, "cell 5 8,grow");
		
		JLabel label_108 = new JLabel("");
		contentPane.add(label_108, "cell 6 8,grow");
		
		JButton btnNewButton = new JButton("学生信息");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoGUI studentInfo=new infoGUI();
				studentInfo.setVisible(true);
			}
		});
		contentPane.add(btnNewButton, "cell 3 9,grow");
		
		JLabel label_109 = new JLabel("");
		contentPane.add(label_109, "cell 0 10,grow");
		
		JLabel label_110 = new JLabel("");
		contentPane.add(label_110, "cell 1 10,grow");
		
		JLabel label_111 = new JLabel("");
		contentPane.add(label_111, "cell 2 10,grow");
		
		JLabel label_112 = new JLabel("");
		contentPane.add(label_112, "cell 3 10,grow");
		
		JLabel label_113 = new JLabel("");
		contentPane.add(label_113, "cell 4 10,grow");
		
		JLabel label_114 = new JLabel("");
		contentPane.add(label_114, "cell 5 10,grow");
		
		JLabel label_115 = new JLabel("");
		contentPane.add(label_115, "cell 6 10,grow");
		
		JButton btnNewButton_2 = new JButton("增加题目");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGUI addgui = new addGUI();
				addgui.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_2, "cell 3 11,grow");
		
		JLabel label_116 = new JLabel("");
		contentPane.add(label_116, "cell 0 12,grow");
		
		JLabel label_117 = new JLabel("");
		contentPane.add(label_117, "cell 1 12,grow");
		
		JLabel label_118 = new JLabel("");
		contentPane.add(label_118, "cell 2 12,grow");
		
		JLabel label_119 = new JLabel("");
		contentPane.add(label_119, "cell 3 12,grow");
		
		JLabel label_120 = new JLabel("");
		contentPane.add(label_120, "cell 4 12,grow");
		
		JLabel label_121 = new JLabel("");
		contentPane.add(label_121, "cell 5 12,grow");
		
		JLabel label_122 = new JLabel("");
		contentPane.add(label_122, "cell 6 12,grow");
		
		JButton btnNewButton_3 = new JButton("返回登陆");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				LoginGUI lg=new LoginGUI();
			}
		});
		contentPane.add(btnNewButton_3, "cell 3 13,grow");
		
		JLabel label_123 = new JLabel("");
		contentPane.add(label_123, "cell 0 14,grow");
		
		JLabel label_124 = new JLabel("");
		contentPane.add(label_124, "cell 1 14,grow");
		
		JLabel label_125 = new JLabel("");
		contentPane.add(label_125, "cell 2 14,grow");
		
		JLabel label_126 = new JLabel("");
		contentPane.add(label_126, "cell 3 14,grow");
		
		JLabel label_127 = new JLabel("");
		contentPane.add(label_127, "cell 4 14,grow");
		
		JLabel label_128 = new JLabel("");
		contentPane.add(label_128, "cell 5 14,grow");
		
		JLabel label_129 = new JLabel("");
		contentPane.add(label_129, "cell 6 14,grow");
		
		JButton button = new JButton("退出系统");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(button, "cell 3 15,grow");
		
		JLabel label_130 = new JLabel("");
		contentPane.add(label_130, "cell 0 16,grow");
		
		JLabel label_131 = new JLabel("");
		contentPane.add(label_131, "cell 1 16,grow");
		
		JLabel label_132 = new JLabel("");
		contentPane.add(label_132, "cell 2 16,grow");
		
		JLabel label_133 = new JLabel("");
		contentPane.add(label_133, "cell 3 16,grow");
		
		JLabel label_134 = new JLabel("");
		contentPane.add(label_134, "cell 4 16,grow");
		
		JLabel label_135 = new JLabel("");
		contentPane.add(label_135, "cell 5 16,grow");
		
		JLabel label_136 = new JLabel("");
		contentPane.add(label_136, "cell 6 16,grow");
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1, "cell 0 17,grow");
		
		JLabel label_2 = new JLabel("");
		contentPane.add(label_2, "cell 1 17,grow");
		
		JLabel label_3 = new JLabel("");
		contentPane.add(label_3, "cell 2 17,grow");
		
		JLabel label_4 = new JLabel("");
		contentPane.add(label_4, "cell 3 17,grow");
		
		JLabel label_5 = new JLabel("");
		contentPane.add(label_5, "cell 4 17,grow");
		
		JLabel label_6 = new JLabel("");
		contentPane.add(label_6, "cell 5 17,grow");
		
		JLabel label_7 = new JLabel("");
		contentPane.add(label_7, "cell 6 17,grow");
		
		JLabel label_8 = new JLabel("");
		contentPane.add(label_8, "cell 0 18,grow");
		
		JLabel label_9 = new JLabel("");
		contentPane.add(label_9, "cell 1 18,grow");
		
		JLabel label_10 = new JLabel("");
		contentPane.add(label_10, "cell 2 18,grow");
		
		JLabel label_11 = new JLabel("");
		contentPane.add(label_11, "cell 3 18,grow");
		
		JLabel label_12 = new JLabel("");
		contentPane.add(label_12, "cell 4 18,grow");
		
		JLabel label_13 = new JLabel("");
		contentPane.add(label_13, "cell 5 18,grow");
		
		JLabel label_14 = new JLabel("");
		contentPane.add(label_14, "cell 6 18,grow");
		
		JLabel label_15 = new JLabel("");
		contentPane.add(label_15, "cell 0 19,grow");
		
		JLabel label_16 = new JLabel("");
		contentPane.add(label_16, "cell 1 19,grow");
		
		JLabel label_17 = new JLabel("");
		contentPane.add(label_17, "cell 2 19,grow");
		
		JLabel label_18 = new JLabel("");
		contentPane.add(label_18, "cell 3 19,grow");
		
		JLabel label_19 = new JLabel("");
		contentPane.add(label_19, "cell 4 19,grow");
		
		JLabel label_20 = new JLabel("");
		contentPane.add(label_20, "cell 5 19,grow");
		
		JLabel label_21 = new JLabel("");
		contentPane.add(label_21, "cell 6 19,grow");
		
		JLabel label_22 = new JLabel("");
		contentPane.add(label_22, "cell 0 20,grow");
		
		JLabel label_23 = new JLabel("");
		contentPane.add(label_23, "cell 1 20,grow");
		
		JLabel label_24 = new JLabel("");
		contentPane.add(label_24, "cell 2 20,grow");
		
		JLabel label_25 = new JLabel("");
		contentPane.add(label_25, "cell 3 20,grow");
		
		JLabel label_26 = new JLabel("");
		contentPane.add(label_26, "cell 4 20,grow");
		
		JLabel label_27 = new JLabel("");
		contentPane.add(label_27, "cell 5 20,grow");
		
		JLabel label_28 = new JLabel("");
		contentPane.add(label_28, "cell 6 20,grow");
		
		JLabel label_29 = new JLabel("");
		contentPane.add(label_29, "cell 0 21,grow");
		
		JLabel label_30 = new JLabel("");
		contentPane.add(label_30, "cell 1 21,grow");
		
		JLabel label_31 = new JLabel("");
		contentPane.add(label_31, "cell 2 21,grow");
		
		JLabel label_32 = new JLabel("");
		contentPane.add(label_32, "cell 3 21,grow");
		
		JLabel label_33 = new JLabel("");
		contentPane.add(label_33, "cell 4 21,grow");
		
		JLabel label_34 = new JLabel("");
		contentPane.add(label_34, "cell 5 21,grow");
		
		JLabel label_35 = new JLabel("");
		contentPane.add(label_35, "cell 6 21,grow");
		
		JLabel label_36 = new JLabel("");
		contentPane.add(label_36, "cell 0 22,grow");
		
		JLabel label_37 = new JLabel("");
		contentPane.add(label_37, "cell 1 22,grow");
		
		JLabel label_38 = new JLabel("");
		contentPane.add(label_38, "cell 2 22,grow");
		
		JLabel label_39 = new JLabel("");
		contentPane.add(label_39, "cell 3 22,grow");
		
		JLabel label_40 = new JLabel("");
		contentPane.add(label_40, "cell 4 22,grow");
		
		JLabel label_41 = new JLabel("");
		contentPane.add(label_41, "cell 5 22,grow");
		
		JLabel label_42 = new JLabel("");
		contentPane.add(label_42, "cell 6 22,grow");
		
		JLabel label_43 = new JLabel("");
		contentPane.add(label_43, "cell 0 23,grow");
		
		JLabel label_44 = new JLabel("");
		contentPane.add(label_44, "cell 1 23,grow");
		
		JLabel label_45 = new JLabel("");
		contentPane.add(label_45, "cell 2 23,grow");
		
		JLabel label_46 = new JLabel("");
		contentPane.add(label_46, "cell 3 23,grow");
		
		JLabel label_47 = new JLabel("");
		contentPane.add(label_47, "cell 4 23,grow");
		
		JLabel label_48 = new JLabel("");
		contentPane.add(label_48, "cell 5 23,grow");
		
		JLabel label_49 = new JLabel("");
		contentPane.add(label_49, "cell 6 23,grow");
		
		JLabel label_50 = new JLabel("");
		contentPane.add(label_50, "cell 0 24,grow");
		
		JLabel label_51 = new JLabel("");
		contentPane.add(label_51, "cell 1 24,grow");
		
		JLabel label_52 = new JLabel("");
		contentPane.add(label_52, "cell 2 24,grow");
		
		JLabel label_53 = new JLabel("");
		contentPane.add(label_53, "cell 3 24,grow");
		
		JLabel label_54 = new JLabel("");
		contentPane.add(label_54, "cell 4 24,grow");
		
		JLabel label_55 = new JLabel("");
		contentPane.add(label_55, "cell 5 24,grow");
		
		JLabel label_56 = new JLabel("");
		contentPane.add(label_56, "cell 6 24,grow");
		
		JLabel label_57 = new JLabel("");
		contentPane.add(label_57, "cell 0 25,grow");
		
		JLabel label_58 = new JLabel("");
		contentPane.add(label_58, "cell 1 25,grow");
		
		JLabel label_59 = new JLabel("");
		contentPane.add(label_59, "cell 2 25,grow");
		
		JLabel label_60 = new JLabel("");
		contentPane.add(label_60, "cell 3 25,grow");
		
		JLabel label_62 = new JLabel("");
		contentPane.add(label_62, "cell 4 25,grow");
		
		JLabel label_63 = new JLabel("");
		contentPane.add(label_63, "cell 5 25,grow");
		
		JLabel label_64 = new JLabel("");
		contentPane.add(label_64, "cell 6 25,grow");
		
		JLabel label_65 = new JLabel("");
		contentPane.add(label_65, "cell 0 26,grow");
		
		JLabel label_66 = new JLabel("");
		contentPane.add(label_66, "cell 1 26,grow");
		setVisible(true);
	}

}
