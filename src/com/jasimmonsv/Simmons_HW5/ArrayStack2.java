/*<listing chapter="3" section="3">*/
package com.jasimmonsv.Simmons_HW5;

import java.util.EmptyStackException;

/** Implementation of the interface StackInt<E> using
 *  an array.
 *  @author Koffman & Wolfgang
 */
public class ArrayStack2<E> implements StackInt<E> {

    // Data Fields
    /** Storage for stack. */
    E[] theData;
    /** Index to top of stack. */
    int topOfStack = -1; // Initially empty stack.
    private static final int INITIAL_CAPACITY = 10;

    /**
     * Construct an empty stack with the default
     * initial capacity.
     */
    public ArrayStack2() {
        theData = (E[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Insert a new item on top of the stack.
     * @post The new item is the top item on the stack.
     *       All other items are one position lower.
     * @param obj The item to be inserted
     * @return The item that was inserted
     */
    @Override
    public E push(E obj) {
        if (topOfStack == theData.length - 1) {
            reallocate();
        }
        topOfStack++;
        theData[topOfStack] = obj;
        return obj;
    }

    /**
     * Remove and return the top item on the stack.
     * @pre The stack is not empty.
     * @post The top item on the stack has been
     *       removed and the stack is one item smaller.
     * @return The top item on the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return theData[topOfStack--];
    }

	@Override
	public E peek() {
		if (empty()) {
            throw new EmptyStackException();
        }
        return theData[topOfStack];
	}

	@Override
	public boolean empty() {
		if (theData[0]==null)return true;
		return false;
	}
	
	public void reallocate(){
		E[] theOldData = theData;
		theData = (E[]) new Object[theOldData.length+10];
		for (int i =0;i<theOldData.length;i++){
			theData[i] = theOldData[i];
		}		
	}//end method reallocate

// Insert solution to programming exercise 2, section 3, chapter 3 here
}
/*</listing>*/
