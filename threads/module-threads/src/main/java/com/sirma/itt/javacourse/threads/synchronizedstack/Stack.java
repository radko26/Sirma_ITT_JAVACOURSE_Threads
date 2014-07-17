package com.sirma.itt.javacourse.threads.synchronizedstack;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A stack implementation - last in, first out.
 * 
 * @author radoslav
 */
public class Stack {
	private static final Logger LOG = LoggerFactory.getLogger(Stack.class);
	private Object[] stack;
	private AtomicInteger lastIndex;

	public Stack(Object[] array) {
		stack = array;
		lastIndex = new AtomicInteger(-1);
	}

	/**
	 * Removes the last added element.
	 * 
	 */
	public synchronized void remove() {
		if (lastIndex.get() >= 0) {
			LOG.info("removed " + stack[lastIndex.get()]);
			stack[lastIndex.getAndDecrement()] = null;
			notify();
		} else {
			while (!(lastIndex.get() >= 0)) {
				try {
					LOG.info("Nothing to remove waiting");
					wait();
				} catch (InterruptedException e) {

				}
			}
		}
	}

	/**
	 * Adds a new element at the end.
	 * 
	 * @param object
	 *            object to be inserted
	 */

	public synchronized void add(Object object) {

		while (lastIndex.get() >= stack.length) {
			LOG.info("Full");
			try {
				LOG.info("Waiting for space");
				wait();
			} catch (InterruptedException e) {

			}
		}
		notify();
		LOG.info("added " + object + " from  "
				+ Thread.currentThread().getName());
		stack[lastIndex.incrementAndGet()] = object;
	}

}
