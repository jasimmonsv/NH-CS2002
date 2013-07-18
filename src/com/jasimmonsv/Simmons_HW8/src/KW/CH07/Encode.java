/*<exercise chapter="7" type="programming-project" number="1">*/
package KW.CH07;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;

/** Program to encode a file using a Huffman code */
public class Encode {

    /**
     * Main program
     * @param args args[0] is the input args[1] the output
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage java Encode <input file> <output file>");
            System.exit(1);
        }
        try {
            // Build a Huffman tree for the input file
            BufferedReader in = new BufferedReader(new FileReader(args[0]));
            HuffmanTree.HuffData[] freqTable = HuffmanTree.buildFreqTable(in);
            in.close();
            HuffmanTree huffTree = new HuffmanTree();
            huffTree.buildTree(freqTable);
            // Save the Huffman tree to the output file
            ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(args[1]));
            outs.writeObject(huffTree);
            in = new BufferedReader(new FileReader(args[0]));
            // Build a code table
            huffTree.buildCodeTable();
            // Encode the message and write it to the output
            huffTree.encode(in, outs);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
/*</exercise>*/
