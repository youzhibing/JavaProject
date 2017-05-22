package com.yzb.lee.myenum;

public enum Planet
{
    MERCURY(3.3, 2.4);
    
    private final double mass;
    private final double radius;
    @SuppressWarnings("unused")
    private final double surfaceGravity;
    
    private static final double G = 6.67;
    
    Planet(double mass, double radius)
    {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity= G * mass / (radius * radius);
    }

}
