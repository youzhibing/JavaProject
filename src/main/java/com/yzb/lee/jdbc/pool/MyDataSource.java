package com.yzb.lee.jdbc.pool;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyDataSource
{
    // 存储Connection资源的容器
    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    private static Lock lock = new ReentrantLock();
    
    private static MyDataSource instance = null;

    private MyDataSource()
    {
    }
    
    public static MyDataSource getInstance(int initCount)
    {
        if (null == instance)
        {
            try
            {
                lock.lock();

                if (null == instance)
                {
                    instance =  new MyDataSource();
                    
                    for (int i = 0; i < initCount; i++)
                    {
                        Connection conn = JDBCUtils.getConnection();

                        // 获得原始的conn对象 对该conn进行增强
                        EnhanceConnection enhanceConn = new EnhanceConnection(
                                conn);

                        pool.add(enhanceConn);
                    }
                }
            } catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
            finally
            {
                lock.unlock();
            }
        }
        return instance;
    }

    // 提供一个获得池子中connection资源的方法
    public synchronized Connection getConnection()
    {
        if(pool.isEmpty())
        {
            throw new RuntimeException("jdbc pool is empty");
        }
        return pool.removeFirst();
    }

    // 提供一个将资源归还给池子的方法
    public static void giveBack(Connection conn)
    {
        System.out.println("归还资源前池子中的资源数：" + pool.size());
        pool.addLast(conn);
        System.out.println("归还资源后池子中的资源数：" + pool.size());
    }
}
