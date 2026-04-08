package collectionsIntro;

import java.util.Objects;

public class Dog implements Comparable<Dog> //mostenesc clasa Comparable, trebuie implementata metoda 'compareTo'
{                           //astfel, obiectele pot fi sortate
    private String name;
    private int age;

    public Dog(){}

    public Dog(String name, int age)
    {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;  //trebuie sa fie exact din aceeasi clasa, nu accept mostenire
        //if (!(o instanceof Dog)) return false;  daca era asa accepta mostenire
        Dog dogs = (Dog) o;
        return age == dogs.age && Objects.equals(name, dogs.name);  //este null-safe
        //return this.age == d.age && this.name.equals(d.name);  daca era asa si name==null, atunci arunca exceptie NullPointerException si programul crapa
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Dogs{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Dog other) {
        return Integer.compare(this.age,other.age);
    }
    //age este de tip 'int', iar in java, 'int' este primitiv, nu are metode
    //nu pot folosi compareTo() pt ca ea este metoda de obiect('int' nefiind obiect, fiind primitiv)
    //compare() = metoda care se cheama pe clasa(pe clasa Integer)
    //daca voiam sa compar dupa nume(string) ar fi mers cu compareTo(ca in c#) pt ca String este obiect
}
