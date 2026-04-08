package genericsIntro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Examples {

    public static void main(String[] args) {
        //Generic permit:
//       -> scrii cod o singură dată
//       -> și funcționează pentru mai multe tipuri
//       -> în siguranță la compilare
//
//        static class Box<T>
//        {
//            public Box(T value){...} //constructorul
//            public T getValue() {...} //getter
//        }

        System.out.println("=== 1. Generic class ===");
        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> intBox = new Box<>(123);

        System.out.println("String box: " + stringBox.getValue());
        System.out.println("Integer box: " + intBox.getValue());

        //public static <T> void printArray(T[] array) //metoda care accepta orice tip de array
        System.out.println("\n=== 2. Generic method ===");
        Integer[] numbers = {1, 2, 3, 4};
        String[] words = {"Java", "Generics", "Demo"};

        printArray(numbers);
        printArray(words);

        //<T extends Number>    //T trebuie sa fie Number sau subclass
        System.out.println("\n=== 3. Bounded type parameter ===");
        System.out.println("Sum of numbers: " + addNumbers(10, 20));
        System.out.println("Sum of decimals: " + addNumbers(5.5, 4.5));


        System.out.println("\n=== 4. Wildcards ===");
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);

        System.out.println("Total of intList: " + sumList(intList));
        System.out.println("Total of doubleList: " + sumList(doubleList));

        //List<? extends Number>    //accepta orice lista care contine sublclass de Number
        //? extends = read only
        System.out.println("\n=== 5. ? extends example ===");
        List<Integer> sourceNumbers = Arrays.asList(10, 20, 30);
        printNumbers(sourceNumbers);

        //List<? super Integer>
        //accepta Integer, Number, object
        //? super = write
        System.out.println("\n=== 6. ? super example ===");
        List<Number> destination = new ArrayList<>();
        addIntegers(destination);
        System.out.println("Destination after addIntegers: " + destination);

        //test 1:
        Container<String> c = new Container<>("Hello");
        System.out.println(c.getValue());

        //test2:
        printTwice("Java");
        printTwice(10);

        //test3:
        System.out.println(max(10, 20));
        System.out.println(max("Ana", "Mihai"));

        //test4:
        List<String> names = List.of("Ana","Ion","Maria");
        System.out.println(countElements(names));

        //test6:
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }

    // 1. Generic class
    static class Box<T>
    {
        private T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    // 2. Generic method
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // 3. Bounded type parameter
    public static <T extends Number> double addNumbers(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    // 4. Wildcard: accepts a list of any subclass of Number
    public static double sumList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // 5. ? extends = good for reading
    public static void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }

    // 6. ? super = good for writing
    public static void addIntegers(List<? super Integer> list) {
        list.add(100);
        list.add(200);
        list.add(300);
    }


    //// exercitii:
//1. Create a generic class that contains:
//     - private field of type T
//     - constructor
//     - getValue() and setValue()
//and test it at the end
    static class Container<T> {
        private T value;

        public Container(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    //2. Create generic method printTwice(T value) and test it
    public static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }
    //3. Create a method that introduces bounded types: public static <T extends Comparable<T>> T max(T a, T b)
    //Test with Integer and String
    public static <T extends Comparable<T>> T max(T a, T b) {

        if(a.compareTo(b) > 0)
            return a;

        return b;
    }

//4. Create a method countElements that takes in as a parameter a list of generic elements
// and returns the total nr of elements inside that array
public static <T> int countElements(List<T> list) {
    return list.size();
}

//5. Copy lists: fix this method:
//public static void copy(List<?> src, List<?> dest)
// {
//    for (Object o : src)
//        dest.add(o);   // ❌ error
// }
public static <T> void copy(List<T> src, List<T> dest) {
    for(T item : src) {
        dest.add(item);
    }
}

//6. Create a generic Stack implementation
//  methods: push(T item), pop(), peek(), isEmpty()
static class Stack<T> {

    private List<T> elements = new ArrayList<>();

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {

        if(elements.isEmpty())
            return null;

        return elements.remove(elements.size() - 1);
    }

    public T peek() {

        if(elements.isEmpty())
            return null;

        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
}




