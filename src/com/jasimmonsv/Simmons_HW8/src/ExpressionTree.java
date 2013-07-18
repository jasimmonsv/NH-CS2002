import java.io.*;

import inclass.TextIO;

/**
 * 
 * Represents an expression tree, with nodes
 *  that are either are:
 *  
 *    - Integer objects, representing values, or
 *    
 *    - Character objects, representing operators
 * 
 * Note that the type of node listed below is Object - so
 *  when reading an Object out of a node, you'll have to
 *  check its type using instanceof or similar.
 *  
 *  You'll need to get the tree via getTree(), then
 *   read in the actual node data using BinaryTree's readBinaryTree()
 *  
 *  Part of HW 8 in CSCI 2002, Spring 2002
 *    
 * @author eric
 *
 */

public class ExpressionTree 
{

	private BinaryTree<String> theTree;
	
	public ExpressionTree()
	{
		theTree = new BinaryTree<String>();
	}
	
	public BinaryTree<String> readBinaryTree() throws IOException
	{
		TextIO.putln("Enter preorder expression tree, as in example on p.311");
		
		theTree = BinaryTree.readBinaryTree(new BufferedReader(new InputStreamReader(System.in)));
		
		return theTree;
	}
	
	public BinaryTree<String> getTree()
	{
		return theTree;
	}
	
	public int evaluate()
	{
		// finish this as described
		
		return 0;
	}
}
