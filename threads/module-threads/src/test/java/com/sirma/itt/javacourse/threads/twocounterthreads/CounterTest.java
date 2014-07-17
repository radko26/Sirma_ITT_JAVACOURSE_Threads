package com.sirma.itt.javacourse.threads.twocounterthreads;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;

/**
 * Test class for {@link CounterTest}.
 * 
 * @author radoslav
 */
public class CounterTest {

	@Test
	public void test() throws InterruptedException {

		AtomicBoolean running = new AtomicBoolean(true);
		Counter counter1 = new Counter(10000, 100000, "Counter1", running);
		Counter counter2 = new Counter(1, 20000, "Counter2", running);

		counter1.join();
		counter2.join();
	}

}
