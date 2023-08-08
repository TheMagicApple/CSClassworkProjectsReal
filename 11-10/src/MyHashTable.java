public class MyHashTable<K,V> {
	private DLList<V>[] table;
	private MyHashSet<K> keySet;
	public MyHashTable() {
		table=new DLList[100000];
		keySet=new MyHashSet<>();
	}
	public void put(K key,V value) {
		if(table[key.hashCode()]==null) {
			table[key.hashCode()]=new DLList<V>();
		}
		table[key.hashCode()].add(value);
		keySet.add(key);
	}
	public DLList<V> get(K key){
		return table[key.hashCode()];
	}
	public MyHashSet<K> keySet(){
		return keySet;
	}
	public String toString() {
		String s="";
		DLList<K> d=keySet.toDLList();
		for(int i=0;i<d.size();i++) {
			s+="Bucket "+d.get(i).hashCode()+" - "+d.get(i).toString()+" - "+table[d.get(i).hashCode()].toString()+"\n";
		}
		return s;
	}
	public void remove(K key,V value) {
		table[key.hashCode()].remove(value);
		if(table[key.hashCode()].size()==0) {
			table[key.hashCode()]=null;
			keySet.remove(key);
		}
	}
	public void remove(K key) {
		table[key.hashCode()]=null;
		keySet.remove(key);
	}
}