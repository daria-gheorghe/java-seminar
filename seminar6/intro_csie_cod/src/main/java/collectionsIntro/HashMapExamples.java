package collectionsIntro;

import java.util.HashMap;
import java.util.Map;

public class HashMapExamples {
//        A HashMap is a part of Java’s Collection Framework and implements the Map interface.
//        It stores elements in key-value pairs, where, Keys are unique. and Values can be duplicated.
//        Internally uses Hashing, hence allows efficient key-based retrieval, insertion, and removal with an average of O(1) time.
//        HashMap is not thread-safe, to make it synchronized, use Collections.synchronizedMap().
//        Insertion order is not preserved in HashMap. To preserve the insertion order, LinkedHashMap
//        is used and to maintain sorted order, TreeMap is used.

    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Jane", 23);
        hm.put("John",33);
        hm.put("Joe",45);
        System.out.println(hm);
        hm.remove("Joe");

        for(Map.Entry<String,Integer> entry: hm.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
