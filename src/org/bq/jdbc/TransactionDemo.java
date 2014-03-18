/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class TransactionDemo {
	static Logger logger=Logger.getLogger(TransactionDemo.class);
	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtilSingleton.getInstance().getConnection();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			st = conn.createStatement();
			rs = st.executeQuery("select * from student");
			while (rs.next()) {
				logger.debug(rs.getObject(1)+"\t"+rs.getObject(2));
			}
			conn.commit();
		}
		catch(SQLException e){
			conn.rollback();
		}finally {
			JdbcUtilSingleton.getInstance().free(rs, st, conn);
		}
	}

}
