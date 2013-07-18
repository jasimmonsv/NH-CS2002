package p4;

import java.util.Iterator;
/**
 * Part of Problem 4, Take-Home Exam 1
 * CSCI 2002-91 Spring 2012
 * 
 * Implements an Iterator for CircularList.<br><br>
 * 
 * When created, the next node will be the CircularList's current node.
 * 
 * This iterator will always return true for hasNext, if CircularList is non-empty.
 * 
 * 
 * @author eric
 * 
 */

public class CircularListIterator<E> implements Iterator<E>
{

	private CircularList<E> theCList;
	private Node<E> nextCLNode;
	private Node<E> lastReturned;
	
	/**
	 * Initialize the Iterator for the passed CircularList.<br><br>
	 * 
	 * The next node to be returned is the CircularList's current node,
	 * and the last node return is null.<br> 
	 * 
	 * @author eric
	 * 
	 */

	public CircularListIterator(CircularList<E> cList)
	{
		theCList = cList;
		nextCLNode = cList.getCurrentNode();
		lastReturned = null;
	}

	/**
	 * Return true if list is non-empty.<br> 
	 * 
	 * @author eric
	 * 
	 */

	@Override
	public boolean hasNext()
	{
		if (nextCLNode == null)
			return false;
		else
			return true;
	}

	/**
	 * Return the next node in the CircularList.<br> 
	 * 
	 * @author eric
	 * 
	 */


	@Override
	public E next()
	{
		lastReturned = nextCLNode;
		nextCLNode = nextCLNode.next;
		
		return lastReturned.data;
	}

	/**
	 * Remove the node last returned by next().<br>
	 * 
	 * (You are to complete this method.) 
	 * 
	 * @author eric
	 * 
	 */

	@Override
	public void remove()
	{
	// you complete this!
		Node<E> temp = this.lastReturned.next;
		Node<E> temp2 = this.lastReturned.prev;
		this.lastReturned.prev.next = temp;
		this.lastReturned.next.prev = temp2;
		this.next();
		//this.theCList.removeCurrent();
	}

}
