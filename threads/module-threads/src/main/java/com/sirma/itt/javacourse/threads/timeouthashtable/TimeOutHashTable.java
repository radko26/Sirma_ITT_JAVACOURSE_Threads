package com.sirma.itt.javacourse.threads.timeouthashtable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Hash table that deletes elements if they have not been used since specific
 * period of time.Backed up with thread that deletes and priority queue that
 * simulates the lifespan of each element.
 * 
 * @author radoslav
 * 
 */
public class TimeOutHashTable {

	private volatile Map<String, Object> table = new HashMap<String, Object>();
	private volatile Map<String, Pair<String, Long>> pairTable = new HashMap<String, Pair<String, Long>>();

	/*
	 * Priority queue that is thread safe and contains a {@link Pair} that
	 * contains the key of the element and the expiration time.Sorts them by the
	 * most recent expiration time.
	 */

	private PriorityBlockingQueue<Pair<String, Long>> queue = new PriorityBlockingQueue<Pair<String, Long>>(
			10, new Comparator<Pair<String, Long>>() {
				public int compare(Pair<String, Long> pair1,
						Pair<String, Long> pair2) {
					return pair1.getSecond().compareTo(pair2.getSecond());
				}
			});

	private RemoveThread removeThread = new RemoveThread(queue, this);
	private long time;
	private boolean isItStarted = false;

	/**
	 * Initialises the expiration time.
	 * 
	 * @param time
	 *            The time in milliseconds.
	 * 
	 */
	public TimeOutHashTable(long time) throws InterruptedException {
		this.time = time;
	}

	/**
	 * Gets the value with the use of specific key and update it with the new
	 * expiry time of the element.
	 * 
	 * @param key
	 *            The key.
	 * @return Returns the elements if there is such key in the table, otherwise
	 *         it returns null.
	 * 
	 */
	public Object get(String key) {
		if (table.containsKey(key)) {
			update(key);
			return table.get(key);
		}
		return null;

	}

	/**
	 * Updates the priority queue which is backed up by map that contains the
	 * pair.
	 * 
	 * @param key
	 *            The key which is for update.
	 */
	private synchronized void update(String key) {

		long currentTime = System.currentTimeMillis(); // current time
		long newTime = time + currentTime; // predicting the new time.

		Pair<String, Long> oldRoot = queue.peek();

		pairTable.get(key).setSecond(newTime);
		pairTable.replace(key, pairTable.get(key));

		queue.remove(pairTable.get(key));
		queue.add(pairTable.get(key));

		Pair<String, Long> newRoot = queue.peek();

		if (oldRoot != newRoot) {// if the root has been used

			long timeNew = queue.peek().getSecond();
			removeThread.interrupt();// interrupt the sleep of the thread and
										// set a new sleep time.
			removeThread.setSleepTime(timeNew - System.currentTimeMillis()
					+ 100);
		}
	}

	/**
	 * Add new query to the table or update it if the key has alredy been there.
	 * 
	 * @param key
	 *            Its key.
	 * @param value
	 *            Its value.
	 */
	public void put(String key, Object value) {

		if (table.containsKey(key)) {
			table.replace(key, value);

			update(key);

		} else {
			table.put(key, value);
			pairTable.put(key,
					new Pair<String, Long>(key, System.currentTimeMillis()
							+ time));
			queue.add(pairTable.get(key));
		}
		if (isItStarted != true) {
			removeThread.start();
			removeThread.setSleep(true);

			removeThread.setSleepTime(queue.peek().getSecond()
					- System.currentTimeMillis());

		}
		isItStarted = true;

	}

	/**
	 * Removes query from the map.
	 * 
	 * @param key
	 *            The key of the query.
	 */
	public void remove(String key) {
		table.remove(key);
		pairTable.remove(key);
	}

	/**
	 * Gets the table.
	 * 
	 * @return Returns the table.
	 */
	public Map<String, Object> getTable() {
		return table;
	}

}
