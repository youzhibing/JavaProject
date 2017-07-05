package com.yzb.lee.compare;

public class Student implements Comparable<Student>
{
	private String name;
	private int age;

	
	
	public Student(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student o)
	{
		/*if (this.age > o.age)
			return 1;
		else if (this.age ==  o.age)
			return 0;
		else
			return -1;*/
		
		return this.age > o.age ? 1 : (this.age == o.age ? 0 : -1);
	}

	public static void main(String[] args)
    {
		Student s1 = new Student("c", 11);
		Student s2 = new Student("c", 22);
		Student s3 = new Student("b", 11);
		Student s4 = new Student("d", 5);
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s3));
        System.out.println(s1.compareTo(s4));
    }
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

}
