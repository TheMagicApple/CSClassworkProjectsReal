import java.io.Serializable;

public class DLList<E> implements Serializable{
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DLList() {
        head = new Node<E>(null);
        tail = new Node<E>(null);
        size = 0;
    }

    public Node<E> getNode(int idx) {
        int i = 0;
        if (i >= size || i < 0)
            return null;
        for (Node<E> cur = head.next(); cur.next() != null; cur = cur.next(), i++) {
            if (idx == i)
                return cur;
        }
        return null;
    }

    public E get(int idx) {
        Node<E> node = getNode(idx);
        if (node == null) return null;
        return node.get();
    }
    public void add(int idx, E elem) {
        Node<E> prev = getNode(idx - 1);
        Node<E> node = new Node<E>(elem);
        if (prev == null) {
            prev = head;
        }
        node.setPrev(prev);
        prev.setNext(node);
        //}   
        Node<E> next = getNode(idx + 1);
        if (next == null) {
            next = tail;
        }
    
       // node.setPrev(next.prev());
        node.setNext(next);
        next.setPrev(node);
        
        size++;

    }

    public void add(E elem) {
        add(size, elem);
    }

    public int size() {
        return size;
    }

    public String toString() {
        String s = "[";
        int i = 0;
        for (Node<E> cur = head.next(); cur.next() != null; cur = cur.next(), i++) {
            s += cur.get()+", ";
        }
        s=s.substring(0,s.length()-2);
        s+="]";
        return s;
    }

    public void remove(Node<E> node) {
        node.prev().setNext(node.next());
        node.next().setPrev(node.prev());
        size--;
    }

    public E remove(int idx) {
        Node<E> node = getNode(idx);
        remove(node);
        return node.get();
    }

    public void remove(E elem) {
        for (Node<E> cur = head.next(); cur.next() != null; cur = cur.next()) {
            if (cur.get().toString().equals(elem.toString())) {
                remove(cur);
                return;
            }
        }
    }

    public void set(int i, E elem) {
        getNode(i).set(elem);
    }
}