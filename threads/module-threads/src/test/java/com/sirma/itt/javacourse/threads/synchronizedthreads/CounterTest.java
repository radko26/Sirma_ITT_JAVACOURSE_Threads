package com.sirma.itt.javacourse.threads.synchronizedthreads;

import org.junit.Test;

/**
 * Test class for {@link Counter}.
 * 
 * @author radoslav
 */
public class CounterTest {

	/**
	 * Checks if the threads are waiting each other.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testCount() throws InterruptedException {
		CounterLock lock = new CounterLock();
		Counter counterA = new Counter(0, 10, lock);
		Counter counterB = new Counter(0, 5, lock);

		counterA.start();
		counterB.start();

		counterA.join();
		counterB.join();

	}

}
