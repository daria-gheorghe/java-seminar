package inheritance;    //acelasi pachet ca Main, deci Main poate vedea clasele package-private (non-public) din acelasi package

public class Animal
{
    String name;
    int age;    //vizibile doar in acelasi package (inheritance)

    void sound()    //copiii (Dog, Cat) pot mosteni metoda, dar pot si sa o suprascrie (override)
    {
        System.out.println("Animal makes a sound");
    }
    public Animal(){};  //Daca tu NU ai fi scris niciun constructor in Animal, Java iti genera automat unul default
    public Animal(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
}

//fara pubic : vizibil doar in inheritance
//extends Animal : mosteneste campurile name, age si metodele lui Animal
//implements Ibehaviour : este obligat sa implementeze metoda breath()
class Dog extends Animal implements Ibehaviour
{
    //creeaza un Dog fara sa seteze nimic
    //super() : apeleaza constr default din Animal
    //apoi s ar fi continuat cu corpul lui Dog(), dar aici e gol
    public Dog(){
        super();
    }

    //creeaza un Dog si seteaza name si age folosind logica din Animal(string,int)
    public Dog(String name, int age){
        super(name,age);
    }

    void sound()    //Ce se intampla la apel a.sound(): daca a e un obiect Dog, se executa Dog.sound()
    {
        System.out.println("Dog barks");
        super.sound();  //forteaza apelul metodei din parinte (Animal.sound()), chiar daca ai override in copil
    }

    @Override   //metoda exista pentru ca interfata o cere
    public void breath() {
        System.out.println();
    }   // printeaza doar o linie goala.
}

class Cat extends Animal
{
    void sound(){
        System.out.println("Cat makes meow");
    }
    //suprascrie sound() fara super.sound()
    //deci daca chemi sound() pe un Cat, vezi doar mesajul de aici
}

