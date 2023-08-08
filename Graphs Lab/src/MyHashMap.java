
public class MyHashMap<K,V> {
	private Object[] hashTable;
	private int size;
	private MyHashSet<K> keySet;
	public MyHashMap() {
		hashTable=new Object[10000];
		size=0;
		keySet=new MyHashSet<>();
	}
	public V put(K k,V v) {
		V old=(V) hashTable[k.hashCode()];
		if(old==null) {
			size++;
			keySet.add(k);
			
		}
		hashTable[k.hashCode()]=v;
		return old;
	}
	public V get(K k) {
		return (V) hashTable[k.hashCode()];
	}
	public V remove(K k) {
		V old=(V) hashTable[k.hashCode()];
		if(old!=null) {
			size--;
			keySet.remove(k);
		}
		hashTable[k.hashCode()]=null;
		return old;
	}
	public int size() {
		return size;
	}
	public MyHashSet<K> keySet(){
		return keySet;
	}
	
	
	
	
}
