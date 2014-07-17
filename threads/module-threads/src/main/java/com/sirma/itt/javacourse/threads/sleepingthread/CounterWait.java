package com.sirma.itt.javacourse.threads.sleepingthread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Counts numbers in given range.
 * 
 * @author radoslav
 */
public class CounterWait extends Thread {
	private static final Logger LOG = LoggerFactory
			.getLogger(CounterSleep.class);
	private int upperBound;
	private boolean running;
	private int lowerBound;

	/**
	 * Initialises the range
	 * 
	 * @param lowerBound
	 *            The start number
	 * @param upperBound
	 *            The end number.
	 */
	public CounterWait(int lowerBound, int upperBound) {
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
	}

	/**
	 * Stops the thread execution.
	 */
	public void stopExecution() {
		running = false;
	}

	@Override
	public synchronized void run() {
		running = true;
		int counter = lowerBound;
		while (running) {
			LOG.info(counter++ + "");
			if (counter == upperBound + 1) {
				break;
			}
			try {
				wait(500);
			} catch (InterruptedException e) {

			}

		}
	}

}
