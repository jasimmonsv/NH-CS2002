/*<exercise chapter="7" type="programming-project" number="1">*/
package KW.CH07;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Program to decode a file encoded by huffman codd
 * @author Koffman and Wolfgang */
public class Decode {

    /**
     * Main method
     * @param args - Command Line Arguments
     *        args[0] The name of the encoded input file
     *        args[1] The name of the output file
     */
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream(args[0]);
            ObjectInputStream objIn = new ObjectInputStream(in);
            HuffmanTree huffmanTree = (HuffmanTree) objIn.readObject();
            BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
            huffmanTree.decode(objIn, bw);
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
/*</exercise>*/
