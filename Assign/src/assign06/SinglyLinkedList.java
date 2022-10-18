package assign06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import assign03.ArrayCollection;

public class SinglyLinkedList implements List<Object> {
	
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
	
	void add(Object data)
    {
 
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
	}

	@Override
	public void insert(int index, Object element) throws IndexOutOfBoundsException {

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
	}

	@Override
	public Object delete(int index) throws IndexOutOfBoundsException {
	}

	@Override
	public int indexOf(Object element) {
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
	}

	@Override
	public void clear() {
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Object> iterator() {
		return null;
	}

}