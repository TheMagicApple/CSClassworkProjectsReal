import java.io.Serializable;

public class Node<E> implements Serializable{
  private E e;
  private Node<E> next;
  private Node<E> prev;
  public Node(E e){
    this.e=e;
    next=null;
    prev=null;
      
  }
  public E get(){
    return e;
  }
  public void set(E e) {
	 this.e=e;
  }
  public Node<E> next(){
    return next;
  }
  public Node<E> prev(){
    return prev;
  }
  public void setNext(Node<E> next){
    this.next=next;
  }
  public void setPrev(Node<E> prev){
    this.prev=prev;
  }
  
  
  


	
}
