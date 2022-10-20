package assign06;

import java.util.NoSuchElementException;

public class LinkedListStack implements Stack<Object> {
	
	private SinglyLinkedList backdrop = new SinglyLinkedList();

	
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
	public Object peek() throws NoSuchElementException {
		if (backdrop.isEmpty())
			throw new NoSuchElementException();
		
		return backdrop.get(backdrop.size()-1);
	}

	@Override
	public Object pop() throws NoSuchElementException {
		if (backdrop.isEmpty())
			throw new NoSuchElementException();
		
		return backdrop.delete(backdrop.size()-1);
	}

	@Override
	public void push(Object element) {
		backdrop.add(element);
		
	}

	@Override
	public int size() {
		return backdrop.size();
	}
	
	public static void main(String[] args) {
		LinkedListStack test = new LinkedListStack();
		test.push("word");
		
		System.out.println(test.pop());
	}

}
