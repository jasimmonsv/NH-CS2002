package KW.CH07;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.AbstractSet;
import java.util.AbstractMap;
import java.util.Iterator;

public class NavigableMapUtils {

    /*<listing chapter="7" number="14">*/
    /**
     * Returns the average of the numbers in its Map argument
     * @param valueMap The map whose values are averaged
     * @return The average of the map values
     */
    public static double computeAverage(Map<Integer, Double> valueMap) {
        int count = 0;
        double sum = 0;
        for (Map.Entry<Integer, Double> entry : valueMap.entrySet()) {
            sum += entry.getValue().doubleValue();
            count++;
        }
        return sum / count;
    }

    /**
     * Returns a list of the averages of nonoverlapping spans
     * of values in its NavigableMap argument.
     * @param delta The number of map values in each span
     * @return A List of average values for each span
     */
    public static List<Double> computeSpans(NavigableMap<Integer, Double> valueMap,
            int delta) {
        List<Double> result = new ArrayList<Double>();
        Integer min = valueMap.firstEntry().getKey();
        Integer max = valueMap.lastEntry().getKey();
        for (int index = min; index <= max; index += delta) {
            double average =
                    computeAverage(valueMap.subMap(index, true,
                    index + delta, false));
            result.add(average);
        }
        return result;
    }
    /*</listing>*/

    /*<exercise chapter="7" section="7" type="programming" number="2">*/
    public static void main(String[] args) {
        int[][] stormsArray = {
            {1960, 10},
            {1961, 5},
            {1962, 20},
            {1963, 8},
            {1964, 16},
            {1965, 50},
            {1966, 25},
            {1967, 15},
            {1968, 21},
            {1969, 13}};

        NavigableMap<Integer, Double> storms = new TreeMap<Integer, Double>();
        for (int[] entry : stormsArray) {
            storms.put(entry[0], new Double(entry[1]));
        }
        List<Double> averages = computeSpans(storms, 4);
        List<Double> expected = Arrays.asList(new Double[]{10.75, 26.5, 17.0});
        System.out.println("Computed Result");
        System.out.println(averages);
        System.out.println("Expected Result");
        System.out.println(expected);
        if (expected.equals(averages)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test FAILED");
        }
        averages = computeGaps(storms, 2);
        expected = Arrays.asList(new Double[]{18.4, 18.2});
        System.out.println("Computed Result");
        System.out.println(averages);
        System.out.println("Expected Result");
        System.out.println(expected);
        if (expected.equals(averages)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test FAILED");
        }
    }
    /*</exercise>*/

    /*<exercise chapter="7" section="7" type="programming" number="3">*/
    /**
     * A SkipMap is a non-modifiable map view of a map that 
     * starts at the  start item, and contains every gap items 
     * in the original map.
     */
    private static class SkipMap<K, V> extends AbstractMap<K, V> {

        Set<Map.Entry<K, V>> entrySet;

        /**
         * Construct a new SkipMap
         * @param map The original map
         * @param start The index of the first item
         * @param gap The number of items between items
         */
        public SkipMap(Map<K, V> map, int start, int gap) {
            entrySet = new SkipSet(map.entrySet(), start, gap);
        }

        /**
         * Return a Set view of the mappings contained in this map
         * @return a Set view of the mappings contained in this map
         */
        public Set<Map.Entry<K, V>> entrySet() {
            return entrySet;
        }
    }

    /**
     * A SkipSet is a Set view of a set that starts at the 
     * start item and contains every gap items
     */
    private static class SkipSet<E> extends AbstractSet<E> {

        private Set<E> theSet;
        private int start;
        private int gap;
        private int size;

        /**
         * Construct a new SkipSet
         * @param theSet The set
         * @param start The start index
         * @param gap The gap
         */
        public SkipSet(Set<E> theSet, int start, int gap) {
            this.theSet = theSet;
            this.start = start;
            this.gap = gap;
            size = (theSet.size() - start) / gap;
        }

        /**
         * Return the size of this set
         */
        public int size() {
            return size;
        }

        /**
         * Skip iterator
         */
        private class SkipIterator implements Iterator<E> {

            private int index = 0;
            private int pos = 0;
            private Iterator<E> baseIterator;

            public SkipIterator() {
                index = start;
                baseIterator = theSet.iterator();
            }

            public boolean hasNext() {
                return index < theSet.size();
            }

            public E next() {
                while (pos < index) {
                    baseIterator.next();
                    pos++;
                }
                pos++;
                index += gap;
                return baseIterator.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public Iterator<E> iterator() {
            return new SkipIterator();
        }
    }

    public static List<Double> computeGaps(Map<Integer, Double> valueMap,
            int gap) {
        List<Double> result = new ArrayList<Double>();
        for (int i = 0; i < gap; i++) {
            double average =
                    computeAverage(new SkipMap<Integer, Double>(valueMap, i, gap));
            result.add(average);
        }
        return result;
    }
    /*</exercise>*/
}
