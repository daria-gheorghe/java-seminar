package org.example;

public class Student
{
    private String name;
    private int age;

    public Student()
    {
        this.name = "";
        this.age = 0;
    }

    public Student(String name)
    {
        this.name = name;
        this.age = 0;
    }

    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void sayHello()
    {
        System.out.println("Hello, I am " + name);
    }

    private void secretMethod()
    {
        System.out.println("Private method");
    }
}