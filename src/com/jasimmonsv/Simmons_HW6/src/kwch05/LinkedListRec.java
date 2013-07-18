/*<listing chapter="5" section="4">*/
package kwch05;

/**
 * A recursive linked list class with recursive methods.
 * 
 * @author Koffman and Wolfgang
 **/
public class LinkedListRec<E>
{

	/** The list head */
	private Node<E> head;

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

	/**
	 * Finds the size of a list.
	 * 
	 * @param head
	 *            The head of the current list
	 * @return The Size of the Current List
	 */
	private int size(Node<E> head)
	{
		if (head == null)
		{
			return 0;
		}
		else
		{
			return 1 + size(head.next);
		}
	}

	/**
	 * Wrapper method for finding the size of a list.
	 * 
	 * @return The size of the list
	 */
	public int size()
	{
		return size(head);
	}

	/**
	 * Returns the string representation of a list.
	 * 
	 * @param head
	 *            The head of the current list
	 * @return The state of the current list
	 */
	private String toString(Node<E> head)
	{
		if (head == null)
		{
			return "";
		}
		else
		{
			return head.data + "\n" + toString(head.next);
		}
	}

	/**
	 * Wrapper method for returning the string representation of a list.
	 * 
	 * @return The string representation of the list
	 */
	@Override
	public String toString()
	{
		return toString(head);
	}

	/**
	 * Replaces all occurrences of oldObj with newObj.
	 * 
	 * @post Each occurrence of oldObj has been replaced by newObj.
	 * @param head
	 *            The head of the current list
	 * @param oldObj
	 *            The object being removed
	 * @param newObj
	 *            The object being inserted
	 */
	private void replace(Node<E> head, E oldObj, E newObj)
	{
		if (head != null)
		{
			if (oldObj.equals(head.data))
			{
				head.data = newObj;
			}
			replace(head.next, oldObj, newObj);
		}
	}

	/*
	 * Wrapper method for replacing oldObj with newObj.
	 * 
	 * @post Each occurrence of oldObj has been replaced by newObj.
	 * 
	 * @param oldObj The object being removed
	 * 
	 * @param newObj The object being inserted
	 */
	public void replace(E oldObj, E newObj)
	{
		replace(head, oldObj, newObj);
	}

	/**
	 * Adds a new node to the end of a list.
	 * 
	 * @param head
	 *            The head of the current list
	 * @param data
	 *            The data for the new node
	 */
	private void add(Node<E> head, E data)
	{
		// If the list has just one element, add to it.
		if (head.next == null)
		{
			head.next = new Node<E>(data);
		}
		else
		{
			add(head.next, data); // Add to rest of list.
		}
	}

	/**
	 * Wrapper method for adding a new node to the end of a list.
	 * 
	 * @param data
	 *            The data for the new node
	 */
	public void add(E data)
	{
		if (head == null)
		{
			head = new Node<E>(data); // List has 1 node.
		}
		else
		{
			add(head, data);
		}
	}

	/**
	 * Removes a node from a list.
	 * 
	 * @post The first occurrence of outData is removed.
	 * @param head
	 *            The head of the current list
	 * @param pred
	 *            The predecessor of the list head
	 * @param outData
	 *            The data to be removed
	 * @return true if the item is removed and false otherwise
	 */
	private boolean remove(Node<E> head, Node<E> pred, E outData)
	{
		if (head == null) // Base case -- empty list.
		{
			return false;
		}
		else if (head.data.equals(outData))
		{ // 2nd base case.
			pred.next = head.next; // Remove head.
			return true;
		}
		else
		{
			return remove(head.next, head, outData);
		}
	}

	/**
	 * Wrapper method for removing a node (in LinkedListRec).
	 * 
	 * @post The first occurrence of outData is removed.
	 * @param outData
	 *            The data to be removed
	 * @return true if the item is removed, and false otherwise
	 */
	public boolean remove(E outData)
	{
		if (head == null)
		{
			return false;
		}
		else if (head.data.equals(outData))
		{
			head = head.next;
			return true;
		}
		else
		{
			return remove(head.next, head, outData);
		}
	}

	/* <exercise chapter="5" section="4" type="programming" number="1"> */
	/**
	 * Method to determine if two LinkedListRec objects are equal. Two
	 * LinkeListRec objects are considered equal if they are of the same size
	 * and each element in corresponding order are equal using the object's
	 * equals method.
	 * 
	 * @param obj
	 *            The other object
	 * @return true of the other obj is equal to this.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (this.getClass() != obj.getClass())
		{
			return false;
		}
		LinkedListRec<E> other = (LinkedListRec<E>) obj;
		return equals(head, other.head);
	}

	/**
	 * Recursive method to determine if two LinkedListRec objects are equal.
	 * 
	 * @param node1
	 *            The current node in this list
	 * @param node2
	 *            The current node in the other list
	 */
	private boolean equals(Node<E> node1, Node<E> node2)
	{
		if (node1 == null & node2 == null)
		{
			return true;
		}
		if (node1 == null)
		{
			return false;
		}
		if (node2 == null)
		{
			return false;
		}
		if (node1.data.equals(node2.data))
		{
			return equals(node1.next, node2.next);
		}
		return false;
	}

