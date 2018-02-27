package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class con2mysql {
	public Connection con = null;
	
	public con2mysql(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/onlinetestsystem", "root",
					"a59901276");
			System.out.println("数据库连接成功");
			} catch (Exception e) {
			System.out.println("数据库连接失败" + e.getMessage());
		}
	}
	public boolean teacherLogin(String name, String password){
		try {
			String sql = "select * from teacher where TeacherName=\"" + name
					+ "\";"; // 查询数据的sql语句
			Statement st = (Statement) con.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量
			ResultSet rs = st.executeQuery(sql); // 执行sql查询语句，返回查询数据的结果集
			while (rs.next()) {
				String pwd = rs.getString("Password");
				if (pwd.equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("查询数据失败");
		}
		return false;
	}
	
	public boolean studentLogin(String name ,String password){
		try {
			String sql = "select * from st where TeacherName=\"" + name
					+ "\";"; // 查询数据的sql语句
			Statement st = (Statement) con.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量
			ResultSet rs = st.executeQuery(sql); // 执行sql查询语句，返回查询数据的结果集
			while (rs.next()) {
				String pwd = rs.getString("Password");
				if (pwd.equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("查询数据失败");
		}
		return false;
	}

}
