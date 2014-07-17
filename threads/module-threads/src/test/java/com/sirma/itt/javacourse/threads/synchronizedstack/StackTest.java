package com.sirma.itt.javacourse.threads.synchronizedstack;

import org.junit.Test;

/**
 * Test class for {@link Stack}.
 * 
 * @author radoslav
 */
public class StackTest {
	private Object[] stackArray;

	/**
	 * Tries to add/remove object from the stack and waits if the specified
	 * thread cannot do its job.
	 * 
	 */
	@Test
	public void testAddAndRemove() {
		stackArray = new Object[10];

		Stack stack = new Stack(stackArray);

		AddElement add = new AddElement(10, stack);
		RemoveElement remove = new RemoveElement(9, stack);
		add.start();
		remove.start();
		try {
			add.join();
			remove.join();
		} catch (InterruptedException e) {

		}

	}

}