	/* </exercise> */

	/* <exercise chapter="5" section="4" type="programming" number="2"> */
	/**
	 * Method to search a LinkedListRec to see if an item is contained in it.
	 * 
	 * @param item
	 *            The item being sought
	 * @return true if the item is in the list, false otherwise
	 */
	public boolean search(E item)
	{
		return search(item, head);
	}

	/**
	 * Recursive method to search a LinkedListRec.
	 * 
	 * @param item
	 *            the item being sought.
	 * @param node
	 *            the current node
	 * @return true if the item being sought is found
	 */
	private boolean search(E item, Node<E> node)
	{
		if (node == null)
		{
			return false;
		}
		if (item.equals(node.data))
		{
			return true;
		}
		return search(item, node.next);
	}

	/* </exercise> */

	/* <exercise chapter="5" section="4" type="programming" number="3"> */
	/**
	 * Method to insert a specified data object before the first occurence of
	 * another specified data object. If the object is not found, then the item
	 * is inserted at the end of the list.
	 * 
	 * @param target
	 *            the item that inData is to be inserted before
	 * @param inData
	 *            the item to be inserted
	 */
	public void insertBefore(E target, E inData)
	{
		if (head == null)
		{
			head = new Node<E>(target, null);
			return;
		}
		if (head.data.equals(target))
		{
			head = new Node<E>(inData, head);
			return;
		}
		insertBefore(target, inData, head);
	}

	/**
	 * Recursive method to insert a specified data object before the first
	 * occurence of another specified data object. If the object is not found,
	 * then the item is inserted at the end of the list.
	 * 
	 * @param target
	 *            the item that inData is to be inserted before
	 * @param inData
	 *            the item to be inserted
	 * @param node
	 *            the curent node
	 */
	private void insertBefore(E target, E inData, Node<E> node)
	{
		if (node.next == null)
		{
			node.next = new Node<E>(inData, null);
			return;
		}
		if (target.equals(node.next.data))
		{
			node.next = new Node<E>(inData, node.next);
			return;
		}
		insertBefore(target, inData, node.next);
	}

	/* </exercise> */

	/* <exercise chapter="5" section="4" type="programming" number="4"> */
	/**
	 * Method to reverse the elements in a linked list
	 * 
	 * @return A LinkedListRec object that contains the same contents of this
	 *         list with the elements reversed.
	 */
	LinkedListRec<E> reverse()
	{
		LinkedListRec<E> result = new LinkedListRec<E>();
		result.head = reverse(head, null);
		return result;
	}

	/**
	 * Method to reverse the elements in a linked list
	 * 
	 * @param head
	 *            The current node in the list being reversed
	 * @param newHead
	 *            The head of the reversed list
	 * @return The head of a LinkedListRec object that contains the same
	 *         contents of this list with the elements reversed.
	 */
	private Node<E> reverse(Node<E> head, Node<E> newHead)
	{
		if (head == null)
		{
			return newHead;
		}
		return reverse(head.next, new Node<E>(head.data, newHead));
	}

	/* </exercise> */

	/* <exercise chapter="5" section="4" type="programming" number="5"> */
	/**
	 * Method to insert an object at a specified index
	 * 
	 * @param obj
	 *            The object to be inserted
	 * @param index
	 *            the index
	 */
	public void insert(E obj, int index)
	{
		if (index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if (index == 0)
		{
			head = new Node<E>(obj, head);
		}
		else
		{
			insert(obj, head, index - 1);
		}
	}

	/**
	 * Method to insert an object at a specified index
	 * 
	 * @param obj
	 *            The object to be inserted
	 * @param pred
	 *            the node preceding the node at the current indes
	 * @param index
	 *            the current index
	 */
	private void insert(E obj, Node<E> pred, int index)
	{
		if (pred == null)
		{
			throw new IndexOutOfBoundsException();
		}
		if (index == 0)
		{
			pred.next = new Node<E>(obj, pred.next);
		}
		else
		{
			insert(obj, pred.next, index - 1);
		}
	}

	/* </exercise> */

	/* <exercise chapter="5" section="4" type="programming" number="6"> */
	/**
	 * Method to remove an item at a specified index
	 * 
	 * @param index
	 *            The index of the item to be removed
	 */
	public void remove(int index)
	{
		if (index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if (head == null)
		{
			throw new IndexOutOfBoundsException();
		}
		if (index == 0)
		{
			head = head.next;
		}
		else
		{
			remove(head, index - 1);
		}
	}

	/**
	 * Method to remove an item at a specified index
	 * 
	 * @param pred
	 *            the node before the item at the current indes
	 * @param index
	 *            the current index
	 */
	private void remove(Node<E> pred, int index)
	{
		if (pred == null)
		{
			throw new IndexOutOfBoundsException();
		}
		if (pred.next == null)
		{
			throw new IndexOutOfBoundsException();
		}
		if (index == 0)
		{
			pred.next = pred.next.next;
		}
		else
		{
			remove(pred.next, index - 1);
		}
	}
	/* </exercise> */
}
/* </listing> */
