package com.yzb.lee.myenum;

public enum Orange
{
    NAVEL("yellow", 1.2), TEMPLE("green", 0.2), BLOOD("blue",0.1);
    
    private String color;
    private double weight;
    
    Orange(String color, double weight)
    {
        this.color = color;
        this.weight = weight;
    }

    public String getColor()
    {
        return color;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setColor(String color)
    {
        this.color = color;
    }
}
