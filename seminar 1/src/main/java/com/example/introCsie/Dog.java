package com.example.introCsie;

public class Dog implements Behaviour
{
    private String name;
    private int age;
    private String race;

    //apartine clasei
    static int value = 10;  //Exista o singura variabila Dog.value pentru toate obiectele Dog

    public Dog(){};

    public Dog(String name, int age, String race)
    {
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

    //suprascriu metodele toString pt ca ea exista deja implicit si ca sa imi afiseze cum vreau eu
    @Override
    public String toString()    //toString:Este o metoda din Object (parintele tuturor claselor in Java)
    {
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
