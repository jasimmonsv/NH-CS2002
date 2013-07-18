package p1;

import java.util.EmptyStackException;

/**
 * Complete the implementation of this so that it implements the provided
 *   Stack interface
 *   
 * @author eric
 * @param <E>
 *
 */
public class StackImpl implements Stack
{
	//****Declerations****
	private int[] data; //Data within stack
	int topOfStack = -1; //initial stack counter
	private static final int INITIAL_CAPACITY = 10;
	
	public StackImpl()
	{
		data = new int[INITIAL_CAPACITY];
	}//end constructor
	
	
	/**
	 * 
	 * @param obj object to add to stack
	 * @return the object for further processing
	 */
	public void push (int value){
		if (topOfStack == data.length -1){
			reallocate();
		}//end if
		topOfStack++;
		data[topOfStack] = value;
		
	}//end method push
	
	public int pop ()
	{
		if (isEmpty()){
			throw new EmptyStackException();
		}//end if
		return data[topOfStack--];
	}//end method pop
	
	public boolean isEmpty()
	{
		return (topOfStack == -1);
	}//end method isEmpty
	
	private void reallocate(){
		int[] tempData = new int[data.length];
		for (int i = 0;i<data.length;i++){
			tempData[i]=data[i];
		}//end for
		data = new int[data.length+5];
		for (int i = 0;i<tempData.length;i++){
			data[i]=tempData[i];
		}//end for
	}//end method reallocate
	
}
