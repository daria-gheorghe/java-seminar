package com.example.introCsie;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Dog dog1 = new Dog();   //creez un obiect Dog cu constr default, campurile sunt implicit : null,0,null
        System.out.println(dog1.getName()); //returneaza name
        System.out.println(dog1);   //java face implicit : System.out.println(dog1.toString());
        //care este suprascris de mine
        //Daca nu aveai toString(), afisa adresa obiectului

        Dog dog2 = new Dog("azorel",5,"cocker");    //apel constr cu parametri
        System.out.println(dog2);

        int val = 10;
        int val2 = Integer.parseInt("11");  //transforma din string in int
        //daca string-ul nu e numar valid (ex "11a"), arunca NumberFormatException

    }
}

//Hello world
//null
//Dog{name='null', age=0, race='null'}
//Dog{name='azorel', age=5, race='cocker'}