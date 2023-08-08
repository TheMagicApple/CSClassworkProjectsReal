public class DLList<E>{
	private Node<E> dummy;
	private int size;
	public DLList() {
		size=0;
		dummy=new Node<>(null);
		dummy.setNext(null);
		dummy.setPrev(null);
	}
	public void add(E e) {
		Node n=new Node<E>(e);
		if(size==0) {
			dummy.setNext(n);
			dummy.setPrev(n);
		}else {
			dummy.prev().setNext(n);
			n.setPrev(dummy.prev());
			dummy.setPrev(n);
		}
		size++;
	}
	public E get(int index) {
		Node<E> first=dummy.next();
		for(int i=0;i<index;i++) {
			first=first.next();
		}
		return first.get();
	}
	public void remove(E e) {
		Node<E> first=dummy.next();
		int index=0;
		while(first!=null) {
			Food food=(Food)new Node<>(e).get();
			Food myFood=(Food)first.get();
			if(food.getName().equals(myFood.getName()) && food.getPrice()==myFood.getPrice()) {
				if(index==0) {
					dummy.setNext(dummy.next().next());
				}else if(index==size-1) {
					dummy.setPrev(dummy.prev().prev());
					dummy.prev().setNext(null);
				}else {
					first.prev().setNext(first.next());
					first.next().setPrev(first.prev());
				}
				size--;
				break;
			}
			if(first.next()==null) {
				first=null;
			}else {
				first=first.next();
			}
			index++;
		}
	}
	public String toString() {
		if(size==0) {
			return "[]";
		}
		String s="[";
		Node<E> first=dummy.next();
		while(first!=null) {
			s+=first.get()+", ";
			if(first.next()==null) {
				first=null;
			}else {
				first=first.next();
			}
		}
		s=s.substring(0,s.length()-2);
		s+="]";
		return s;
	}
	public int size() {
		return size;
	}
}