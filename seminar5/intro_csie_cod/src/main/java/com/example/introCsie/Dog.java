package com.example.introCsie;

public class Dog implements Behaviour{
    private String name;
    private int age;
    private String race;

    static int value = 10;

    public Dog(){};

    public Dog(String name, int age, String race) {
        this.name = name;
        this.age = age;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", race='" + race + '\'' +
                '}';
    }

    @Override
    public void bark() {
        System.out.println("HAM HAM");
    }
}
