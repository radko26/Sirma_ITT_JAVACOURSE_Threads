package com.sirma.itt.javacourse.threads.synchronizedthreads;

public class CounterLock {

	private Object lock = new Object();
	private boolean finished = false;

	/**
	 * Gets the lock object.
	 * 
	 * @return The object used as lock.
	 */
	public Object getLock() {
		return lock;
	}

	/**
	 * Checks if the counting has finished.
	 * 
	 * @return True if the counting has finished.
	 */
	public synchronized boolean isFinnishedCounting() {
		return finished;
	}

	/**
	 * Ends the counting.
	 * 
	 * @param finnished
	 *            The status.
	 */
	public synchronized void setFinnished(boolean finnished) {
		this.finished = finnished;
	}

}
