package com.yzb.lee.jdbc.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnhanceConnection extends AbstractDatasourse
{
    private Connection conn;

    public EnhanceConnection(Connection conn)
    {
        this.conn = conn;
    }

    @Override
    public void close() throws SQLException
    {
        // 将conn返回池子中
        MyDataSource.giveBack(conn);
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException
    {
        return conn.prepareStatement(sql);
    }
}
