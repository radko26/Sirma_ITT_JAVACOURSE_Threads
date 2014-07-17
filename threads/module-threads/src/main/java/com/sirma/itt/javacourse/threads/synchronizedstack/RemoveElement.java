package com.sirma.itt.javacourse.threads.synchronizedstack;

/**
 * Thread that removes elements from {@link Stack}.
 * 
 * @author radoslav
 */
public class RemoveElement extends Thread {

	private Stack stack;
	private int numOfElements;

	/**
	 * Initialises the stack and the count of the removed elements.
	 * 
	 * @param numOfElements
	 *            The count of the removed elements.
	 * @param stack
	 *            The stack.
	 */
	public RemoveElement(int numOfElements, Stack stack) {
		this.stack = stack;
		this.numOfElements = numOfElements;
	}

	/**
	 * Removes elements.
	 */
	@Override
	public void run() {
		for (int i = 0; i < numOfElements; i++) {
			stack.remove();
		}
	}

}
