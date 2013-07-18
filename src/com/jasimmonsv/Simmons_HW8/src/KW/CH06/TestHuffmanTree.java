package KW.CH06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class TestHuffmanTree {

    private static HuffmanTree.HuffData[] readHuffData(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<HuffmanTree.HuffData> result = new ArrayList<HuffmanTree.HuffData>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split("\\s+");
            Character c = null;
            if (tokens[0].length() < 1) {
                c = ' ';
            } else {
                c = tokens[0].charAt(0);
            }
            double w = Double.parseDouble(tokens[1]);
            result.add(new HuffmanTree.HuffData(w, c));
        }
        return result.toArray(new HuffmanTree.HuffData[result.size()]);
    }

    public static void main(String[] args) throws Exception {

        HuffmanTree.HuffData[] huffData = readHuffData(args[0]);
        HuffmanTree huffTree = new HuffmanTree();
        huffTree.buildTree(huffData);
        huffTree.printCode(System.out);
        String[] codes = huffTree.getCodes();
        String codedMessage = HuffmanTree.encode("go eagles", codes);
        System.out.println(codedMessage);
        String decodedMessage = huffTree.decode(codedMessage);
        System.out.println(decodedMessage);
    }
}
