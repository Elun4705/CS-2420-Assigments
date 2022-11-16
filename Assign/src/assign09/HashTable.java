package assign09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> implements Map<K, V> {
	
	private ArrayList<LinkedList<MapEntry<K, V>>> table;
	
	private int capacity = 50;
	private int size = 0;
	
	public HashTable() {
		table = new ArrayList<LinkedList<MapEntry<K, V>>>();
		for(int i = 0; i < capacity; i++)
		   table.add(new LinkedList<MapEntry<K, V>>());
	}

	@Override
	public void clear() {
		for(LinkedList<MapEntry<K, V>> list : table) {
			list.clear();
		}
		size = 0;
	}

	@Override
	public boolean containsKey(K key) {
		int index = key.hashCode() % capacity;

		if (table.get(index).isEmpty()) {
			return false;
		}
		
		return true;
		
	}

	@Override
	public boolean containsValue(V value) {
		for (LinkedList<MapEntry<K, V>> list : table) {
			for (MapEntry<K, V> entry : list) {
s				
			}
		}
		return true;
	}

	@Override
	public List<MapEntry<K, V>> entries() {
		
		ArrayList<MapEntry<K, V>> entries = new ArrayList<MapEntry<K, V>>();
		
		for (LinkedList<MapEntry<K, V>> list : table) {
			entries.addAll(list);
		}
		
		return entries;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % capacity;
		LinkedList<MapEntry<K,V>> list = table.get(index);
		
		size++;
		
		if (list.isEmpty() == false) {
			V previous = list.getLast().getValue();
			list.add(new MapEntry(key, value));
			return previous;
		}
		
		list.add(new MapEntry(key, value));
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public static void main(String args[]) {
		HashTable test = new HashTable();
		
		System.out.println(test.containsKey(1));
		System.out.println(test.size());
		
		test.put(1, "string");
		System.out.println(test.put(1, "word"));
		System.out.println(test.put(2, "word"));
		
		List<MapEntry<Integer, String>> testEntries = test.entries();

		for (MapEntry<Integer, String> entry : testEntries) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		System.out.println(test.containsKey(1));
		System.out.println(test.size());
	}
}
