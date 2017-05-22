package com.yzb.lee.generic;

import java.util.HashSet;
import java.util.Set;


public class GenericTest
{
    
    public static void main(String[] args)
    {
        Set<String> s1 = new HashSet<String>();
        Set<String> s2 = new HashSet<String>();
        Set<String> set = union(s1, s2);
        System.out.println(set);
    }
    
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2)
    {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }
    
    static class Person
    {
        private String name;
        private int age;
        
        public Person(String name, int age)
        {
            super();
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj) 
            {
                return true;
            }
            if (obj instanceof Person) 
            {
                Person person = (Person)obj;
                if (this.name != null && this.name.equals(person.name) && this.age == person.age)
                {
                    return true;
                }
            }
            return false;
        }



        @Override
        public int hashCode()
        {
            final int prime = 31;  
            int result = 1;  
            result = prime * result + age;  
            result = prime * result + ((name == null) ? 0 : name.hashCode());  
            return result%10;
        }
        
    }
}
