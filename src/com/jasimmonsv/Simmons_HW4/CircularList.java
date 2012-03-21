package com.jasimmonsv.Simmons_HW4;
import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Implements a simple circular list, as per pp 102-3 of text
 * 
 * This is a reworked version of KWLinkedList's code in book.
 * 
 * It removes unnecessary code, and is modified so it only tracks a single
 * currentNode, having an Iterator that always returns it.
 * 
 * 
 * @author eric
 * 
 */

public class CircularList<E>
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
			currentNode.next = currentNode;
			currentNode.prev = currentNode;
		} else
		{
			Node<E> newNode = new Node<E>(item);
			currentNode.next.prev = newNode;
			newNode.next = currentNode.next;
			newNode.prev = currentNode;
			currentNode.next = newNode;
		}

		this.size++; // one more node than before
	}

	public void addBeforeCurrent(E item)
	{
		if (currentNode == null) // first node added to empty list?
		{
			currentNode = new Node<E>(item);
			currentNode.next = currentNode;
			currentNode.prev = currentNode;
		} else
		{
			Node<E> newNode = new Node<E>(item);
			newNode.next = currentNode;
			newNode.prev = currentNode.prev;
			newNode.prev.next = newNode;
			currentNode.prev = newNode;
		}

		this.size++; // one more node than before
	}

	public Node<E> removeCurrent()
	{
		// Remove node and return it, making following Node<E> the new currentNode

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
	 * Return the current element in the list.
	 * 
	 */
	
	public E getCurrent()
	{
		return currentNode.data;
	}
	
	/**
	 * Advance currentNode to next in circular list.
	 */
	
	public void advanceCurrent()
	{
		currentNode = currentNode.next;
	}

	/**
	 * Return the size of the list
	 * 
	 * @return the size of the list
	 */

	public int size()
	{
		return size;
	}

	// /////////////////////////
	// Inner Classes: Node<E> //
	// /////////////////////////

	/**
	 * A Node is the building block for a double-linked list.
	 */
	
	private static class Node<E>
	{
		/** The data value. */
		private E data;

		/** The link to the next node. */
		private Node<E> next = null;

		/** The link to the previous node. */
		private Node<E> prev = null;

		/**
		 * Construct a node with the given data value.
		 * 
		 * @param dataItem
		 *            The data value
		 */
		
		private Node(E dataItem)
		{
			data = dataItem;
		}
		
	} // end class Node

}
