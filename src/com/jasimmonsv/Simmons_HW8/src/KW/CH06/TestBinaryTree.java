package KW.CH06;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *  Class to test the BinaryTree class
 */
public class TestBinaryTree {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BinaryTree<String> tree = BinaryTree.readBinaryTree(br);
        System.out.println(tree);
        System.out.println(tree.preorderToString());
        System.out.println(tree.postorderToString());
        System.out.println(tree.inorderToString());
    }
}

					       
