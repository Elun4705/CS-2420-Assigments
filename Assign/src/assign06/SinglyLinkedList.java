package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E>, Iterable<E> {

	private Node head = null;
	private int size = 0;

	private class Node {
		E element;
		Node next;

		Node prev;

		Node(E data) {
			element = data;
			next = null;
			prev = null;
		}

	}

	public SinglyLinkedList() {

	}

	/**
	 * Add's a new data 
	 * 
	 * @param data
	 */
	void add(E data) {

		// Creating new node with given value
		Node temp = new Node(data);

		// Check if list is empty, if so, make the new node the head
		if (this.head == null) {
			head = temp;
		}

		else {

			// Set head to travel node
			Node travel = head;

			// Travel to end of list
			while (travel.next != null) {
				travel = travel.next;
			}

			// Adding new node to the end of the list
			travel.next = temp;
		}

		// Increase size
		size++;
	}

	/**
	 * 
	 */
	@Override
	public void insertFirst(E element) {

		Node temp = new Node(element);

		temp.next = head;

		head = temp;

		size++;

	}

	@Override
	public void insert(int index, E element) throws IndexOutOfBoundsException {

		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		if ( index == 0) {
			insertFirst(element);
		}
		
		
		else {
			
			if (index == size)
				add(element);
			
			else {
				
				Node insert = new Node(element);
				Node temp = head;

				for (int i = 0; i < index - 1; i++) {
					temp = temp.next;
				}

				Node after = temp.next;

				temp.next = insert;

				insert.next = after;

				size++;
			}
				
		}

	}

	@Override
	public E getFirst() throws NoSuchElementException {
		
		if(head == null) {
			throw new NoSuchElementException();
		}
		
		return head.element;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.element;
	}

	@Override
	public E deleteFirst() throws NoSuchElementException {
		
		if(head == null) {
			throw new NoSuchElementException();
		}
		
		Node oldHead = head;
		Node newHead = head.next;
		
		head = newHead;

		size--;
		
		return oldHead.element;
	}

	@Override
	public E delete(int index) throws IndexOutOfBoundsException {
		
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		 
		if (index == 0) {
			return deleteFirst();
		}
		
		Node temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		
		Node delt = temp.next;
		temp.next = temp.next.next;

		size--;
		
		return delt.element;
	}

	@Override
	public int indexOf(Object element) {
		
		Node temp = head;
		
		for(int index = 0; index < size; index++) {
			if(temp.element == element) {
				return index;
			}
			
			temp = temp.next;
		}
		
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(head == null)
			return true;
		
		return false;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public Object[] toArray() {
		
		Node value = head;
		Object temp[] = new Object[size];
		
		for(int index = 0; index < size; index++) {
			temp[index] = value.element;
			value = value.next;
		}
		return temp;
	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> it = new listIterator();
		return it;
	}

	private class listIterator implements Iterator<E> {
		boolean removeable = false;
		int index = 0;

		public boolean hasNext() {
			if (index < size) {
				return true;
			}
			return false;
		}

		public E next() throws NoSuchElementException {
			if (this.hasNext()) {
				removeable = true;
				return get(index++);
			} else {
				throw new NoSuchElementException();
			}
		}

		public void remove() throws IllegalStateException {
			if (removeable) {
				delete(index);
				removeable = false;
			} else {
				throw new IllegalStateException();
			}
		}

	}

}