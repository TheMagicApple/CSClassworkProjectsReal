

public class MyHashSet<E> {
	private int size;
	private Object[] hashTable;
	public MyHashSet() {
		size=0;
		hashTable=new Object[20000];
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
	public MyArrayList<E> toArray() {
		MyArrayList<E> array=new MyArrayList<>();
		for(int i=0;i<hashTable.length;i++) {
			if(hashTable[i]!=null) {
				array.add((E)hashTable[i]);
			}
		}
		return array;
		/*
		Object[] array=new Object[1000000];
		int index=0;
		for(int i=0;i<hashTable.length;i++) {
			if(hashTable[i]!=null) {
				array[index]=hashTable[i];
				index++;
			}
		}
		Object[] theArray=new Object[index];
		for(int i=0;i<index;i++) {
			theArray[i]=array[i];
		}
		return ((E[])theArray);
		*/
		
	}
	
	
	
}
