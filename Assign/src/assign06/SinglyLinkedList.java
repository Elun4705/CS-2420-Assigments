package assign06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import assign03.ArrayCollection;

public class SinglyLinkedList implements List<Object>, Iterable<Object> {

	private Node head = null;
	private int size = 0;

	private class Node {
		Object element;
		Node next;

		Node prev;

		Node(Object data) {
			element = data;
			next = null;
			prev = null;
		}

	}

	public SinglyLinkedList() {

	}

	public static void main(String[] args) {
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");

		test.indexOf("word");
		System.out.println(test.isEmpty());
		
		System.out.println();
		Object[] list = test.toArray();
		System.out.println(Arrays.toString(list));
		
		test.clear();
		System.out.println(test.isEmpty());

	}

	void add(Object data) {

		// Creating new node with given value
		Node temp = new Node(data);

		// Checking if list is empty
		// and assigning new value to head node
		if (this.head == null) {
			head = temp;
		}

		// If list already exists
		else {

			// Temporary node for traversal
			Node X = head;

			// Iterating till end of the List
			while (X.next != null) {
				X = X.next;
			}

			// Adding new valued node at the end of the list
			X.next = temp;
		}

		// Increasing length after adding new node
		size++;
	}

	@Override
	public void insertFirst(Object element) {

		Node temp = new Node(element);

		temp.next = head;

		head = temp;

		size++;

	}

	@Override
	public void insert(int index, Object element) throws IndexOutOfBoundsException {

		if (index > size) {
			throw new IndexOutOfBoundsException();
		}

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

	@Override
	public Object getFirst() throws NoSuchElementException {
		return head.element;
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.element;
	}

	@Override
	public Object deleteFirst() throws NoSuchElementException {
		
		Node oldHead = head;
		Node newHead = head.next;
		
		head = newHead;

		size--;
		
		return oldHead.element;
	}

	@Override
	public Object delete(int index) throws IndexOutOfBoundsException {
		Node temp = head;
		for (int i = 0; i < index-1; i++) {
			temp = temp.next;
		}
		
		Node delt = temp.next;
		temp.next = temp.next.next;

		size--;
		
		return delt;
	}

	@Override
	public int indexOf(Object element) {
		
		Node temp = head;
		
		for(int index = 0; index < size-1; index++) {
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
	public Iterator<Object> iterator() {
		Iterator<Object> it = new listIterator();
		return it;
	}

	private class listIterator implements Iterator<Object> {
		boolean removeable = false;
		int index = 0;

		public boolean hasNext() {
			if (index < size) {
				return true;
			}
			return false;
		}

		public Object next() throws NoSuchElementException {
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