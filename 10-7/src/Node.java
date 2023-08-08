public class Node<E> {
	private E data;
	private Node<E> next;
	private Node<E> prev;
	public Node(E data) {
		this.data=data;
		
	}
	public E get() {
		return data;
	}
	public Node<E> next(){
		return next;
	}
	public Node<E> prev(){
		return prev;
	}
	public void setNext(Node<E> n) {
		next=n;
	}
	public void setPrev(Node<E> n) {
		prev=n;
	}
}