package com.yzb.lee;

import java.io.Serializable;
import java.util.Comparator;

public class Host
{
    private static class StrLenCmp implements Comparator<String>, Serializable
    {
        private static final long serialVersionUID = 1L;

        @Override
        public int compare(String s1, String s2)
        {
            return s1.length() - s2.length();
        }
    }
    
    public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();
}
