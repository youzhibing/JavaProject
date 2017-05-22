package com.yzb.lee.myenum;

public class EnumTest
{
    
    public static void main(String[] args)
    {
        /*System.out.println(Orange.NAVEL.getColor());
        Orange.NAVEL.setColor("blank");
        System.out.println(Orange.NAVEL.getColor());*/
        
        Orange temp = Orange.TEMPLE;
        System.out.println(temp.name());
        /*switch(temp)
        {
            case NAVEL:
                System.out.println("blank");
                break;
            case TEMPLE:
                System.out.println("green");
                break;
            default:
                System.out.println(temp);
                break;
        }*/
    }
    
}
