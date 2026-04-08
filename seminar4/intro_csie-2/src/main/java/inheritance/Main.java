package inheritance;

public class Main {
    public static void main(String[] args) {

        Animal a;
        a = new Dog();
        a.sound();

        a = new Horse();
        a.sound();
        a = new Cat();

// casting
// == vs .equals
//        == - for primitives compares values
//             for objects compares location in memory
//                .equals() compares logical equality(if overridden)

//        equals and hashcode
//        default implementation of equals method in java looks like this:
//        public boolean equals(Object obj) {
//            return (this == obj);
//        }
//  you need to override equals() and hashcode() in order to truly compare 2 objects.
//        why? because objects are complex, and you need to decide what an equality relationship looks like
//        If two objects are equal according to equals(), they MUST have the same hashCode(). (because of collections)

//        int c = 10;
//        int b = 100;
//        if(c==b)...
        Dog d  = new Dog("john",8);
        System.out.println(d);

        Dog d2  = new Dog("john",8);
        System.out.println(d);


        if(d.equals(a)){
            System.out.println("they are the same thing");
        }else{
            System.out.println("not the same objects");
        }



//Comparable and Comparator -used for
//        Collections.sort()
//        TreeSet ; TreeMap

        Horse h = new Horse("bucefal", 10);
        Horse h2 = new Horse("bucefal", 12);
        System.out.println(h2.compareTo(h));


    }
}
