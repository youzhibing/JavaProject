package com.yzb.lee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMysql {

	private static final String URL = "jdbc:mysql://localhost:3306/mytest";
	private static final String MYSQL_CONN_NAME = "root";
	private static final String MYSQL_CONN_PD = "root";

	public static void main(String[] args) throws SQLException {
		Connection conn = getConnection();
		String sql = "select name,age from person";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("name") + "," + rs.getInt("age"));
		}
		closeConn(conn, pstmt, rs);
	}

	/**
	 * 关闭连接
	 * @param conn
	 * @param st
	 * @param rs
	 */
	private static void closeConn(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if(conn != null) { 
				conn.close();
			}
		} catch (SQLException e) {
			
		}
	}

	/**
	 * 获取连接
	 * @return
	 */
	private static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(URL, MYSQL_CONN_NAME,
					MYSQL_CONN_PD);
		} catch (SQLException e) {

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

}
