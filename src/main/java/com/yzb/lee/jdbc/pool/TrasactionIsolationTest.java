package com.yzb.lee.jdbc.pool;

import java.sql.Connection;

public class TrasactionIsolationTest
{
	public static void main(String[] args)
	{
		
	}
	
	public static void isolationTest() throws Exception
	{
		Connection conn = JDBCUtils.getConnection();
		conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);		// 设置当前conn的隔离级别
		conn.setAutoCommit(false);
	}
}
