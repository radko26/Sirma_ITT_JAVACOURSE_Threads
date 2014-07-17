package com.sirma.itt.javacourse.threads.timeouthashtable;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Thread that sleeps until given period of time and when it wakes up remove the
 * unused queries.
 * 
 * @author radoslav
 */
public class RemoveThread extends Thread {
	private TimeOutHashTable table;
	private PriorityBlockingQueue<Pair<String, Long>> queue;

	private boolean sleep = true;
	private long sleepTime = 0;

	/**
	 * Initialises the table and the waiting queue.
	 * 
	 * @param queue
	 *            The queue.
	 * @param table
	 *            The table.
	 */
	public RemoveThread(PriorityBlockingQueue<Pair<String, Long>> queue,
			TimeOutHashTable table) {
		this.queue = queue;
		this.table = table;
	}

	@Override
	public void run() {
		while (!queue.isEmpty()) {
			if (sleep) {
				try {
					sleep(sleepTime + 100);
					sleep = false;
				} catch (InterruptedException e) {
					// if the root has been updated a new sleep time should be
					// executed.
					try {
						sleep(sleepTime + 100);
						sleep = false;// start doing your job.
					} catch (InterruptedException e1) {

					}
				}
			} else {
				Pair<String, Long> root = queue.poll();// removes the p.q root
				table.remove(root.getFirst());
				setSleep(true);// ready go to sleep again.
				if (queue.peek() != null) {
					// if there still used elements sleep until the root expire
					// time.
					setSleepTime(queue.peek().getSecond()
							- System.currentTimeMillis() + 100);
				} else {
					return;
				}

			}

		}
	}

	/**
	 * Sets if the thread needs to sleep.
	 * 
	 * @param sleep
	 */
	public synchronized void setSleep(boolean sleep) {
		this.sleep = sleep;
	}

	/**
	 * Sets the time that the thread needs to sleep.
	 * 
	 * @param sleep
	 *            The time in milliseconds.
	 */
	public synchronized void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}

}
