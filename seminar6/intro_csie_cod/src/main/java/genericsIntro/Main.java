package genericsIntro;

import java.util.ArrayList;
import java.util.List;

public class Main {
//    Generics let you write classes and methods that work with different types while keeping type safety.
//    Without generics, you often store values as Object, and then you have to cast them back later. That is error-prone.
//    With generics you can say:
//    Box<String>
//    Box<Integer>
//    So the compiler knows what type is supposed to be inside.

//    advantages:
//    Type safety at compile time
//    Less casting
//    Reusable code
//    Clearer APIs

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ana");
        names.add("Mihai");

        // names.add(10);   // compile-time error
        String first = names.get(0);   // no cast needed


    }
}
