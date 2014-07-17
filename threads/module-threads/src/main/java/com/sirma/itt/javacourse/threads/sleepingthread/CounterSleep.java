package com.sirma.itt.javacourse.threads.sleepingthread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Counts to a number.
 * 
 * @author radoslav
 */
public class CounterSleep extends Thread {
	private static final Logger LOG = LoggerFactory
			.getLogger(CounterSleep.class);
	private int upperBound;
	private boolean running;
	private int lowerBound;

	/**
	 * Initialises the range.
	 * 
	 * @param lowerBound
	 *            The start number.
	 * @param upperBound
	 *            The end number.
	 * 
	 */
	public CounterSleep(int lowerBound, int upperBound) {
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
	}

	/**
	 * Stops the thread.
	 */
	public void stopExecution() {
		running = false;
	}

	@Override
	public void run() {
		running = true;
		int counter = lowerBound;
		while (running) {
			LOG.info(counter++ + "");
			if (counter == upperBound + 1) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}

}
