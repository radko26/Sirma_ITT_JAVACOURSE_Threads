package com.sirma.itt.javacourse.threads.warehouse;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Stores the produced productions.
 * 
 * @param <T>
 *            The type of the products stored in the warehouse
 * @author radoslav.
 */
public class Warehouse<T> {

	private static final Logger LOG = LoggerFactory.getLogger(Warehouse.class);
	private Vector<T> store = new Vector<T>();
	private int capacity;

	/**
	 * Initialises the capacity.
	 * 
	 * @param capacity
	 *            The capacity.
	 */
	public Warehouse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Adds element to the warehouse.
	 * 
	 * @param object
	 *            The element
	 * @throws InterruptedException
	 *             If the working thread has been interrupted.
	 */
	public synchronized void add(T object) throws InterruptedException {
		while (store.size() == capacity) {
			LOG.info("No more space");
			wait();
		}
		store.add(object);
		LOG.info("Added product" + store.size());
		notify();
	}

	/**
	 * Removes element from the warehouse.
	 * 
	 * @throws InterruptedException
	 *             If the working thread has been interrupted.
	 */
	public synchronized void get(T stock) throws InterruptedException {
		while (store.isEmpty()) {
			LOG.info("No products available");
			wait();
		}
		store.remove(stock);
		LOG.info("Product bought" + store.size());
		notify();
	}

}
