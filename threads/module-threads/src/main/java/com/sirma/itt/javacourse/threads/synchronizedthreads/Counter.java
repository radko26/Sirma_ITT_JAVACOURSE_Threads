package com.sirma.itt.javacourse.threads.synchronizedthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thread that counts in a range.After each step it notifies the others waiting
 * on the lock that it is waiting and they can move on.
 * 
 * @author radoslav
 */
public class Counter extends Thread {
	private static final Logger LOG = LoggerFactory.getLogger(Counter.class);
	private int upperBound;
	private int lowerBound;
	private CounterLock lock;

	/**
	 * Initialises the range.
	 * 
	 * @param upperBound
	 *            The max value.
	 * @param lowerBound
	 *            The min value.
	 */
	public Counter(int lowerBound, int upperBound, CounterLock lock) {
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
		this.lock = lock;
	}

	@Override
	public void run() {
		while (!lock.isFinnishedCounting() && (lowerBound <= upperBound)) {
			LOG.info(this.getName() + " : " + lowerBound);
			lowerBound += 1;

			synchronized (lock.getLock()) {
				lock.getLock().notifyAll();
				try {
					lock.getLock().wait();
				} catch (InterruptedException e) {

				}
			}
		}
		synchronized (lock.getLock()) {
			lock.setFinnished(true);
			lock.getLock().notifyAll();
		}

	}

}
