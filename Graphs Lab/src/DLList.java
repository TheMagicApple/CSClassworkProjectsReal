public class DLList<E>{
  private Node<E> head;
  private Node<E> tail;
  private int size;
  public DLList(){
    size=0;
  }
  public Node<E> getNode(int i){
    Node n=head;
    int index=0;
    while(index<i){
      n=n.next();
      index++;
			
    }
    return n;
  }
  public boolean add(Node<E> n){
    if(size==0){
      size++;
      head=n;
      tail=n;
    }else{
      size++;
      Node<E> oldTail=tail;
      tail=n;
      oldTail.setNext(tail);
      tail.setPrev(oldTail);
    }
    
    return true;
  }
  public boolean add(int i,Node<E> n){
    if(size==0){
      size++;
      head=n;
      tail=n;
    }else{
      size++;
    Node<E> oldN=head;
    int index=0;
    while(index<i-1){
      oldN=oldN.next();
      index++;
    }
    Node<E> oldAfter=oldN.next();
    oldN.setNext(n);
    n.setPrev(oldN);
    n.setNext(oldAfter);
    oldAfter.setPrev(n);
    }
    
    return true;
  }
  public E get(int i){
    return getNode(i).get();
  }
  public int size(){
    return size;
  }
  
  public void set(int i,Node<E> n){
    Node<E> oldN=head;
    if(i==0){
      n.setNext(head.next());
			head.next().setPrev(n);
      head=n;
      
    }else if(i>=size-1){
      
      tail.prev().setNext(n);
      n.setPrev(tail.prev());
      tail=n;
      //System.out.println("HELLO");
    }else{
      //System.out.println("SIZE: "+(size-1));
      int index=0;
	    while(index<i){
	      oldN=oldN.next();
	      index++;
	    }
      
      
	    Node<E> oldPrev=oldN.prev();
	    Node<E> oldNext=oldN.next();
	    oldPrev.setNext(n);
	    oldNext.setPrev(n);
	    n.setPrev(oldPrev);
	    n.setNext(oldNext);
    }
    
  }
  public E poll() {
	  E e=head.get();
	  if(size==1)clear();
	  else remove(head);
	  return e;
  }
  public boolean empty() {
	  return size==0;
  }
  public void remove(Node<E> n){
		Node nn=head;
    boolean found = false;
    int index=0;
		while (!found){
		  if(nn.get().equals(n.get())){
        found=true;
      }else{
        index++;
        nn = nn.next();
      }
		}
    remove(index);
		
	}
  	public void clear() {
  		head=null;
  		tail=null;
  		size=0;
  	}
	public void remove(int i){
		if(i==0){
      head=head.next();
      head.setPrev(null);
      size--;
    }else if(i==size-1){
      tail=tail.prev();
      tail.setNext(null);
      size--;
    }else{
      Node<E> n = head;
  		for (int j = 0; j <i; j++){
  			n = n.next();
  		}
      size--;
  		n.next().setPrev(n.prev());
  		n.prev().setNext(n.next());
    }
		
		
	}


}