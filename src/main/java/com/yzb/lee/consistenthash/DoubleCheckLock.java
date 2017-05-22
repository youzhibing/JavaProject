package com.yzb.lee.consistenthash;

public class DoubleCheckLock
{
    private volatile DoubleCheckLock obj;
    
    private DoubleCheckLock(){}
    
    public DoubleCheckLock getDoubleCheckLock()
    {
        DoubleCheckLock result = obj;
        if (result == null)                     // First check (no locking)
        {
            synchronized(this)
            {
                result = obj;
                if (result == null)             // Second check (with locking)
                {
                    obj = result = new DoubleCheckLock();
                }
            }
        }
        
        return result;
    }
    
    public synchronized DoubleCheckLock getDoubleCheckLock1()
    {
        DoubleCheckLock result = obj;
        if (result == null)           
        {
            obj = result = new DoubleCheckLock();
        }
        
        return result;
    }
    
    public DoubleCheckLock getDoubleCheckLock2()
    {
        DoubleCheckLock result = obj;
        synchronized(this)
        {
            result = obj;
            if (result == null)             // Second check (with locking)
            {
                obj = result = new DoubleCheckLock();
            }
        }
        
        return result;
    }
}
