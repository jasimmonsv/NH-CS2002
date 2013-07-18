package KW.CH07;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {

    /*<exercise chapter="7" section="2" type="programming" number="1">*/
    private static Map<String, Integer> counts =
            new TreeMap<String, Integer>();
    /*</exercise>*/

    /*<exercise chapter="7" section="2" type="programming" number="2">*/
    /**
     *  Method to read each word in a data file and compute the number
     *  of times it occurs
     *  @post count contains each word in lowercase form and the number
     *  of times it occurs.
     *  @param scan A Scanner object that references the file
     */
    public static void buildWordCounts(Scanner scan) {
        while (scan.hasNextLine()) {
            String token;
            while ((token = scan.findInLine("[\\p{L}\\p{N}']+")) != null) {
                token = token.toLowerCase();
                Integer count = counts.get(token);
                if (count == null) {
                    count = 0;
                }
                count = count + 1;
                counts.put(token, count);
            }
            scan.nextLine();
        }
    }
    /*</exercise>*/

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new FileReader(args[0]));
            buildWordCounts(scan);
            for (Map.Entry<String, Integer> e : counts.entrySet()) {
                System.out.printf("%-15s%5d%n", e.getKey(), e.getValue());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(args[0] + " not found");
        }
    }
}
