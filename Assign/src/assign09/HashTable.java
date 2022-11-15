package assign09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> implements Map<K, V> {
	
	private ArrayList<LinkedList<MapEntry<K, V>>> table;
	
	private int capacity;
	private double lf;
	
	public HashTable() {
		table = new ArrayList<LinkedList<MapEntry<K, V>>>();
		for(int i = 0; i < capacity; i++)
		   table.add(new LinkedList<MapEntry<K, V>>());
	}

	@Override
	public void clear() {
		lf = 0;
		for(LinkedList<MapEntry<K, V>> item : table) {
			table.remove(item);
		}
		
	}

	@Override
	public boolean containsKey(K key) {
		int index = key.hashCode();

		if (table.get(index) != null) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean containsValue(V value) {
		for (K key : table) {
			
		}
	}

	@Override
	public List<MapEntry<K, V>> entries() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public V put(K key, V value) {
		if (table.contains(key)) {
			table
		}
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String args[]) {
		HashTable test = new HashTable();
		tes
	}
}
