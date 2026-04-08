package inheritance;

import java.util.Objects;

public class Animal
{
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

class Dog extends Animal implements Ibehaviour
{

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
    public boolean equals(Object o)
    {
        if (this == o) return true; //this=d    //o=d2      //verifica daca au aceeasi adresa din memorie
        if (!(o instanceof Dog)) return false;  //verificam ca obiectele pe care le comparam sunt de acelasi tip

        Dog d = (Dog) o;    //cast - transform un obiect mai generic in ceva mai specific
        //altfel pt obiectul 'o' nu am putea accesa varsta si numele (pt ca el vine ca param pur si simplu Object)
        return this.age == d.age && this.name.equals(d.name);   //returneaza true daca ambele conditii sunt egale
    }

    @Override   //la pachet cu metoda equals, trebuie implementata si asta
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class Cat extends Animal
{
    void sound(){
        System.out.println("Cat makes meow");
    }
}

class Horse extends Animal implements Ibehaviour, Comparable<Horse> //pt a compara liste
{
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
    public int compareTo(Horse o)
    {
        return this.name.compareTo(o.name); //identice: 0   //altfel:-3
    }
}

