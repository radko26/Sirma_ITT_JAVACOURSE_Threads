package com.sirma.itt.javacourse.threads.warehouse;

/**
 * Uses the produced products stored in the warehouse.
 * 
 * @param <T>
 *            The type of the products.
 * @author radoslav
 */
public class Customer<T> extends Thread {

	private Warehouse<T> store;
	private T stock;

	/**
	 * Initialises the store and the type of stock.
	 * 
	 * @param store
	 *            The store instance.
	 * @param stock
	 *            The Stock.
	 */
	public Customer(Warehouse<T> store, T stock) {
		this.store = store;
		this.stock = stock;
	}

	/**
	 * Buys products every 2 seconds. {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			while (true) {
				store.get(stock);
				sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
