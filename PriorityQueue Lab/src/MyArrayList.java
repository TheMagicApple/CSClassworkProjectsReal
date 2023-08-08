
public class MyArrayList<E> {
	private int size;
	private Object[] list=new Object[20000];
	int index=0;
	public void add(E e) {
		list[index]=e;
		index++;
		size++;
	}
	public E get(int i) {
		return (E)(list[i]);
	}
	public void set(int i,E e) {
		list[i]=e;
	}
	public boolean contains(E e) {
		for(Object o:list) {
			if(o==null) {
				return false;
			}
			if(((E)o).equals(e)) {
				return true;
			}
		}
		return false;
	}
	public void remove(int index) {
		list[index]=null;
		this.index--;
		size--;
		for(int i=index+1;i<list.length;i++) {
			list[i-1]=list[i];
		}
	}
	public int indexOf(E e) {
		for(int i=0;i<list.length;i++) {
			if(list[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	public void remove(E e) {
		boolean shifting=false;
		for(int i=0;i<list.length;i++) {
			if(shifting) {
				list[i-1]=list[i];
			}else {
				if(list[i]!=null && ((E)list[i]).equals(e)) {
					list[i]=null;
					index--;
					size--;
					shifting=true;
				}
			}
			
			
		}
	}
	public int size() {
		return size;
	}
	public void reverse() {
		for(int i=0;i<index/2;i++) {
			Object temp=list[i];
			list[i]=list[index-1-i];
			list[index-1-i]=temp;
		}
	}
}