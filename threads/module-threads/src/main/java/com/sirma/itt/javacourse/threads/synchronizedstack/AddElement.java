package com.sirma.itt.javacourse.threads.synchronizedstack;

/**
 * Adds elements to {@link Stack}.
 * 
 * @author radoslav
 */
public class AddElement extends Thread {

	private Stack stack;
	private int numOfElements;

	/**
	 * Initialises variables.
	 * 
	 * @param numOfElements
	 *            The number of added elements.
	 * @param stack
	 *            The stack which they are kept in.
	 */
	public AddElement(int numOfElements, Stack stack) {
		this.numOfElements = numOfElements;
		this.stack = stack;
	}

	/**
	 * Adds elements to the stack.
	 */
	@Override
	public void run() {
		for (int i = 0; i < numOfElements; i++) {
			stack.add(new String(this.getName() + i));
		}
	}

}
