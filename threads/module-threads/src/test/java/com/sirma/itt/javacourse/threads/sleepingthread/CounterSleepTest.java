package com.sirma.itt.javacourse.threads.sleepingthread;

import org.junit.Test;

/**
 * Test class for {@link CounterSleep} and {@link CounterWait}.
 * 
 * @author radoslav
 */
public class CounterSleepTest {
	/**
	 * Creates two counters using sleep for pause.
	 * 
	 * @throws InterruptedException
	 *             If a thread has been interrupted.
	 */
	@Test
	public void testSleep() throws InterruptedException {

		CounterSleep cs1 = new CounterSleep(1, 5);
		CounterSleep cs2 = new CounterSleep(1, 5);

		cs1.start();
		cs2.start();

		cs1.join();
		cs2.join();

	}

	/**
	 * Creates two counters using wait for pause.
	 * 
	 * @throws InterruptedException
	 *             If a thread has been interrupted.
	 */
	@Test
	public void testWait() throws InterruptedException {
		CounterWait cw1 = new CounterWait(1, 5);
		CounterWait cw2 = new CounterWait(1, 5);

		cw1.start();
		cw2.start();

		cw1.join();
		cw2.join();
	}

}
