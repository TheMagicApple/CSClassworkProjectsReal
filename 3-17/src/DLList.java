public class DLList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DLList(){
        head = null;
        tail = null;
        size = 0;
    }


    public Node<E> getNode(int n){

        Node<E> current = head;
        int index = 0;
        while(current != null){
            if(index == n){
                return current;
            }
            current = current.next();
            index++;
        }
        return null;
    }

    public boolean add(E e){
        Node<E> newNode = new Node<E>(e);
        if(head == null) {
          head = newNode;
        } else {
          newNode.setPrev(tail);
          tail.setNext(newNode);
         
        }

        tail = newNode;
        size++;
 
        return true;

    }

    public boolean add(int i, E e){
        int index = 0;
        Node<E> newNode = new Node<E>(e);


        if(i == 0){
            if(head == null){
                head = newNode;
                tail = newNode;
                size++;
                return true;
            }
        }
        Node<E> current = head;
        while (current != null) {
            Node<E> next = current.next();
            if(index == i) {
               
                current.setNext(newNode);
                newNode.setNext(next);
                if(next != null)
                    next.setPrev(newNode);
                newNode.setPrev(current);

                if(newNode.next() == null){
                    tail = newNode;
                }
                size++;
                return true;
            }
            current = next;
            index++;
        }
       

        return false;
       
    }

    public E get(int index) {
       if(getNode(index)!=null)
         return getNode(index).get();
       return null;
    }

    public int size() {
       return size;
    }

    public Node<E> getLast(){
        return tail;
    }


    public String toString(){
        Node<E> start = head;
        String s = "";
        if(start==null)return "";
        while(start != null){
           
            //System.out.println("start =" + start.get());
            s = s + start.get() + "\n";
            start = start.next();
        }

        //s = s + "]";

        return s;
    }



    @SuppressWarnings("unchecked")
    public E remove(int i){

        int index = 0;
        Node<E> current = head;

        if(i == 0){
            Node<E> r = head;
            Node<E> n = current.next();
            head = n;
            size--;
            return r.get();
        } else{
            while(current != null){
                Node<E> nextElement = current.next();
                if(i == index){
                    E info = current.get();

                   

                   

                    current.prev().setNext(current.next());
                   
                    if(current.next() != null){
                        current.next().setPrev(current.prev());
                    }
                    else{
                        tail = current.prev();
                    }
                    size--;
                   
                    return info;
                }
                current = nextElement;
                index++;
            }
        }

        return null;
       
    }
    @SuppressWarnings("unchecked")
    public void set(int i, E obj){
        System.out.println(i + " ");
        add(i, obj);
        remove(i);
       
    }
    @SuppressWarnings("unchecked")
    public boolean remove(Object o){
        Node<E> current = head;

        while(current != null){
            if(current.get().equals(o)){
                if(current == head){
                    head = current.next();
                }
                if(current == tail){
                    tail = current.prev();
                }
                if(current.next() != null){
                    current.next().setPrev(current.prev());
                }

               
                if(current.prev() != null){
                    current.prev().setNext(current.next());
                }
                size--;
                return true;
            }
            current = current.next();
        }

        return false;
    }

    public Node<E> getHead(){
        return head;
    }

    // public void sort(DLList<Card> s){
    //     Node<Card> current = s.getHead();
    //     Node<Card> oneAhead = null;
 
    //     if(head == null || head.next() == null){
    //         return;
    //     } else {
    //         while (current != null) {
               
    //             oneAhead = current.next();
 
    //             while (oneAhead != null) {
           
    //                 if (current.get().getValue() > (oneAhead.get().getValue())) {
    //                     Card temp = current.get();
    //                     current.set(oneAhead.get());
    //                     oneAhead.set(temp);
    //                 }
 
    //                 oneAhead = oneAhead.next();
    //             }
    //             current = current.next();
    //         }
    //     }
    // }

    public void shuffle(){
        Node<E> current = head;
       
        int i = 0;



        for(int j = 0; j<3; j++){
            for(i = 0; i<size(); i++){
               
                int random = (int)(Math.random() * (size() - 1));
                E temp = get(random);
                System.out.println("Swapping " + random + " for " + i);
                System.out.println("Size: " + size());
                System.out.println(countElements());

                set(random, get(i));

                set(i, temp);

               
               
            }
           
        }
       
    }


    public int countElements(){
        Node<E> current = head;
        int i = 0;

        while(current != null){
           
            current = current.next();
            i++;

        }
        return i;
    }

}
