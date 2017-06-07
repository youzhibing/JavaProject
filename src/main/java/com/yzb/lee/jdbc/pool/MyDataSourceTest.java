package com.yzb.lee.jdbc.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDataSourceTest
{
    public static void main(String[] args) throws SQLException
    {
        // 0、创建连接池对象
        MyDataSource dataSource = MyDataSource.getInstance(10);
        // 1、从池子中获得一个资源对象
        Connection conn = dataSource.getConnection();
        
        // 2、jdbc的操作
        PreparedStatement pstmt = conn
                .prepareStatement("select * from student");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next())
        {
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("chinese"));
            System.out.println(rs.getString("english"));
            System.out.println(rs.getString("math"));
        }
        rs.close();
        pstmt.close();
        // 3、将资源过还给池子
        conn.close();

    }
}
