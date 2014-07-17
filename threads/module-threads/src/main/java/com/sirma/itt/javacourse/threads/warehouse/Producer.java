package com.sirma.itt.javacourse.threads.warehouse;

/**
 * Produce products and stores them into the warehouse.
 * 
 * @param <T>
 *            The type of the products.
 * @author radoslav
 */
public class Producer<T> extends Thread {

	private Warehouse<T> store;
	private T stock;

	/**
	 * Initialises the store and the stock.
	 * 
	 * @param store
	 *            The warehouse instance.
	 * @param stock
	 *            The stock.
	 */
	public Producer(Warehouse<T> store, T stock) {
		this.store = store;
		this.stock = stock;
	}

	/**
	 * Produces elements every 500 milliseconds. {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			while (true) {
				store.add(stock);
				sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
