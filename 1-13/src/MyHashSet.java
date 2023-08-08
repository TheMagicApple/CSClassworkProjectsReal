import java.util.Arrays;
import java.util.Iterator;

public class MyHashSet<E> {
	private int size;
	private Object[] hashTable;
	public MyHashSet() {
		size=0;
		hashTable=new Object[100000];
	}
	public boolean add(E e) {
		if(hashTable[e.hashCode()]==null) {
			hashTable[e.hashCode()]=e;
			size++;
			return true;
		}
		return false;
	}
	public void clear() {
		for(int i=0;i<hashTable.length;i++) {
			hashTable[i]=null;
		}
	}
	public boolean contains(Object o) {
		return hashTable[o.hashCode()]!=null;
	}
	public boolean remove(Object o) {
		if(hashTable[o.hashCode()]!=null) {
			hashTable[o.hashCode()]=null;
			size--;
			return true;
		}
		return false;
	}
	public String toString() {
		String s="[";
		for(int i=0;i<hashTable.length;i++) {
			if(hashTable[i]!=null) {
				s+=hashTable[i].toString()+", ";
			}
		}
		s="]";
		return s;
	}
	public int size() {
		return size;
	}
	public Iterator<E> toIterator(){
		return (Iterator<E>) Arrays.stream(hashTable).iterator();
	}
	
	
	
}
