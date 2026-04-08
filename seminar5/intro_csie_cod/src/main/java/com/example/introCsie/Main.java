package com.example.introCsie;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Dog dog1 = new Dog();
        System.out.println(dog1.getName());
        System.out.println(dog1);

        Dog dog2 = new Dog("azorel",5,"cocker");
        System.out.println(dog2);

        int val = 10;
        int val2 = Integer.parseInt("11");

        Test test = new Test();
        test.toString();

    }
}
