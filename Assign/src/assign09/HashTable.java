package assign09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * A class for a HashTable using separate chaining.  The table's capacity is initially
 * set to 1 for ease of testing, however, this can be changed quite easily at any time by simply
 * changing the instance variable below.
 * 
 * @author Andy Huo and Emmanuel Luna
 *
 * @param <K> Key
 * @param <V> Value
 */
public class HashTable<K, V> implements Map<K, V> {

	private ArrayList<LinkedList<MapEntry<K, V>>> table;

	private int capacity = 1;
	private int size = 0;

	public HashTable() {
		table = new ArrayList<LinkedList<MapEntry<K, V>>>();
		for (int i = 0; i < capacity; i++)
			table.add(new LinkedList<MapEntry<K, V>>());
	}

	/**
	 * Clears every item from the HashTable
	 */
	@Override
	public void clear() {
		for (LinkedList<MapEntry<K, V>> list : table) {
			list.clear();
		}
		size = 0;
	}

	/**
	 * Returns true if the given key is found within the HashTable, false otherwise.
	 * 
	 * @param key - the key to be searched for
	 * @return whether or not the HashTable contains the given key
	 */
	@Override
	public boolean containsKey(K key) {
		int index = key.hashCode() % capacity;

		LinkedList<MapEntry<K, V>> list = table.get(index);

		for (MapEntry<K, V> entry : list) {
			if (entry.getKey() == key) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns true if the HashTable contains the given value, false otherwise
	 * 
	 * @param value - the value to be searched for
	 * @return whether or not the HashTable contains the given value
	 */
	@Override
	public boolean containsValue(V value) {
		for (LinkedList<MapEntry<K, V>> list : table) {
			for (MapEntry<K, V> entry : list) {
				if (entry.getValue() == value) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Returns a list of all the entries in the HashTable, in no particular order.
	 * 
	 * @return a list of all values in the HashTable
	 */
	@Override
	public List<MapEntry<K, V>> entries() {

		ArrayList<MapEntry<K, V>> entries = new ArrayList<MapEntry<K, V>>();

		for (LinkedList<MapEntry<K, V>> list : table) {
			entries.addAll(list);
		}

		return entries;
	}

	/**
	 * Returns the value associated with the given key
	 * 
	 * @param key - the key to be searched for
	 * @return the value associated with the given key, or null if there is no such mapping
	 */
	@Override
	public V get(K key) {
		int index = key.hashCode() % capacity;

		LinkedList<MapEntry<K, V>> list = table.get(index);

		for (MapEntry<K, V> entry : list) {
			if (entry.getKey() == key) {
				return entry.getValue();
			}
		}

		return null;

	}

	/**
	 * Returns whether or not the HashTable is empty
	 * 
	 * @return true if the HashTable is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Adds the given key and value pair as a mapping to the list
	 * 
	 * @param key - the mapping key
	 * @param value - the mapping value
	 * @return the prior value associated with that key, or null if there was no such value
	 */
	@Override
	public V put(K key, V value) {

		double loadFactor = (size + 1) / (double) capacity;

		if (loadFactor > 10) {
			this.rehash();
		}

		int index = key.hashCode() % capacity;

		LinkedList<MapEntry<K, V>> list = table.get(index);

		for (MapEntry<K, V> entry : list) {
			if (entry.getKey() == key) {
				V preValue = entry.getValue();
				entry.setValue(value);
				return preValue;
			}
		}

		list.add(new MapEntry<K, V>(key, value));
		size++;
		return null;

	}

	/**
	 * Removes the mapping associated with the key and returns it
	 * 
	 * @param key - the key to find the removeable value
	 * @return the value last associated with the key, or null if there is no such value
	 */
	@Override
	public V remove(K key) {
		int index = key.hashCode() % capacity;

		LinkedList<MapEntry<K, V>> list = table.get(index);

		for (MapEntry<K, V> entry : list) {
			if (entry.getKey() == key) {
				V removeValue = entry.getValue();
				list.remove(entry);
				size--;
				return removeValue;
			}
		}

		return null;
	}

	/**
	 * Returns the number of objects in the HashTable
	 * 
	 * @return the number of objects in the HashTable
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * A private helper method which will rehash the HashTable in the event the load factor might go over 10
	 */
	private void rehash() {
		List<MapEntry<K, V>> entries = this.entries();

		ArrayList<LinkedList<MapEntry<K, V>>> newTable = new ArrayList<LinkedList<MapEntry<K, V>>>();

		capacity *= 2;

		for (int i = 0; i < capacity; i++)
			newTable.add(new LinkedList<MapEntry<K, V>>());

		size = 0;
		table = newTable;

		for (MapEntry<K, V> entry : entries) {
			this.put(entry.getKey(), (entry.getValue()));
		}

	}

	/**
	 * A method which returns the current capacity of the HashTable for ease of testing purposes only.
	 * 
	 * @return the capacity of the HashTable (or, the size of the backing array)
	 */
	public int getCapacity() {
		return capacity;
	}

}
