package com.jasimmonsv.Simmons_HW4;

public class SingleLinkedList<E> {
	/**Reference to list head. */
	private Node<E> head = null;
	public int size;
	
	
	/** find the node at a specified position
	 *  
	 * @param index the position of the node sought
	 * @return The node at index or null if it does not exist
	 */
	public Node<E> getNode(int index){
		Node<E> node = head;
		for (int i = 0; i < index && node !=null; i++) node = node.next;
		return node;
	}//end method getNode
	
	/** Get the data value at index
	 * @param index the position of the element to return
	 * @return the Data at index
	 * @throws IndexOutOfBoundsException if index is out of range
	 * 
	 */
	public E get(int index){
		if (index<0 || index >=size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}//end if
		Node<E> node = getNode(index);
		return node.data;
	}//end method get
	
	
	/** Set the data value at index
	 * @param index The position of the item to change
	 * @param index the position of the item to change
	 * @param newValue the new value
	 * @return the data value priviously at index
	 * @throws IndexOutOfBoundsException if index is out of range
	 */
	public E set(int index, E newValue){
		if(index <0 || index >=size)throw new IndexOutOfBoundsException(Integer.toString(index));
		Node<E> node = getNode(index);
		E result = node.data;
		node.data = newValue;
		return result;
	}//end method set
	
	/**Add an item to the front of the list.
	 * @param item The item to be added
	 */
	public void addFirst(E item){
		head = new Node<E>(item, head);
		size++;
	}//end addFirst method
	
	/**Insert the specified item at index
	 * @param index The position where item is to be inserted
	 * @param item The item to be inserted 
	 * @throws IndexOutOfBoundsException uf ubdex us is out of range
	 */
	public void add(int index, E item){
		if(index < 0 || index > size)throw new IndexOutOfBoundsException(Integer.toString(index));
		if (index == 0){
			addFirst(item);
		}else {
			Node<E> node = getNode(index-1);
			addAfter(node, item);
		}//end ifElse
	}//end method add
	
	/**Append item to the end of the list
	 * 
	 * @param item the item to be appended
	 * @return true (as specified by the Collection interface
	 */
	public boolean add(E item){
		add(this.size,item);
		return true;
	}//end method add
	
	/**Add a specific item after the given node
	 * 
	 * @param node Node that is at current index
	 * @param item item to be added
	 */
	public void addAfter(Node<E> node, E item){
		Node<E> newNode = new Node(item,node.next);
		node.next = newNode;
		size++;
	}//end method addAfter
	
	/**
	 * Remove the node after a given node
	 * @param node the node before the one to be removed
	 * @return The data from the removed node, or null if there is no node to remove
	 */
	public E removeAfter(Node<E> node){
		Node<E> temp = node.next;
		if (temp != null){
			node.next = temp.next;
			size--;
			return temp.data;
		}else{
			return null;
		}
	}//end method removeAfter
	
	public E removeFirst(){
		Node<E> temp = head;
		if(head != null){
			head = head.next;
		}//end if
		
		//return data at hold head or null if list is empty
		if (temp != null){
			size--;
			return temp.data;
		}else{
			return null;
		}//end ifElse
	}//end method removeFirst
	
	private static class Node<E> {
		//Data Fields
		/**The reference to the data. */
		private E data;
		/** the reference to the next node. */
		private Node<E> next;
		
		//Constructors
		/**Creates a new node with a null next field
		 * @param dataItem The data stored
		 */
		private Node(E dataItem){
			data = dataItem;
			next = null;
		}//end node construct
		
		/**Creates a new node that references another node.
		 * @param dataItem The data stored
		 * @param nodeRef The node referenced by new node
		 */
		private Node(E dataItem, Node<E> nodeRef){
			data = dataItem;
			next = nodeRef;
		}//end node construct

	}//end inner class Node
	
	@Override
	public String toString(){
		Node<E> nodeRef = head;
		StringBuilder result = new StringBuilder();
		while (nodeRef != null){
			result.append(nodeRef.data.toString());
			if (nodeRef.next != null){
				result.append (" ==> ");
			}//end if
			nodeRef = nodeRef.next; //Advance down the list
		}//end while
		return result.toString();
		
	}
	
}//end class SingleLinkedList

