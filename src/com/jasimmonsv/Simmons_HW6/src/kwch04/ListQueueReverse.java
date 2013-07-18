package kwch04;

import java.util.Queue;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements the Queue interface using a single-linked list. The front of the
 * queue is the tail of the list And the rear of the queue is the head of the
 * list
 * 
 * @author Koffman & Wolfgang
 **/
public class ListQueueReverse<E> extends AbstractQueue<E> implements Queue<E>
{

	// Data Fields
	/** Reference to front of queue. */
	private Node<E> front;
	/** Reference to rear of queue. */
	private Node<E> rear;
	/** Size of queue. */
	private int size;

	// Insert inner class Node<E> here (see Listing 2.1)
	/** A Node is the building block for a single-linked list. */
	private static class Node<E>
	{
		// Data Fields

		/** The reference to the data. */
		private E data;
		/** The reference to the next node. */
		private Node<E> next;

		// Constructors
		/**
		 * Creates a new node with a null next field.
		 * 
		 * @param dataItem
		 *            The data stored
		 */
		private Node(E dataItem)
		{
			data = dataItem;
			next = null;
		}

		/**
		 * Creates a new node that references another node.
		 * 
		 * @param dataItem
		 *            The data stored
		 * @param nodeRef
		 *            The node referenced by new node
		 */
		private Node(E dataItem, Node<E> nodeRef)
		{
			data = dataItem;
			next = nodeRef;
		}
	} // end class Node

	// Methods
	/* <exercise chapter="4" section="3" type="programming" number="5"> */
	/**
	 * Insert an item at the rear of the queue.
	 * 
	 * @post item is added to the rear of the queue.
	 * @param item
	 *            The element to add
	 * @return true (always successful)
	 */
	@Override
	public boolean offer(E item)
	{
		// Check for empty queue.
		if (front == null)
		{
			rear = new Node<E>(item);
			front = rear;
		}
		else
		{
			// Allocate a new node at the beginning, store item in it, and
			// link it to old end of queue.
			Node<E> newNode = new Node<E>(item);
			newNode.next = rear;
			rear = newNode;
		}
		size++;
		return true;
	}

	/**
	 * Remove the entry at the front of the queue and return it if the queue is
	 * not empty.
	 * 
	 * @post front references item that was second in the queue.
	 * @return The item removed if successful, or null if not
	 */
	@Override
	public E poll()
	{
		E item = peek(); // Retrieve item at front.
		if (item == null)
		{
			return null;
		}
		// Remove item at front.
		if (front == rear)
		{
			front = null;
			rear = null;
		}
		else
		{
			Node<E> current = rear;
			while (current.next != front)
			{
				current = current.next;
			}
			current.next = null;
			front = current;
		}
		size--;
		return item; // Return data at front of queue.
	}

	/* </exercise> */

	/**
	 * Return the item at the front of the queue without removing it.
	 * 
	 * @return The item at the front of the queue if successful; return null if
	 *         the queue is empty
	 */
	@Override
	public E peek()
	{
		if (size == 0)
		{
			return null;
		}
		else
		{
			return front.data;
		}
	}

	/* <exercise> */
	/**
	 * Returns the size of the queue
	 * 
	 * @return the size of the queue
	 */
	@Override
	public int size()
	{
		return size;
	}

	/**
	 * Returns an iterator to the contents of this queue
	 * 
	 * @return an iterator to the contents of this queue
	 */
	public Iterator<E> iterator()
	{
		return new Iter();
	}

	/**
	 * Inner class to provide an iterator to the contents of the queue.
	 */
	private class Iter implements Iterator<E>
	{

		Node<E> next = front;

		/**
		 * Returns true if there are more elements in the iteration
		 * 
		 * @return true if there are more elements in the iteration
		 */
		@Override
		public boolean hasNext()
		{
			return next != null;
		}

		/**
		 * Return the next item in the iteration and advance the iterator
		 * 
		 * @return the next item in the iteration
		 * @throws NoSuchElementException
		 *             if the iteration has no more elements
		 */
		@Override
		public E next()
		{
			if (next == null)
			{
				throw new NoSuchElementException();
			}
			E item = next.data;
			next = next.next;
			return item;
		}

		/**
		 * Removes the last item returned by this iteration
		 * 
		 * @throws UnsupportedOperationException
		 *             this operation is not supported
		 */
		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	/* </exercise> */
}
