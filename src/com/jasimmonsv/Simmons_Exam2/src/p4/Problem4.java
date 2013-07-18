package p4;

import java.util.Scanner;

import p3.BinaryTree;

public class Problem4
{

	/**
	 * Starting code for Problem 4 of Take-Home Exam 2.
	 * 
	 * Complete the starting implementation of BinaryTree's
	 *   int countExternalNodes().
	 *   
	 * Your implementation MUST be recursive!
	 * 
	 * Then complete Problem4.main(..), reading and creating
	 *   a binary tree from console input, then counting
	 *   and printing the number of external nodes.
	 *   
	 * You must use the provided BinaryTree<E> implementation.
	 * 
	 */
	public static void main(String[] args)
	{
		System.out.println ("Enter a line:");
		Scanner s = new Scanner (System.in);

		BinaryTree<String> bt = new BinaryTree<String>();
		bt = BinaryTree.readBinaryTree(s);
		System.out.println(bt.inorderToString());
		System.out.println(getExNodes(bt));
	}
	
	private static int getExNodes(BinaryTree<String> bt){
		if( bt==null) return 0;
		else if (bt.isLeaf())return 1;
		int left = getExNodes(bt.getLeftSubtree());
		int right = getExNodes(bt.getRightSubtree());
		return left+right;
	}//end method getHeigth

}
