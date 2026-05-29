package org.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Reflection = capacitatea unui program Java de a-și examina și modifica propria structură la runtime
// (în timp ce rulează), fără să știe dinainte ce clase/metode/câmpuri există.

// Demo annotation that can be read at runtime
@Retention(RetentionPolicy.RUNTIME) // îi spui Java-ului: păstrează această adnotare și după compilare, în timpul rulării. Fără asta, adnotarea dispare și Reflection n-ar putea-o citi
@interface Info //definești o adnotare personalizată numită Info
{
    String author();
    String version();   //atributele adnotării (ca niște câmpuri)
}

@Info(author = "Demo Author", version = "1.0")  //Aplici adnotarea @Info pe clasa Person, cu valorile concrete.
class Person
{

    private String name;
    private int age;

    public Person()
    {
        this.name = "Unknown";
        this.age = 0;
    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name + ".");
    }

    public String greet(String otherPerson) {
        return "Hello " + otherPerson + ", I am " + name + ".";
    }

    private void secretMethod()
    {
        System.out.println("This is a private method.");
    }   //Reflection va apela inclusiv metoda privată.

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class ReflectionDemo
{

    public static void main(String[] args)
    {
        try {
            // Demo 1: Get Class information at runtime
            Class<?> personClass = Person.class;    //obții reprezentarea clasei Person ca obiect Class

            System.out.println("Class name:");
            System.out.println(personClass.getName());  // returnează numele complet: org.example.Person
            System.out.println();

            // Demo 2: Read annotation data
            if (personClass.isAnnotationPresent(Info.class)) //verifici dacă clasa are adnotarea @Info
            {
                Info info = personClass.getAnnotation(Info.class);  //obții obiectul adnotării ca să-i citești valorile

                System.out.println("Annotation data:");
                System.out.println("Author: " + info.author());
                System.out.println("Version: " + info.version());
                System.out.println();
            }

            // Demo 3: List declared fields
            System.out.println("Declared fields:");
            Field[] fields = personClass.getDeclaredFields();   //returnează toate câmpurile declarate în clasă (inclusiv private!)

            for (Field field : fields)
            {
                System.out.println(field.getType().getSimpleName() + " " + field.getName());    //.getSimpleName=tipul câmpului: String, int
            }                   //.getName= numele câmpului: name, age
                //getDeclaredFields() include privatele!!!!!
            // getFields() doar publicele moștenite

            System.out.println();

            // Demo 4: List constructors
            System.out.println("Constructors:");
            Constructor<?>[] constructors = personClass.getDeclaredConstructors();  //returnează toți constructorii clasei

            for (Constructor<?> constructor : constructors)
            {
                System.out.println(constructor);    // afișează semnătura completă, ex: public org.example.Person(java.lang.String, int)
            }

            System.out.println();

            // Demo 5: List declared methods
            System.out.println("Declared methods:");
            Method[] methods = personClass.getDeclaredMethods();    // afișează semnătura completă, ex: public org.example.Person(java.lang.String, int)

            for (Method method : methods)
            {
                System.out.println(method.getReturnType().getSimpleName() + " " + method.getName());    //getSimpleName() — tipul returnat: void, String
            }   //getName() — numele metodei: sayHello, greet, etc.

            System.out.println();

            // Demo 6: Create an object dynamically using a constructor
            Constructor<?> constructor = personClass.getConstructor(String.class, int.class);   //găsești constructorul care primește (String, int)
            Object personObject = constructor.newInstance("Alice", 30); //creezi instanța ca și cum ai scris new Person("Alice", 30)
            System.out.println("Created object:");
            System.out.println(personObject);
            System.out.println();
            //Rezultatul e Object (nu Person) pentru că Reflection lucrează generic


            // Demo 7: Call a public method dynamically
            Method sayHelloMethod = personClass.getMethod("sayHello");  //găsești metoda după nume (doar publice)
            sayHelloMethod.invoke(personObject);    //apelezi metoda pe obiectul personObject, ca și cum ai scrie personObject.sayHello()

            System.out.println();

            // Demo 8: Call a public method with an argument and return value
            Method greetMethod = personClass.getMethod("greet", String.class);  //găsești metoda greet care primește un String
            Object greeting = greetMethod.invoke(personObject, "Bob");  //apelezi cu argumentul "Bob"

            System.out.println("Result from greet method:");
            System.out.println(greeting);
            System.out.println();
            //Rezultatul e Object — conține "Hello Bob, I am Alice."


            // Demo 9: Access and modify a private field
            Field nameField = personClass.getDeclaredField("name"); //găsești câmpul privat name

            // Allows access to a private field
            nameField.setAccessible(true);  //dezactivezi controlul de acces Java. Fără această linie ai primi IllegalAccessException

            System.out.println("Original private name field:");
            System.out.println(nameField.get(personObject));    //citești valoarea câmpului: "Alice"

            nameField.set(personObject, "Charlie"); //schimbi valoarea direct, deși e private

            System.out.println("Modified object:");
            System.out.println(personObject);
            System.out.println();

            // Demo 10: Call a private method
            Method secretMethod = personClass.getDeclaredMethod("secretMethod");    //găsești metoda privată

            // Allows access to a private method
            secretMethod.setAccessible(true);   //din nou, spargi bariera de acces

            System.out.println("Calling private method:");
            secretMethod.invoke(personObject);  //apelezi metoda privată din exterior

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
