package p4;

/**
 * Part of Problem 4, Take-Home Exam 1
 * CSCI 2002-91 Spring 2012
 * 
 * A simple node structure for provided CircularList.<br><br>
 * 
 * Each Node has data, along with next and prev references to other Nodes.
 * @author eric
 * 
 */
public class Node<E>
{
	/** The data value. */
	public E data;

	/** The link to the next node. */
	public Node<E> next = null;

	/** The link to the previous node. */
	public Node<E> prev = null;

	/**
	 * Construct a node with the given data value.<br><br>
	 * 
	 * Both next and prev links are null.
	 * 
	 * @param dataItem
	 *            The data value
	 */

	public Node(E dataItem)
	{
		data = dataItem;
	}

} // end class Node