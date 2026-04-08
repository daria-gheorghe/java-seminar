package inheritance;

import java.util.Objects;

public class Animal {
    String name;
    int age;

    void sound(){
        System.out.println("Animal makes a sound");
    }
    public Animal(){};
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Dog extends Animal implements Ibehaviour{

    public Dog(){
        super();
    }
    public Dog(String name, int age){
        super(name,age);
    }
    @Override
    void sound(){
        System.out.println("Dog barks");
        super.sound();
    }

    @Override
    public void breath() {
        System.out.println();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;

        Dog d = (Dog) o;
        return this.age == d.age && this.name.equals(d.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class Cat extends Animal{
    void sound(){
        System.out.println("Cat makes meow");
    }
}

class Horse extends Animal implements Ibehaviour, Comparable<Horse>{
    public final String CONSTANTA = "string";
    public Horse(){};

    public Horse(String name, int age){
        super(name,age);
    }

    @Override
    public void sound(){
        System.out.println("Horse sound");
    }

    @Override
    public void breath() {
        System.out.println("Horse breaths");
    }


    @Override
    public int compareTo(Horse o) {
        return this.name.compareTo(o.name);
    }
}

