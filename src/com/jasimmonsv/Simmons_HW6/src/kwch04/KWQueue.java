package kwch04;

/*<listing chapter="4" section="3">*/

import java.util.Collection;
import java.util.Queue;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Implements the Queue interface using a LinkedList component.
 * 
 * @author Koffman & Wolfgang
 **/
public class KWQueue<E> implements Queue<E>
{

	// Data Field
	private LinkedList<E> theQueue = new LinkedList<E>(); // LinkedList that is
															// the queue.

	/**
	 * Inserts an item at the rear of the queue.
	 * 
	 * @param item
	 *            The element to add
	 * @return true (always successful)
	 */
	@Override
	public boolean offer(E item)
	{
		theQueue.addLast(item);
		return true;
	}

	/**
	 * Removes the entry at the front of the queue and returns it.
	 * 
	 * @return The item removed if successful, or null if not
	 */
	@Override
	public E poll()
	{
		if (size() == 0)
		{
			return null;
		}
		else
		{
			return theQueue.remove(0);
		}
	}

	/**
	 * Returns the item at the front of the queue without removing it.
	 * 
	 * @return The item at the front if successful; null if not
	 */
	@Override
	public E peek()
	{
		if (size() == 0)
		{
			return null;
		}
		else
		{
			return theQueue.getFirst();
		}
	}

	/* <exercise chapter="4" section="3" type="programming" number="2"> */
	/**
	 * Inserts an item at the rear of the queue.
	 * 
	 * @param item
	 *            The element to add
	 * @return true (always successful)
	 */
	@Override
	public boolean add(E item)
	{
		return offer(item);
	}

	@Override
	/**
	 * Removes the entry at the front of the queue and returns it.
	 *@return The item removed if successful
	 * @throws NoSuchElementException if this queue is empty
	 */
	public E remove()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		return theQueue.poll();
	}

	/**
	 * Retrievs, but does not remove the entry at the front of the queue and
	 * returns it.
	 * 
	 * @return The first entry in the queue if successful
	 * @throws NoSuchElementException
	 *             if this queue is empty
	 */
	@Override
	public E element()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		return peek();
	}

	/**
	 * Returns the number of elements in the queue
	 * 
	 * @return The number of elements in the queue
	 */
	@Override
	public int size()
	{
		return theQueue.size();
	}

	/**
	 * Returns true if this queue is empty
	 * 
	 * @return true if this queue is empty
	 */
	@Override
	public boolean isEmpty()
	{
		return theQueue.size() == 0;
	}

	/**
	 * Retains only those elements in this queue that are contained in the
	 * specified collection
	 * 
	 * @param c
	 *            the specified collection
	 * @return true if this queue changed
	 */
	@Override
	public boolean retainAll(Collection<?> c)
	{
		return theQueue.retainAll(c);
	}

	/**
	 * Removes those elements in this queue that are contained in the specified
	 * collection
	 * 
	 * @param c
	 *            the specified collection
	 * @return true if this queue changed
	 */
	@Override
	public boolean removeAll(Collection<?> c)
	{
		return theQueue.removeAll(c);
	}

	/**
	 * Adds all of the elements in the specified collection to this queue.
	 * 
	 * @param c
	 *            the specified collection
	 * @return true if this queue changed
	 */
	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		return theQueue.addAll(c);
	}

	/**
	 * Returns true if this queue contains the specified element
	 * 
	 * @return true if this queue contains the specified element
	 */
	@Override
	public boolean contains(Object obj)
	{
		return theQueue.contains(obj);
	}

	/**
	 * Returns true if this queue contains all items in the specified collection
	 * 
	 * @param c
	 *            the specified collection
	 * @return true if this queue contains all items c
	 */
	@Override
	public boolean containsAll(Collection<?> c)
	{
		return theQueue.containsAll(c);
	}

	/**
	 * Removes a single instance of the specified element.
	 * 
	 * @param obj
	 *            the object to be removed
	 * @return true if the element was removed
	 */
	@Override
	public boolean remove(Object obj)
	{
		return theQueue.remove(obj);
	}

	@Override
	/**
	 * Returns an array containing all of the elements in this queue.
	 * @return an array containing all of the elements in this queue.
	 */
	public Object[] toArray()
	{
		return theQueue.toArray();
	}

	/**
	 * Returns an array containing all of the elements in this queue. The
	 * runtime type of the returned array is that of the specified array. If the
	 * queue fits in the specified array, it is the returned item. If there is
	 * room to spare the element immediately following the end of the queue is
	 * set to null.
	 * 
	 * @param a
	 *            the specified array
	 * @return an array containing all of the elements in this queue.
	 */
	@Override
	public <T> T[] toArray(T[] a)
	{
		return theQueue.toArray(a);
	}

	/** Removes all elements from this queue. */
	@Override
	public void clear()
	{
		theQueue.clear();

	}

	/**
	 * Returns an iterator over the elements in the queue
	 * 
	 * @return an iterator over the elements in the queue
	 */
	@Override
	public Iterator<E> iterator()
	{
		return theQueue.iterator();
	}

	/* </exercise> */
}
/* </listing> */
