package com.sirma.itt.javacourse.threads.stopcounter;

/**
 * Counts to specific number.
 * 
 * @author radoslav
 */
public class Counter extends Thread {

	private long limit;
	private long counter;
	private static boolean running;

	/**
	 * Initialises the limit.
	 * 
	 * @param limit
	 *            The limit .
	 */
	public Counter(long limit) {
		this.limit = limit;
	}

	/**
	 * Gets the number which the thread has reached.
	 * 
	 * @return The number.
	 */
	public long getCounter() {
		return counter;
	}

	/**
	 * Stops the thread by changing the running status.
	 */
	public void stopExecuting() {
		running = false;
	}

	@Override
	public void run() {
		running = true;
		while (running) {
			for (counter = 0; counter < limit; counter++)
				;
			break;
		}
	}

}
