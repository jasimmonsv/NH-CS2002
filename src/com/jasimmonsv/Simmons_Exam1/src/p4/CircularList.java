package p4;

import java.util.Iterator;

/**
 * Part of Problem 4, Take-Home Exam 1
 * CSCI 2002-91 Spring 2012
 * 
 * Implements a simple circular list, which knows its current node.<br><br>
 * 
 * Similar but not identical to class provided in HW 4 PP 5 ("Josephus").
 * 
 * There's at least one bug in the implementation!
 * 
 * 
 * @author eric
 * 
 */

public class CircularList<E> implements Iterable<E>
{
	// Data Fields

	/** A reference to the current node of the list: null if empty. */

	private Node<E> currentNode = null;

	/** The size of the list. */
	private int size = 0;

	/**
	 * Insert an object after the currentNode in this circular list.
	 * 
	 * @param item
	 *            - the item to be added
	 */
	
	public void addAfterCurrent(E item)
	{
		if (currentNode == null) // first node added to empty list?
		{
			currentNode = new Node<E>(item);
			currentNode.prev = currentNode;
			currentNode.next = currentNode;
		}
		else
		// insert new node AFTER currentNode
		{
			Node<E> newNode = new Node<E>(item);
			currentNode.next.prev = newNode;
			newNode.next = currentNode.next;
			newNode.prev = currentNode;
			currentNode.next = newNode;
		}

		this.size++; // one more node than before
	}
	
	/**
	 * Insert an object before the currentNode in this circular list.
	 * 
	 * @param item
	 *            - the item to be added
	 */
	
	public void addBeforeCurrent(E item)
	{
		if (currentNode == null) // first node added to empty list?
		{
			currentNode = new Node<E>(item);
			currentNode.next = currentNode;
			currentNode.prev = currentNode;
		}
		else
		// insert new node BEFORE currentNode
		{
			Node<E> newNode = new Node<E>(item);
			newNode.next = currentNode;
			newNode.prev.next = newNode; //newNode does not have a prev set yet. Move this statement below line 81
			currentNode.prev = newNode;
			newNode.prev = currentNode.prev;
		}

		this.size++; // one more node than before
	}
	
	/**
	 * Remove the current node, making the following node current.<br>
	 * 
	 */
	
	public Node<E> removeCurrent()
	{
		// Remove node and return it, making following Node<E> the new
		// currentNode

		if (size() == 0) // defend against removing an empty
			return null;

		Node<E> toReturn = currentNode;

		if (size() == 1) // last node?
		{
			currentNode = null;
		}
		else
		{
			currentNode = toReturn.next;
			currentNode.prev = toReturn.prev;
			currentNode.prev.next = currentNode;
		}

		size--;
		return toReturn;
	}

	/**
	 * Return the current node's DATA in the circular list.
	 * 
	 */

	public E getCurrent()
	{
		return currentNode.data;
	}

	/**
	 * Return the current node in the circular list.
	 * 
	 */
	
	public Node<E> getCurrentNode()
	{
		return currentNode;
	}

	/**
	 * Advance the current node to the next in circular list.
	 */

	public void advanceCurrent()
	{
		currentNode = currentNode.next;
	}

	/**
	 * Return the size of the list
	 * 
	 */

	public int size()
	{
		return size;
	}

	/**
	 * Get Iterator for this list.
	 * 
	 */

	public Iterator<E> iterator()
	{
		return new CircularListIterator<E>(this);
	}

}
