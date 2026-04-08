package collectionsIntro;

import java.util.Objects;

public class Dog implements Comparable<Dog> {
    private String name;
    private int age;

    public Dog(){}

    public Dog(String name, int age) {
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Dog dogs = (Dog) o;
//        return age == dogs.age && Objects.equals(name, dogs.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }

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
}
