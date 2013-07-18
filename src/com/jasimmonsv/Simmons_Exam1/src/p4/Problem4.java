package p4;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Problem 4 on Take-Home Exam 1
 * CSCI 2002-91, Spring 2012
 * 
 * Add additional test methods to this JUnit 
 *   Test Case for CircularList, as described in the Exam 1 handout.
 *   
 * @author eric
 *
 */

public class Problem4
{
	
	@Test
	public void test()
	{		
		fail("Not yet implemented");
	}
	
	@Test
	public void testSize()
	{
		int[] data = {0,1,2};
		CircularList<Integer> tempList = new CircularList<Integer>();
		
		for (int i = 0; i < data.length; i++)
		{
			tempList.addAfterCurrent(data[i]);
			assertTrue(tempList.size()==i+1);
		}//end for loop
	}//end testCurrentNode
	
	//*********************Circular List Tests****************************
	@Test
	public void testGetCurrent()
	{
		int[] data = {0};
		CircularList<Integer> tempList = new CircularList<Integer>();
		tempList.addAfterCurrent(data[0]);
		assertTrue(tempList.getCurrent()==data[0]);
	
	}//end 
	
	@Test
	public void testGetCurrentNode()
	{
		int[] data = {0,1,2};
		CircularList<Integer> tempList = new CircularList<Integer>();
		
		for (int i = 0; i < data.length; i++)
		{
			tempList.addAfterCurrent(data[i]);
			tempList.advanceCurrent();
		}//end for loop
		tempList.advanceCurrent();
		
		//** ASSERT
		assertTrue(tempList.getCurrentNode().data==0); //check that data is 0
		tempList.removeCurrent(); //remove 0
		assertTrue(tempList.getCurrentNode().data==1); //check that data is now 1
	}//end 	
	
	@Test
	public void testAdvanceCurrent()
	{
		int[] data = {0,1,2};
		CircularList<Integer> tempList = new CircularList<Integer>();
		
		for (int i = 0; i < data.length; i++)
		{
			tempList.addAfterCurrent(data[i]);
			tempList.advanceCurrent();
		}//end for loop
		tempList.advanceCurrent();
		
		//** ASSERT
		assertTrue(tempList.getCurrentNode().data==0); //check that data is 0
		tempList.removeCurrent(); //remove 0
		assertTrue(tempList.getCurrentNode().data==1); //check that data is now 1
	}//end testCurrentNode
	
	@Test
	public void testBuildCircularListAddAfter()
	{
		int[] data = {0,1,2};
		CircularList<Integer> tempList = new CircularList<Integer>();
		
		for (int i = 0; i < data.length; i++)
		{
			tempList.addAfterCurrent(data[i]);
		}//end for loop
		//**Assert
		for (int i=0;i<tempList.size();i++){
			assertTrue(tempList.getCurrentNode().data==i); //cycle through the list checking the numbers
			tempList.advanceCurrent();
		}//end for
	}
	
	/**
	 * This test will error due to bug in addBefore code as documented
	 */
	@Test
	public void testBuildCircularListAddBefore()
	{
		int[] data = {0,1,2};
		CircularList<Integer> tempList = new CircularList<Integer>();
		
		for (int i = 0; i < data.length; i++)
		{
			tempList.addBeforeCurrent(data[i]);
			tempList.advanceCurrent();
		}//end for loop
		tempList.advanceCurrent();
		//**Assert
		for (int i=0;i<tempList.size();i++){
			assertTrue(tempList.getCurrentNode().data==i); //cycle through the list checking the numbers
			tempList.advanceCurrent();
		}
		
	}
	
	@Test
	public void testRemoveCurrent()
	{
		int[] data = {0,1,2};
		CircularList<Integer> tempList = new CircularList<Integer>();
		
		for (int i = 0; i < data.length; i++)
		{
			tempList.addAfterCurrent(data[i]);
			tempList.advanceCurrent();
		}//end for loop
		tempList.advanceCurrent();
		
		//** ASSERT
		assertTrue(tempList.getCurrentNode().data==0); //check that data is 0
		tempList.removeCurrent(); //remove 0
		assertTrue(tempList.getCurrentNode().data==1); //check that data is now 1
	}//end testCurrentNode
	
	
	
	
	
	//***********Circular List Iterator Tests**********************
	
	@Test
	public void testRemove()
	{
		CircularListIterator<Integer> list = setupData();
		int before = list.next();
		list.remove();
		assertTrue(before != list.next());
		
	}//end method testRemove

	@Test
	public void testHasNext()
	{
		CircularListIterator<Integer> list = setupData();
		
		assertEquals(true,list.hasNext());
	}//end testCurrentNode
	
	@Test
	public void testNext()
	{
		CircularListIterator<Integer> list = setupData();
		
		assertTrue (list.next() != null);
	}//end method testNext
	
	
	//**
	//** @author J.A. Simmons V
	//**
	private CircularListIterator<Integer> setupData(){
		int[] data = {0,1,2,3,4,5,6,7,8,9};
		CircularList<Integer> tempList = new CircularList<Integer>();
		
		for (int i = 0; i < 10; i++)
		{
			tempList.addAfterCurrent(data[i]);
			tempList.advanceCurrent();
		}//end for loop
		tempList.advanceCurrent();
		return new CircularListIterator<Integer>(tempList);
		
	}//end method setupData
}
