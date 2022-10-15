package assign06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import assign03.ArrayCollection;

public class SinglyLinkedList implements List<Object> {

	private ArrayList<Object> arg = new ArrayList<Object>();

	public SinglyLinkedList() {

	}

	@Override
	public void insertFirst(Object element) {
		arg.add(0, element);

	}

	@Override
	public void insert(int index, Object element) throws IndexOutOfBoundsException {
		arg.add(index, element);

	}

	@Override
	public Object getFirst() throws NoSuchElementException {
		return arg.get(0);
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		return arg.get(index);
	}

	@Override
	public Object deleteFirst() throws NoSuchElementException {
		return arg.remove(0);
	}

	@Override
	public Object delete(int index) throws IndexOutOfBoundsException {
		return arg.remove(index);
	}

	@Override
	public int indexOf(Object element) {
		return arg.indexOf(element);
	}

	@Override
	public int size() {
		return arg.size();
	}

	@Override
	public boolean isEmpty() {
		return arg.isEmpty();
	}

	@Override
	public void clear() {
		arg.clear();
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