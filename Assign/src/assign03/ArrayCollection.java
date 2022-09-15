package assign03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** 
 * @author Daniel Kopta, Andy Huo and Emmanuel Luna
 * Implements the Collection interface using an array as storage.
 * The array must grow as needed.
 * An ArrayCollection can not contain duplicates.
 * All methods should be implemented as defined by the Java API, unless otherwise specified.
 * 
 * It is your job to fill in the missing implementations and to comment this class. 
 * Every method should have comments (Javadoc-style prefered). 
 * The comments should at least indicate what the method does, 
 * what the arguments mean, and what the returned value is. 
 * It should specify any special cases that the method
 * handles. Any code that is not self-explanatory should be commented.
 *
 * @param <T> - generic type placeholder
 */
public class ArrayCollection<T> implements Collection<T> {

	private T data[]; // Storage for the items in the collection
	private int size; // Keep track of how many items this collection holds

	// There is no clean way to convert between T and Object, so we suppress the warning.
	@SuppressWarnings("unchecked")  
	public ArrayCollection()
	{
		size = 0;
		// We can't instantiate an array of unknown type T, so we must create an Object array, and typecast
		data = (T[]) new Object[10]; // Start with an initial capacity of 10
	}

	/**
	 * This is a helper method specific to ArrayCollection
	 * Doubles the size of the data storage array, retaining its current contents.
	 */
	@SuppressWarnings("unchecked")
	private void grow()
	{
		// TODO fill in
		
		T arr[] = (T[]) new Object[((this.data).length) * 2];
		
		for (int i = 0; i < size; i++) {
			arr[i] = data[i];
		}
		
		this.data = (T[]) arr;
		
		// You will need to use something similar to the code in the constructor above to create a new array.
	}
	
	/**
	 * A helper method for testing purposes
	 * 
	 * @param i the index of the item we need to access
	 * @return the object from the given index
	 */
	public T get(int i){
		return this.data[i];
	}


	/**
	 * Adds an object to the end of the ArrayCollection
	 * 
	 * @param arg0 the object adding to the ArrayCollection
	 * @return true if object was successfully added, false otherwise
	 */
	public boolean add(T arg0) {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.size; i++) {
			if (this.contains(arg0))
				return false;
			else {
				continue;
			}
		}
		
		if (this.size == this.data.length)
			this.grow();
		
		data[this.size] = arg0;
		size++;
		
