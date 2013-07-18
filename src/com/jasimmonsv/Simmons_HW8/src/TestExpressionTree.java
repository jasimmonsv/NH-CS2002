import java.io.*;


public class TestExpressionTree
{

	/**
	 * Starting code for HW 8.1.
	 * 
	 * Finish this!
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) throws IOException
	{
		ExpressionTree toEval = new ExpressionTree();
		
		toEval.getTree();
		
		BinaryTree<String> toFill = toEval.readBinaryTree();
		
		inclass.TextIO.putln(toFill.preorderToString());

	}

}
