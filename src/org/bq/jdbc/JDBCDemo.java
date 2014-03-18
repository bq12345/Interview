package org.bq.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;



public class JDBCDemo {
	static Logger logger=Logger.getLogger(JDBCDemo.class);
	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 2.建立连接
			conn = JdbcUtilSingleton.getInstance().getConnection();
			// 3.创建语句
			st = conn.createStatement();
			// 4.执行语句
			rs = st.executeQuery("select * from student");
			// 5.处理结果
			while (rs.next()) {
				//System.out.println(rs.getObject(1)+"\t"+rs.getObject(2));
				logger.debug(rs.getObject(1)+"\t"+rs.getObject(2));
			}
		} finally {
			JdbcUtilSingleton.getInstance().free(rs, st, conn);
		}
	}
}
