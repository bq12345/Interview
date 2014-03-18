/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.Log4JLogger;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public final class SQLZhuRu {
	static Log log=new Log4JLogger("");
	static Logger logger = Logger.getLogger(SQLZhuRu.class);

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		log.logDebug("Debug####################");
		read("'or 1 or'");
		readSafe("'or 1 or'");

	}

	private static void readSafe(String name) throws SQLException,
	ClassNotFoundException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtilSingleton.getInstance().getConnection();
			String sql="select * from student where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			logger.debug(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				logger.debug(rs.getObject(1) + "\t" + rs.getObject(2));
			}
		} finally {
			JdbcUtilSingleton.getInstance().free(rs, ps, conn);
		}
	}

	private static void read(String name) throws SQLException,
			ClassNotFoundException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtilSingleton.getInstance().getConnection();
			st = conn.createStatement();
			String sql="select * from student where name='" + name+"'";
			logger.debug(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				logger.debug(rs.getObject(1) + "\t" + rs.getObject(2));
			}
		} finally {
			JdbcUtilSingleton.getInstance().free(rs, st, conn);
		}
	}
}
