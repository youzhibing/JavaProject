package com.yzb.lee.generic;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class Stack<E>
{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    public Stack()
    {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
    public void push(E e)
    {
        ensureCapacity();
        elements[size++] = e;
    }
    
    public E pop()
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }
        // push requires elements to be of type E, so cast is correct
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
        return result;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public void pushAll(Iterable<? extends E> src)
    {
        for (E e : src)
        {
            push(e);
        }
    }
    
    public void popAll(Collection<? super E> dst)
    {
        while (!isEmpty())
        {
            dst.add(pop());
        }
    }
    
    private void ensureCapacity()
    {
        if (elements.length == size)
        {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
