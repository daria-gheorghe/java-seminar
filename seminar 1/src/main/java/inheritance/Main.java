package inheritance;

public class Main {
    public static void main(String[] args) {

        Dog a;
        a = new Dog();  //1.	Se aloca memorie pentru un Dog.
                        //2.	Se ruleaza constructorul Dog().
                        //3.	Dar inainte de Dog(), Java trebuie sa ruleze constructorul parintelui (Animal)
        a.sound();  //Dog barks
                    //Animal makes a sound

        Cat b;
        b=new Cat();
        b.sound();  //Cat makes meow
    }
}
