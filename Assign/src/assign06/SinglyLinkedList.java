package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates a generic singly linked list for usage
 * 
 * @author Emmanuel Luna and Andy Huo
 *
 * @param <E>
 */
public class SinglyLinkedList<E> implements List<E>, Iterable<E> {

	private Node head = null;
	private int size = 0;

	/**
	 * Creates a Node class for use in the SinglyLinkedList
	 * 
	 * @author EMoon
	 *
	 */
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

	/**
	 * An empty constructor
	 */
	public SinglyLinkedList() {

	}

	/**
	 * Add's a new data element to
	 * 
	 * @param data
	 */
	void add(E data) {

		Node temp = new Node(data);

		if (this.head == null) {
			head = temp;
		}

		else {

			Node travel = head;

			while (travel.next != null) {
				travel = travel.next;
			}

			travel.next = temp;
		}

		size++;
	}

	/**
	 * Inserts the given element to the beginning of the list
	 * 
	 * @param element the element to be inserted
	 */
	@Override
	public void insertFirst(E element) {

		Node temp = new Node(element);

		temp.next = head;

		head = temp;

		size++;

	}

	/**
	 * Inserts the given element at the indicated position
	 * 
	 * @param the   element to be inserted
	 * @param index the position for the element to be inserted
	 */
	@Override
	public void insert(int index, E element) throws IndexOutOfBoundsException {

		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
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

	/**
	 * Returns the element stored at the beginning of the list
	 * 
	 * @return the element stored at the beginning of the list
	 * @throws NoSuchElementException
	 */
	@Override
	public E getFirst() throws NoSuchElementException {

		if (head == null) {
			throw new NoSuchElementException();
		}

		return head.element;
	}

	/**
	 * Returns the element at an indicated point in the list
	 * 
	 * @return the element stored at the given point in the list
	 * @param index the spot to get the element from
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.element;
	}

	/**
	 * Returns and deletes the element at the beginning of the list
	 * 
	 * @return the element at the beginning of the list
	 * @throws NoSuchElementException
	 */
	@Override
	public E deleteFirst() throws NoSuchElementException {

		if (head == null) {
			throw new NoSuchElementException();
		}

		Node oldHead = head;
		Node newHead = head.next;

		head = newHead;

		size--;

		return oldHead.element;
	}

	/**
	 * Deletes and returns the element at the given index
	 * 
	 * @return the element at the given index
	 * @param the index of where to delete and return the element
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E delete(int index) throws IndexOutOfBoundsException {

		if (index >= size || index < 0) {
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

	/**
	 * Returns the location of the input element
	 * 
	 * @return the location of the given element
	 * @param the element which needs to be located
	 */
	@Override
	public int indexOf(Object element) {

		Node temp = head;

		for (int index = 0; index < size; index++) {
			if (temp.element == element) {
				return index;
			}

			temp = temp.next;
		}

		return -1;
	}

	/**
	 * Returns the number of objects in the list
	 * 
	 * @return the number of objects in the list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns whether or not the list is empty
	 * 
	 * @return whether or not the list is empty
	 */
	@Override
	public boolean isEmpty() {
		if (head == null)
			return true;

		return false;
	}

	/**
	 * Clears the list
	 */
	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	/**
	 * Returns an array of the objects in the list in order
	 * 
	 * @return an array of the objects in the list
	 */
	@Override
	public Object[] toArray() {

		Node value = head;
		Object temp[] = new Object[size];

		for (int index = 0; index < size; index++) {
			temp[index] = value.element;
			value = value.next;
		}
		return temp;
	}

	/**
	 * Creates and returns a custom iterator for the list
	 */
	@Override
	public Iterator<E> iterator() {
		Iterator<E> it = new listIterator();
		return it;
	}

	/**
	 * @author Emmanuel Luna and Andy Huo
	 * 
	 *         Returns an iterator over the list
	 * @return an iterator over the list
	 */
	private class listIterator implements Iterator<E> {
		boolean removeable = false;
		int index = 0;

		/**
		 * Returns true or false depending on if there are any more items in the list
		 * 
		 * @return true or false depending on if there are any more items in the list
		 */
		public boolean hasNext() {
			if (index < size) {
				return true;
			}
			return false;
		}

		/**
		 * Returns the next object in the list
		 * 
		 * @return the next object in the list
		 * @throws NoSuchElementException
		 */
		public E next() throws NoSuchElementException {
			if (this.hasNext()) {
				removeable = true;
				return get(index++);
			} else {
				throw new NoSuchElementException();
			}
		}

		/**
		 * Deletes the next object in the list
		 * 
		 * @throws NoSuchElementException
		 */
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