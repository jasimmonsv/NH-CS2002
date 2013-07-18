import static org.junit.Assert.*;
import kwch04.KWQueue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author jasimmonsv
 *
 */
public class TestKWQueue {
	private KWQueue<String> testing1 = new KWQueue<String>();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testing1.add("Customer1");
		testing1.add("Customer2");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void queueAdd() {
		assertTrue(testing1.poll()=="Customer1");
		assertTrue(testing1.poll()=="Customer2");
	}
	
	@Test
	public void queueRemove() {
		//System.out.println(testing1.remove());
		assertTrue(testing1.remove() == "Customer1" && testing1.size()==1);
		
	}
	
	@Test
	public void queueElement() {
		assertTrue(testing1.element()=="Customer1");
		assertTrue(testing1.element()=="Customer1");
	}
	
	@Test
	public void queueSize() {
		assertTrue(testing1.size()==2);
		testing1.add("Customer7");
		assertTrue(testing1.size()==3);
	}
	
	@Test
	public void queueIsEmpty() {
		testing1.clear();
		assertTrue(testing1.peek()==null);
	}

}
