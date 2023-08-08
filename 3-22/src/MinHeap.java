import java.util.ArrayList;

public class MinHeap<E extends Comparable<E>> {
	private ArrayList<E> myList=new ArrayList<>();
	public void add(E e) {
		myList.add(e);
		swapUp(myList.size()-1);
	}
	public void remove(E e) {
		System.out.println();
		int index=myList.indexOf(e);
		myList.set(index, myList.get(myList.size()-1));
		myList.remove(myList.size()-1);
		swapDown(index);
	}
	public E poll() {
		E root=myList.get(0);
		remove(root);
		return root;
	}
	public void swapUp(int i) {
		while(i>0) {
			int parent=(i-1)/2;
			if(myList.get(parent).compareTo(myList.get(i))>0) {
				E temp=myList.get(i);
				myList.set(i, myList.get(parent));
				myList.set(parent, temp);
				i=parent;
			}else {
				break;
			}
		}
	}
	public void swapDown(int i) {
		while(i<myList.size()) {
			int left=i*2+1;
			int right=i*2+2;
			if(right>=myList.size()) {
				if(left>=myList.size()) {
					break;
				}else {
					if(myList.get(left).compareTo(myList.get(i))<0) {
						int swap=left;
						E temp=myList.get(i);
						myList.set(i, myList.get(swap));
						myList.set(swap, temp);
						i=swap;
					}
					break;
				}
				
			}
			if(myList.get(left).compareTo(myList.get(i))<0 && myList.get(right).compareTo(myList.get(i))<0) {
				int swap=(myList.get(left).compareTo(myList.get(right))>0)?right:left;
				E temp=myList.get(i);
				myList.set(i, myList.get(swap));
				myList.set(swap, temp);
				i=swap;
			}else {
				if(myList.get(left).compareTo(myList.get(i))<0) {
					int swap=left;
					E temp=myList.get(i);
					myList.set(i, myList.get(swap));
					myList.set(swap, temp);
					i=swap;
				}
				else if(myList.get(right).compareTo(myList.get(i))<0) {
					int swap=right;
					E temp=myList.get(i);
					myList.set(i, myList.get(swap));
					myList.set(swap, temp);
					i=swap;
				}else {
					break;
				}	
			}
		}
	}
	public String toString() {
		int level=1;
		String s="";
		for(int i=0;i<myList.size();i++) {
			s+=myList.get(i)+" ";
			if(i==level-1) {
				level+=level*2;
				s+="\n";
			}
		}
		return s;
	}
	public int size() {
		return myList.size();
	}
}
