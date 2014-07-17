package com.sirma.itt.javacourse.threads.warehouse;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test class for {@link Warehouse}.
 * 
 * @author radoslav
 */
public class WarehouseTest {

	/**
	 * Produces and then consumes.
	 */
	@Test
	public void testAddAndGet() {

		Warehouse<Object> warehouse = new Warehouse<Object>(10);
		Object item = new Object();
		final Producer<Object> producer1 = new Producer<Object>(warehouse, item);
		final Producer<Object> producer2 = new Producer<Object>(warehouse, item);
		final Customer<Object> customer1 = new Customer<Object>(warehouse, item);

		Thread test = new Thread(new Runnable() {
			public void run() {
				try {
					producer1.start();
					producer2.start();
					customer1.start();

					producer1.join();
					producer2.join();
					customer1.join();
				} catch (InterruptedException e) {
					fail();
				}
			}
		});

		test.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
	}
}
