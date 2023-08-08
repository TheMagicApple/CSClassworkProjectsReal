
public class MyHashTable<K, V> {
	private DLList<V>[] table;
	private DLList<K> keySet;

	public MyHashTable() {
		table = new DLList[10000];
		keySet = new DLList<>();
	}

	public void put(K k, V... v) {
		if (table[k.hashCode()] == null) {
			table[k.hashCode()] = new DLList<>();
			keySet.add(k);
		}
		for (V vv : v) {
			table[k.hashCode()].add(vv);
		}

	}

	public DLList<V> get(K k) {
		return table[k.hashCode()];
	}

	public DLList<K> keySet() {
		return keySet;
	}

	public String toString() {
		String s = "[";
		for (int i = 0; i < keySet.size(); i++) {
			s += "bucket " + i + " " + ((Student) keySet.get(i)).getName() + " " + ((Student) keySet.get(i)).hashCode()
					+ " " + get(keySet.get(i)).toString();
		}
		s += "]";
		return s;
	}

	public void remove(K k, V v) {
		DLList<V> d = table[k.hashCode()];
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i).equals(v)) {
				d.remove(i);
			}
		}
		if (d.size() == 0) {
			table[k.hashCode()] = null;
		}
	}

	public void remove(K k) {
		table[k.hashCode()] = null;
		
	}

}