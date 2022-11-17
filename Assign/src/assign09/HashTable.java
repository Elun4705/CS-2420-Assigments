package assign09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> implements Map<K, V> {
	
	private ArrayList<LinkedList<MapEntry<K, V>>> table;
	
	private int capacity = 1;
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

		LinkedList<MapEntry<K,V>> list = table.get(index);
		
		for (MapEntry<K,V> entry : list) {
			if (entry.getKey() == key) {
				return true;
			}
		}
		
		return false;
	}

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
		int index = key.hashCode() % capacity;

		LinkedList<MapEntry<K,V>> list = table.get(index);
		
		for (MapEntry<K, V> entry : list) {
			if (entry.getKey() == key) {
				return entry.getValue();
			}
		}
		
		return null;
		
	}

	@Override
	public boolean isEmpty() {
		return (table.size() == 0);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public V put(K key, V value) {
		
		double loadFactor = (size+1)/capacity;
		
		if (loadFactor > 10) {
			this.rehash();
		}
		
		int index = key.hashCode() % capacity;
		
		LinkedList<MapEntry<K,V>> list = table.get(index);
		
		for (MapEntry<K,V> entry : list) {
			if (entry.getKey() == key) {
				V preValue = entry.getValue();
				entry.setValue(value);
				return preValue;
			}
		}
		
		list.add(new MapEntry(key, value));
		size++;
		return null;
		
	}

	@Override
	public V remove(K key) {
		int index = key.hashCode() % capacity;
		
		LinkedList<MapEntry<K,V>> list = table.get(index);
		
		for (MapEntry<K,V> entry : list) {
			if (entry.getKey() == key) {
				V removeValue = entry.getValue();
				list.remove(entry);
				size--;
				return removeValue;
			}
		}
		
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	private void rehash() {
		List<MapEntry<K, V>> entries = this.entries();
		
		ArrayList<LinkedList<MapEntry<K, V>>> newTable = new ArrayList<LinkedList<MapEntry<K, V>>>();
		
		capacity *= 2;
		
		for(int i = 0; i < capacity; i++)
		   newTable.add(new LinkedList<MapEntry<K, V>>());
		
		size = 0;
		table = newTable;
		
		for (MapEntry<K,V> entry : entries) {
			this.put(entry.getKey(), (entry.getValue()));
		}
		
	}
	
	
	public static void main(String args[]) {
		HashTable test = new HashTable();
		
		System.out.println(test.put(1, "worth"));
		System.out.println(test.put(2, "word"));
		System.out.println(test.put(3,"banana"));
		System.out.println(test.put(4,"sleep"));
		System.out.println(test.put(5,"asian"));
		System.out.println(test.put(6,"hispanic"));
		System.out.println(test.put(7, "blossom"));
		System.out.println(test.put(8, "vega"));
		System.out.println(test.put(9,"betelgeuse"));
		System.out.println(test.put(10,"october"));
		
		List<MapEntry<Integer, String>> testEntries = test.entries();

		for (MapEntry<Integer, String> entry : testEntries) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		System.out.println(test.size());
		
		System.out.println(test.put(11,"watcher"));
		
		List<MapEntry<Integer, String>> testEntries2 = test.entries();

		for (MapEntry<Integer, String> entry : testEntries2) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