		return true;
	}

	/**
	 * Adds all of the objects from the input Collection to the ArrayColection
	 * 
	 * @param arg0 the Collection we are adding from
	 * @return true if anything was added, false otherwise
	 */
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		
		Iterator<? extends T> it = arg0.iterator();
		
		if (this.containsAll(arg0)) {
			return false;
		}
		
		while(it.hasNext()) {
			T obj = it.next();
			if(this.contains(obj) == false) {
				this.add(obj);
			}		
		}
		return true;
	}

	/**
	 * Sets all objects in the array list to null, effectively emptying it out
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
		size = 0;
	}

	/**
	 * Checks to see if an ArrayCollection contains a certain object
	 *
	 * @param arg0 the object being searched for
	 * @return true if the ArrayCollection contains the object, false otherwise
	 */
	public boolean contains(Object arg0) {
		for(int i = 0; i < this.size; i++) {
			if (data[i].equals(arg0))
				return true;
		}
		return false;
	}

	/**
	 * Checks to see if an ArrayCollection contains all items in an input collection
	 * 
	 * @param arg0 the collection of objects being checked
	 * @return true if the ArrayCollection contains all objects, false otherwise
	 */
	public boolean containsAll(Collection<?> arg0) {
		for(int i = 0; i < arg0.size(); i++) {
			Object[] arg0Array = arg0.toArray();
			if (this.contains(arg0Array[i]) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks to see if an ArrayCollection is empty
	 * 
	 * @return true if the collection is empty, false otherwise
	 */
	public boolean isEmpty() {
		return (size == 0);		
	}

	/**
	 * Returns a custom iterator for the purpose of this class
	 * 
	 * @return an ArrayCollectionIterator
	 */
	public Iterator<T> iterator() {
		ArrayCollectionIterator ACI = new ArrayCollectionIterator();
		return ACI;
	}

	/**
	 * Removes an object from this ArrayCollection
	 * 
	 * @param arg0 the object to be removed
	 * @return true if an object was successfuly removed, false otherwise
	 */
	public boolean remove(Object arg0) {
		if (this.contains(arg0) == false) {
			return false;
		}
		
		for (int i = 0; i < this.size; i++) {
			if (data[i] == arg0) {
				for (int j = i; j < this.size; j++) {
					data[j] = data[j+1];
				}
			}
		}
		size--;
		return true;
	}

	/**
	 * Removes all objects in the input list
	 *
	 * @param arg0 the input collection of objects to be removed
	 * @return true if any objects were removed, false otherwise
	 */
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		
		Iterator<?> it = arg0.iterator();
		Iterator<?> check = arg0.iterator();
		
		while(check.hasNext()) {
			if(this.contains(check.next())) {
				while(it.hasNext()) {
					Object obj = it.next();
					if (this.contains(obj)) {
						this.remove(obj);
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Keeps only the objects which are contained in both ArrayCollection and the input collection
	 * 
	 * @param arg0 the input collection to check against
	 * @return true if any objects were removed, false otherwise
	 */
	public boolean retainAll(Collection<?> arg0) {
		Iterator<?> thisIt = this.iterator();

		for (int i = 0; i < this.size; i++) {
			if(arg0.contains(this.data[i])) {
				for (int j = 0; j < this.size; j++) {
					if(arg0.contains(this.data[j]) == false) {
						this.remove(data[j]);
						j--;
					}
				}
					return true;
			}	
		}	
		return false;
	}
	/**
	 * Returns the number of objects in a collection
	 * 
	 * @return the number of objects in a collection
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns the objects in ArrayCollection in array form 
	 *
	 * @return an array of the Objects in ArrayCollection
	 */
	@SuppressWarnings("unchecked")
	public Object[] toArray() {
		T[] array = (T[]) new Object[size];
		for (int i = 0; i < size; i++) {
			array[i] = this.data[i];
		}
		return array;
	}

	/* 
	 * Don't implement this method (unless you want to).
	 * It must be here to complete the Collection interface.
	 * We will not test this method.
	 */
	public <T> T[] toArray(T[] arg0) {
		return null;
	}



	/*
     
	*/
	/**
	 * Sorting method specific to ArrayCollection - not part of the Collection interface.
     	Must implement a selection sort (see Assignment 2 for code).
     	Must not modify this ArrayCollection.
	 * @param cmp - the comparator that defines item ordering
	 * @return - the sorted list
	 */
	public ArrayList<T> toSortedList(Comparator<? super T> cmp)
	{
		ArrayList<T> finalList = new ArrayList<T>();
		for(int i = 0; i < data.length - 1; i++) {
			int j, minIndex;
			for(j = i + 1, minIndex = i; j < data.length; j++)
				if(cmp.compare(data[j], this.data[minIndex]) < 0)
					minIndex = j;
			T temp = data[i];
			finalList.set(i, data[minIndex]);
			finalList.set(minIndex, temp);
		}
		return finalList;
	}


	/**
	 * 
	 * @author ??
	 * Describe your ArrayCollectionIterator class here.
	 *
	 */
	private class ArrayCollectionIterator implements Iterator<T>
	{
		boolean removeable = false;
		int index = 0;

		public boolean hasNext() {
			if (index < size && data[index] != null) {
				return true;
			}
			return false;
		}

		public T next() throws NoSuchElementException {
			if (this.hasNext()) {
				removeable = true;
				return data[index++];
			} 
			else {throw new NoSuchElementException();}	
		}

		public void remove() throws IllegalStateException{
			if (removeable) {
				ArrayCollection.this.remove(index);
				removeable = false;
			}
			else {throw new IllegalStateException();}
		}

	}
	
	public static void main(String[] args) {
		ArrayCollection<String> arc1 = new ArrayCollection<String>();
		ArrayCollection<String> arc2 = new ArrayCollection<String>();
		arc1.add("a");
		arc1.add("b");
		arc1.add("C");
		arc1.add("d");
		arc2.add("a");
		arc2.add("b");
		arc2.add("D");
		arc2.add("red");
		System.out.println(arc1.retainAll(arc2));
		System.out.println(arc1.contains("a"));
		System.out.println(arc1.contains("b"));
		System.out.println(arc1.contains("C"));
		System.out.println(arc1.contains("d"));
	}
	
}
