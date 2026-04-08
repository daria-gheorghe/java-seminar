package collectionsIntro;


import java.util.*;

public class ListExamples {

//    Provides ready-to-use data structures (e.g., ArrayList, HashSet, HashMap).9
//    Offers interfaces (Collection, List, Set, Map, Queue) to define standard behaviors.
//    Supports dynamic resizing, unlike arrays with a fixed size.
//    Includes algorithms (sorting, searching, iteration) via the Collections utility class.
//    Improves code reusability and performance by reducing boilerplate code.

    public static void main(String[] args) {
        //old fashion
        String[] arr = new String[10];
        arr[0] = "string 1";
        arr[1] = "string 2";
        for(int i=0; i< 10; i++){
            System.out.println(arr[i]);
        }

        // Example 1
        List<String> list = new ArrayList<>();

        list.add("string 1");
        list.add("string 2");
        list.add("string 3");
        System.out.println(list);

        list.stream().forEach(x-> System.out.println(x));

        for(String s: list){
            System.out.println(s);
        }

        System.out.println("--------Collections.addAll()");
        Collections.addAll(list,"string 4", "string 5");
        System.out.println(list);

        System.out.println("--------delete");
        list.remove("string 3");
        list.remove(0);
        System.out.println(list);

        System.out.println("--------searching elements");
        if (list.contains("string 4")){
            System.out.println("String 4 exists");
        }

        System.out.println("---------updating elements");
        list.add(0,"string 1");
        list.set(0,"string 8");
        System.out.println(list);

        System.out.println("---------sorting a collection");
        Collections.sort(list);
        System.out.println(list);

        List<Dog> d1 = new ArrayList<>();
        d1.add(new Dog("john 1", 10));
        d1.add(new Dog("john 2", 7));
        d1.add(new Dog("john 3", 9));
        System.out.println(d1);
        Collections.sort(d1);
        System.out.println(d1);
        d1.sort(Comparator.comparing(Dog::getName));
        System.out.println(d1);

        System.out.println("---------iterator");
        Iterator<Dog> iterator = d1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
