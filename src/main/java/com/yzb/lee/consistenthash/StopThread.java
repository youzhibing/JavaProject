package com.yzb.lee.consistenthash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StopThread
{
    private static boolean stopRequested;
    
    public static void main(String[] args) throws InterruptedException
    {
        Thread backgroundThread = new Thread(new Runnable() 
        {

            @Override
            public void run()
            {
                int i = 0;
                while (!stopRequested)
                {
                    i ++;
                }
            }
            
        }, "backgroundThread");
        backgroundThread.start();
        
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
    
}
