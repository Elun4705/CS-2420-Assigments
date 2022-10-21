package assign06;

import java.util.NoSuchElementException;

public class LinkedListStack <E> implements Stack<E> {
	
	private SinglyLinkedList<E> backdrop = new SinglyLinkedList<E>();

	
	public LinkedListStack() {

	}

	@Override
	public void clear() {
		backdrop.clear();
		
	}

	@Override
	public boolean isEmpty() {
		return backdrop.isEmpty();
	}

	@Override
	public E peek() throws NoSuchElementException {
		if (backdrop.isEmpty())
			throw new NoSuchElementException();
		
		return backdrop.get(backdrop.size()-1);
	}

	@Override
	public E pop() throws NoSuchElementException {
		if (backdrop.isEmpty())
			throw new NoSuchElementException();
		
		return backdrop.delete(backdrop.size()-1);
	}

	@Override
	public void push(E element) {
		backdrop.add(element);
		
	}

	@Override
	public int size() {
		return backdrop.size();
	}

}
