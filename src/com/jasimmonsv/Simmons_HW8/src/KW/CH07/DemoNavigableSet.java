package KW.CH07;

import java.util.NavigableSet;
import java.util.TreeSet;

public class DemoNavigableSet {

    /*<listing chapter="7" number="12">*/
    public static void main(String[] args) {
        NavigableSet<Integer> odds = new TreeSet<Integer>();
        odds.add(5);
        odds.add(3);
        odds.add(7);
        odds.add(1);
        odds.add(9);
        System.out.println("The original set odds is " + odds);
        NavigableSet<Integer> b = odds.subSet(1, false, 7, true);
        System.out.println("The ordered set b is " + b);
        System.out.println("Its first element is " + b.first());
        System.out.println("Its smallest element >= 6 is " + b.ceiling(6));
    }
    /*</listing>*/
}
