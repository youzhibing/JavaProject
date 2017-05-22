package com.yzb.lee;

class Swan 
{
    public static void fly() 
{
        System.out.println("swan can fly ...");
    }
}

class UglyDuck extends Swan 
{
    public static void fly()  //hide Swan.fly
{ 
        System.out.println("ugly duck can't fly ...");
    }
}

public class TestFly 
{
    public static void main(String[] args) 
{
        Swan swan = new Swan();
        Swan uglyDuck = new UglyDuck();
        swan.fly();     //打印swan can fly ...
        uglyDuck.fly(); //还是打印swan can fly ...，hide让人以为是重载了，其实不是
    }
}

