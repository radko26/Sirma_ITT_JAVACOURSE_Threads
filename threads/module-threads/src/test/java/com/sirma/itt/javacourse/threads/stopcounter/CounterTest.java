package com.sirma.itt.javacourse.threads.stopcounter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for {@link Counter}.
 * 
 * @author radoslav
 */
public class CounterTest {
	private Counter counter;

	/**
	 * Sets the limit of the counter to small number and checks.
	 * @throws InterruptedException 
	 */
	@Test
	public void testGetCounterWithSmallLimit(){
		counter = new Counter(100000l);
		counter.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		counter.stopExecuting();
		assertEquals(100000l, counter.getCounter());
	}

	/**
	 * Sets the limit of the counter to large number that can't be reached and
	 * checks the result.
	 */
	@Test
	public void testGetCounterWithLargeLimit() {
		counter = new Counter(100000000000l);
		counter.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		counter.stopExecuting();
		assertTrue(counter.getCounter() < 100000000000l);
	}

}
