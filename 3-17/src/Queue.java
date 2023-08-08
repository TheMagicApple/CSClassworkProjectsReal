public class Queue<E> {
   
    private DLList<E> s;

    public Queue(){
        s = new DLList<E>();
    }

    public void add(E e){
        s.add(e);
    }
    public void clear() {
    	s=new DLList<E>();
    }
    public E poll(){
        return s.remove(0);
    }

    public E peek(){
        return s.get(0);
    }

    public int size(){
        return s.size();
    }

    public boolean empty(){
        if (s.size() == 0){
            return true;
        }
        return false;
    }

    public String toString(){
        return s.toString();
    }
   

       
   


}
