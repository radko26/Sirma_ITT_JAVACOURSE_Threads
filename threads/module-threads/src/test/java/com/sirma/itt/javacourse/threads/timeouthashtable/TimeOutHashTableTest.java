package com.sirma.itt.javacourse.threads.timeouthashtable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for {@link TimeOutHashTable}.
 * 
 * @author radoslav
 */
public class TimeOutHashTableTest {

	/**
	 * Puts only one element and simulates time passing.
	 * 
	 * @throws InterruptedException
	 *             If the thread has been interrupted.
	 */

	@Test
	public void testOne() throws InterruptedException {
		TimeOutHashTable table = new TimeOutHashTable(1000);

		table.put("1", new Object());
		Thread.sleep(1105);
		assertEquals(true, table.getTable().isEmpty());
	}

	/**
	 * Inserts two and simulates.
	 * 
	 * @throws InterruptedException
	 *             If the tread has been interrupted
	 */
	@Test
	public void testWithTwo() throws InterruptedException {
		TimeOutHashTable table = new TimeOutHashTable(1000);

		table.put("1", new Object());
		Thread.sleep(100);
		table.put("2", new Object());
		Thread.sleep(1005);
		assertEquals(1, table.getTable().size());

	}

	/**
	 * Inserts 3 and simulates.
	 * 
	 * @throws InterruptedException
	 *             If the thread has been interrupted
	 */
	@Test
	public void testWithThree() throws InterruptedException {
		TimeOutHashTable table = new TimeOutHashTable(1000);

		table.put("1", new Object());
		Thread.sleep(100);
		table.put("2", new Object());
		Thread.sleep(100);
		table.put("3", new Object());
		Thread.sleep(1110);
		assertEquals(1, table.getTable().size());
	}

	/**
	 * Inserts 4 quarries and simulates the waiting time.
	 * 
	 * @throws InterruptedException
	 *             If the thread has been interrupted
	 */
	@Test
	public void testWithFour() throws InterruptedException {
		TimeOutHashTable table = new TimeOutHashTable(1000);

		table.put("1", new Object());
		Thread.sleep(100);
		table.put("2", new Object());
		Thread.sleep(100);
		table.put("3", new Object());
		Thread.sleep(200);
		table.put("4", new Object());

		table.get("1");
		table.get("2");
		table.get("4");

		Thread.sleep(1100);
		assertEquals(3, table.getTable().size());
	}

}
