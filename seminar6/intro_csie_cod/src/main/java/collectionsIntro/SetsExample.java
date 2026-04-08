package collectionsIntro;

import java.util.HashSet;
import java.util.Set;

public class SetsExample {

//    In Java, the Set interface is a part of the Java Collection Framework, located in the java.util package.
//    It represents a collection of unique elements, meaning it does not allow duplicate values.
//
//    The set interface does not allow duplicate elements.
//    It can contain at most one null value except TreeSet implementation which does not allow null.
//    The set interface provides efficient search, insertion, and deletion operations.

//    Classes that implement the Set interface
//    HashSet: A set that stores unique elements without any specific order, using a hash table and allows one null element.
//    EnumSet : A high-performance set designed specifically for enum types, where all elements must belong to the same enum.
//    LinkedHashSet: A set that maintains the order of insertion while storing unique elements.
//    TreeSet: A set that stores unique elements in sorted order, either by natural ordering or a specified comparator.

    public static void main(String[] args) {

        Set<String> s = new HashSet<>();
        s.add("banana");
        s.add("apple");
        s.add("banana");
        System.out.println(s);

        Set<Dog> d = new HashSet<>();
        d.add(new Dog("john1",3));
        d.add(new Dog("john1",3));
        d.add(new Dog("john2",8));
        System.out.println(d);

        /// to act like a hashset we need to implement equals and hashset
       //!!! A HashSet itself cannot be sorted because it is unordered by design.

        /// very similar operations, no need to repeat what we have in List class
    }
}
