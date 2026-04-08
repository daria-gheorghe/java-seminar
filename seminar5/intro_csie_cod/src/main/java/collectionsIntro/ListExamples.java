package collectionsIntro;


import java.util.*;

public class ListExamples {
//    Provides ready-to-use data structures (e.g., ArrayList, HashSet, HashMap).9
//    Offers interfaces (Collection, List, Set, Map, Queue) to define standard behaviors.
//    Supports dynamic resizing, unlike arrays with a fixed size.
//    Includes algorithms (sorting, searching, iteration) via the Collections utility class.
//    Improves code reusability and performance by reducing boilerplate code.

    public static void main(String[] args)
    {   //List= colectie ordonata(pastreaza ordinea), indexata, permite duplicate, implementata cu
        // ArrayList (resize automat, iterare simpla, sortare usoara, metode utile-add,remove)

        //Array normal: dimensiune fixa
        String[] arr = new String[10];
        arr[0] = "string 1";
        arr[1] = "string 2";
        for(int i=0; i< 10; i++){
            System.out.println(arr[i]);
        }


        List<String> list = new ArrayList<>();
        list.add("string 1");
        list.add("string 2");
        list.add("string 3");
        System.out.println(list);

        list.stream().forEach(x-> System.out.println(x));   //varianta noua de parcurgere, cu lambda
        //list.stream(): creeaza un stream din lista, stream este doar o vedere asupra datelor
        //forEach: executa o operatie pe fiecare element din stream
        //x: elementul curent din lista

        //varianta clasica de parcurgere si afisare:
        for(String s: list){
            System.out.println(s);
        }

        System.out.println("--------Collections.addAll()");
        Collections.addAll(list,"string 4", "string 5");    //adauga mai multe elemente simultan in lista
        System.out.println(list);

        System.out.println("--------delete");   //xista 2 metode de remove() :
        list.remove("string 3");    //sterge primul element egal cu "string 3"
        list.remove(0); //sterge elementul dupa index (aici de pe pozitia 0)
        System.out.println(list);

        System.out.println("--------searching elements");
        if (list.contains("string 4"))  //verifica daca lista contine elementul - returneaza true/false
        {
            System.out.println("String 4 exists");
        }

        System.out.println("---------updating elements");
        list.add(0,"string 1"); //add: inserare pe pozitia 0, muta toate elementele la dreapta
        list.set(0,"string 8");     //set: inlocuieste elementul de la pozitia 0
        System.out.println(list);

        System.out.println("---------sorting a collection");
        Collections.sort(list); //sorteaza lista alfabetic, functioneaza pt ca String implementeaza Comparable
        System.out.println(list);

        List<Dog> d1 = new ArrayList<>();   //creeaza lista de obiecte Dog
        d1.add(new Dog("john 1", 10));
        d1.add(new Dog("john 2", 7));
        d1.add(new Dog("john 3", 9));
        System.out.println(d1);
        Collections.sort(d1);   //sortare default dupa varsta, pt ca Dog implements Comparable<Dog> si am definit compareTo()
        System.out.println(d1);
        d1.sort(Comparator.comparing(Dog::getName));    //sortare custom dupa nume
        System.out.println(d1);

        System.out.println("---------iterator");    //parcurgere cu iterator
        Iterator<Dog> iterator = d1.iterator(); //creez iterator pt lista(obiect care parcurge lista element cu element)
        while(iterator.hasNext())   //verifica daca exista element urmator, returneaza true/false
        {
            System.out.println(iterator.next());    //returneaza elementul curent si avanseaza pozitia

        }
        //echivalenta cu :
//        for(Dog d : d1)
//        {
//            System.out.println(d);
//        }

        //rezumat:
//        operație                metodă

//        adăugare multiplă       Collections.addAll
//        ștergere după valoare   remove(obj)
//        ștergere după index     remove(index)
//        verificare existență    contains
//        inserare pe poziție     add(index,value)
//        modificare element      set
//        sortare implicită       Collections.sort
//        sortare custom          Comparator
//        iterare manuală         Iterator

    }
}
