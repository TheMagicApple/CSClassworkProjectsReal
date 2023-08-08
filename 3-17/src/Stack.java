public class Stack<E> {
   
    private DLList<E> s;

    public Stack(){
        s = new DLList<E>();
    }

    public void push(E e){
        s.add(e);
    }
    public void clear() {
    	s=new DLList<E>();
    }
    public E pop(){
        return s.remove(s.size()-1);
    }

    public E peek(){
        return s.get(s.size()-1);
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
