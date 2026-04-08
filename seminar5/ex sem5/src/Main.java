import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.*;



public class Main
{
    public static void main(String[] args)
    {
        //1.create an ArrayList<String> of student names; add at least 5 names; print all names; remove the 3rd name
        List<String> students =new ArrayList<>();
        students.add("ioana");
        students.add("mihai");
        students.add("maria");
        students.add("andrei");
        students.add("alex");
        students.add("ana");
        System.out.println(students);
        students.remove(2);
        System.out.println("Lista dupa stergere:");
        System.out.println(students);

        //2.sum of Integers; create a List<Integer>; add 10 numbers; calculate the sum and average
        List<Integer> numbers=new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        Integer s=0;
        for(Integer i:numbers)
            s+=i;
        System.out.println(s);
        double average=(double) s/numbers.size();
        System.out.println(average);

        //3. reverse a list: given a list o integers , reverse the list manually
        System.out.println("Inainte:");
        System.out.println(numbers);
        List<Integer> reversed = new ArrayList<>();
        for(int i = numbers.size() - 1; i >= 0; i--)
            reversed.add(numbers.get(i));
        System.out.println("Dupa");
        System.out.println(reversed);


        //4. unique words counter:
        //given a sentence , split it into words
        //store them in a Set<String>
        //print unique words and their count
        String sentence="ana are mere mere";
        String[] words=sentence.split(" ");
        Set<String> unique=new HashSet<>();
        for (String word: words)
            unique.add(word);
        System.out.println("unique words: ");
        for (String word: unique)
            System.out.println(word);
        System.out.println("count=  "+ unique.size());


        //5.word frequency counter:
        //input: "apple banana apple orange banana apple"
        //use a Map<String,Integer>
        //count how many times each word appears
        String text="apple banana apple orange banana apple";
        String[] w=text.split(" ");
        Map<String, Integer> frequency = new HashMap<>();
        for(String word : w)
        {
            if(frequency.containsKey(word)) //verific daca exista deja acel cuv in Map
                frequency.put(word, frequency.get(word) + 1);   //.get(word) = returneaza valoarea asociata cheii word
             else frequency.put(word, 1);
        }
        System.out.println(frequency);

        //6.phone book:
        //create a Map<String,String> (name->phone)
        //add entries
        //search by name
        //print all entries
        Map<String,String> phone= new HashMap<>();
        phone.put("ana","0721345679");
        phone.put("mihai","0756432981");
        phone.put("ion","0711234521");
        String name="ana";
        System.out.println(phone.get(name));
        for(Map.Entry<String,String> entry: phone.entrySet())
            System.out.println(entry.getKey()+" " + entry.getValue());

        //7.students management system:
        //given the following class:
//        class Student {
//            String name;
//            int grade;
//        }
        //store students in a List<Student>
        //print all students
        //find the student with the highest grade
        List<Student> stud= new ArrayList<>();
        stud.add(new Student("ana",8));
        stud.add(new Student("mihai",5));
        stud.add(new Student("ion", 7));
        stud.add(new Student("maria",10));
        stud.add(new Student("ana",8));
        System.out.println(stud);
        int grade=0;
        Student bests= new Student();
    for(Student st: stud)
    {
        if(st.grade>grade)
        { grade=st.grade;
            bests=st;
        }
    }
    System.out.println(bests);

    //8.sort students by`;
        // name
        //grade

        Collections.sort(stud);
        System.out.println(stud);

        stud.sort(Comparator.comparing(stt->stt.grade));
        System.out.println(stud);


    //9.remove dupplicates from objects:
        //given a list of students(with duplicates), remove duplicates
        Set<Student> set=new HashSet<>(stud);   //elimina dupliatele automat, pt ca Set nu permite duplicate
        stud=new ArrayList<>(set);
        System.out.println(stud);


        //10.implement a basic cache using LinkedHashMap
        // ->păstrezi doar ultimele N elemente accesate
        // ->când depășești limita → elimini cel mai vechi
        LRUCache<String, Integer> cache = new LRUCache<>(3);
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);
        cache.get("A"); // A devine recent
        cache.put("D", 4); // elimină B
        System.out.println(cache);


        //11.Merge 2 Map<String,Integer>
        //if key overlaps->sum values
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 10);
        map1.put("B", 20);
        map1.put("C", 30);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 5);
        map2.put("C", 15);
        map2.put("D", 25);
        for(String key : map2.keySet()) //parcurg cheile din map2
        {
            if(map1.containsKey(key))
                map1.put(key, map1.get(key) + map2.get(key));
            else map1.put(key, map2.get(key));
        }
        //keySet() -> da cheia
        //get(key) -> da valoarea(de la acea cheie)

    }

}