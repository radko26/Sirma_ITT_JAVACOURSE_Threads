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
	 */
	@Test
	public void testGetCounterWithSmallLimit() {
		counter = new Counter(100000l);
		counter.start();
		for (long i = 0; i < (long) (Math.random() * 1000000l) + 100000000l; i++)
			;
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
		for (long i = 0; i < (long) (Math.random() * 1000000l) + 100000000l; i++)
			;
		counter.stopExecuting();
		assertTrue(counter.getCounter() < 100000000000l);
	}

}
