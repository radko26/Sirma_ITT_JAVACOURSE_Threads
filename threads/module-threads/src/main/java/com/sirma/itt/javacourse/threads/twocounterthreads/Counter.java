package com.sirma.itt.javacourse.threads.twocounterthreads;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Traverse all numbers in specified range.
 * 
 * @author radoslav
 */
public class Counter extends Thread {
	private long upperBound;
	private long lowerBound;
	private AtomicBoolean running;

	/**
	 * Initialises the range
	 * 
	 * @param upperBound
	 *            Max value.
	 * @param lowerBound
	 *            Minimum value.
	 */
	public Counter(long lowerBound, long upperBound, String name,
			AtomicBoolean running) {
		super(name);
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
		this.running = running;
		start();
	}

	@Override
	public void run() {
		for (; lowerBound < upperBound && running.get(); lowerBound++)
			;

		running.set(false);

		System.out.println(this.getName() + " " + lowerBound);
	}
}