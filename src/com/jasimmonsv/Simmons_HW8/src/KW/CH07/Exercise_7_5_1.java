package KW.CH07;

import java.util.Map;

public class Exercise_7_5_1 {

    /*<exercise chapter="7" section="5" type="programming" number="1">*/
    /**
     *  Method to display the key-value pairs in a Map, one pair per line.
     */
    public static <K, V> void displayMap(Map<K, V> m) {
        for (Map.Entry<K, V> e : m.entrySet()) {
            System.out.println(e.getKey() + "\t" + e.getKey());
        }
    }
    /*</exercise>*/
}


	
