/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class JdbcUtilSingleton {
	private String url="jdbc:mysql://127.0.0.1/test";
	private String user="root";
	private String password="";
	
	private static JdbcUtilSingleton instance=null;
	
	private JdbcUtilSingleton(){}
	
	public static JdbcUtilSingleton getInstance(){
		if(instance==null){
			synchronized(JdbcUtilSingleton.class){
				if(instance==null){
					instance=new JdbcUtilSingleton();
				}
			}
		}
		return instance;
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
	}

}
