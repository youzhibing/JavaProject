package com.yzb.lee.jdbc.pool;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils
{
    private static String driverClass = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;

    static
    {
        try
        {
            // 为四个变量参数赋值
            // 获得配置文件 读取配置文件中的键值对 根据键获得对应值进行赋值
            InputStream in = new FileInputStream("resources/jdbc.properties");
            // 集合对象
            Properties pro = new Properties();
            pro.load(in);// 将输入流中的键值对转换成Properties对象内部的键值对形式

            // 通过Properties的getProperty(key)方法 获得对应的值value
            driverClass = pro.getProperty("driverClass");
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");

            Class.forName(driverClass);// 执行一次
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // 获得链接对象的方法
    public static Connection getConnection() throws Exception
    {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    // 关闭资源的方法
    public static void close(ResultSet rs, Statement stmt, Connection conn)
    {

        if (rs != null)
        {
            try
            {
                rs.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            } finally
            {
                rs = null;
            }
        }
        if (stmt != null)
        {
            try
            {
                stmt.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            } finally
            {
                stmt = null;
            }
        }
        if (conn != null)
        {

        }

    }
}
