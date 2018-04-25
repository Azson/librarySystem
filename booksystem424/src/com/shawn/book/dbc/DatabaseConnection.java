package com.shawn.book.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	public static final String DBURL = "jdbc:mysql://localhost:3306/booksystem";
	
	public static final String DBUSER = "root";
	
	public static final String DBPASSWORD = "240326315";
	
	private Connection conn = null;
	
	public DatabaseConnection(){
		try {
			//加载驱动
			Class.forName(DBDRIVER);
			//创建数据库连接
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * @return
	 */
	public Connection getConn() {
		return this.conn;
	}
	
	/**
	 * 关闭数据库连接
	 */
	public void close(){
		if(this.conn != null){
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}