import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet<E>{
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
				if(hashTable[i].toString()!=null) {
					s+=hashTable[i].toString()+", ";
					//System.out.println(hashTable[i].getClass());
					
				}
			}
		}
		if(s.length()!=1) {
			s=s.substring(0,s.length()-2);
		}
		
		s+="]";
		return s;
	}
	public int size() {
		return size;
	}
	public Iterator<E> toIterator(){
		return (Iterator<E>) Arrays.stream(hashTable).iterator();
	}
	public Object[] toArray() {
		return Arrays.stream(hashTable).toArray();
	}
	
	
	
	
}
