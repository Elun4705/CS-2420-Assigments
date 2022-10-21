package assign06;

import java.util.NoSuchElementException;

/**
 * A class which creates a Stack built around a singly linked list
 * 
 * @author Emmanuel Luna and Andy Huo
 *
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {

	private SinglyLinkedList<E> backdrop = new SinglyLinkedList<E>();

	/**
	 * Creates a new LinkedListStack for use
	 */
	public LinkedListStack() {

	}

	/**
	 * Clears the list
	 */
	@Override
	public void clear() {
		backdrop.clear();

	}

	/**
	 * Returns if the list is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return backdrop.isEmpty();
	}

	/**
	 * Returns the element stored at the top of the stack
	 * 
	 * @return the element stored at the top of the stack
	 * @throws NoSuchElementException
	 */
	@Override
	public E peek() throws NoSuchElementException {
		if (backdrop.isEmpty())
			throw new NoSuchElementException();

		return backdrop.get(backdrop.size() - 1);
	}

	/**
	 * Removes the element stored at the top of the stack and removes it from the
	 * stack
	 * 
	 * @return the element stored at the top of the stack
	 * @throws NoSuchElementException
	 */
	@Override
	public E pop() throws NoSuchElementException {
		if (backdrop.isEmpty())
			throw new NoSuchElementException();

		return backdrop.delete(backdrop.size() - 1);
	}

	/**
	 * Adds the given element to the top of the stack
	 * 
	 * @param element the element to be pushed
	 */
	@Override
	public void push(E element) {
		backdrop.add(element);

	}

	/**
	 * Returns how many elements are on the stack
	 * 
	 * @return how many elements are on the stack
	 */
	@Override
	public int size() {
		return backdrop.size();
	}

}
