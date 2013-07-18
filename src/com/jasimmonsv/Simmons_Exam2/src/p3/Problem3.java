package p3;

import java.util.Scanner;

import p2.TextIO;

public class Problem3
{

	/**
	 * Starting code for Problem3 of Take-Home Exam 2.
	 * 
	 * Complete the starting implementation of the isComplete(bt)
	 *   method, returning true iff bt is a complete binary tree.
	 *   Otherwise, return false.
	 *   
	 * Then complete Problem3.main(..) so it reads and builds a binary
	 *   tree bt, calls isComplete(bt) and prints the result.
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

		//System.out.print (bt.inorderToString()); // preorderToString());
		
		if(isComplete(bt))System.out.println("Binary Tree is complete!");
		else{System.out.println("Binary Tree is not complete!");}
		System.out.println(getHeigth(bt));
	}//end method main
	
	public static boolean isComplete(BinaryTree<String> bt)
	{
		if (bt==null) return false;
		else if(bt.isLeaf()) return true;
	
		boolean left = isComplete(bt.getLeftSubtree());
		boolean right = isComplete(bt.getRightSubtree());
		
		if(left == true && right ==true)return true;
		else{return false;}
	}//end method isCompete
	
	/**
	 * 
	 * @param bt binary tree to test
	 * @return int for tree heigth, -1 for incomplete tree
	 */
	private static int getHeigth(BinaryTree<String> bt){
		if( bt==null) return 0;
		else if (bt.isLeaf())return 1;
		int left = getHeigth(bt.getLeftSubtree());
		int right = getHeigth(bt.getRightSubtree());
		if (left > right) return left+1;
		else if (right > left) return right + 1;
		else if (left == right) return left + 1;
		else return -1;
	}//end method getHeigth
	
}
