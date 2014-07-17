package com.sirma.itt.javacourse.threads.timeouthashtable;

/**
 * Object that holds two more objects.
 * 
 * @param <F>
 *            The type of the first object.
 * @param <S>
 *            The type of the second object.
 * @author radoslav
 */
public class Pair<F, S> {

	private F first;
	private S second;

	/**
	 * Initialises the objects.
	 * 
	 * @param first
	 *            The first one.
	 * @param second
	 *            The second one.
	 */
	public Pair(F first, S second) {
		this.first = first;
		this.second = second;
	}

	/**
	 * Gets the first object.
	 * 
	 * @return The first object.
	 */
	public F getFirst() {
		return first;
	}

	/**
	 * Gets the second object.
	 * 
	 * @return The second object.
	 */
	public S getSecond() {
		return second;
	}

	/**
	 * Sets the first object.
	 * 
	 * @param first
	 *            The first object.
	 */
	public void setFirst(F first) {
		this.first = first;
	}

	/**
	 * Sets the first object.
	 * 
	 * @param second
	 *            The first object.
	 */
	public void setSecond(S second) {
		this.second = second;
	}

}
