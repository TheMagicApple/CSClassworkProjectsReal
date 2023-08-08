import java.util.AbstractList;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class MyArrayList<E> extends AbstractList<E> implements Iterable<E>{
	private Object[] a;
  private int maxSize=500;
  private int size=0;
  private int increaseFactor=10;
  public MyArrayList(){
    a=new Object[maxSize];
  }
  public boolean add(Object o){
    if(a[maxSize-1]==null){
      a[size]=o;
      size++;
    }else{
      maxSize+=increaseFactor;
      Object[] aCopy=a.clone();
      a=new Object[maxSize];
      for(int i=0;i<aCopy.length;i++){
        a[i]=aCopy[i];
      }

      a[size]=o;
      size++;
    }
    return true;
  }
  
  public void add(int index,Object o){
	   for(int i=maxSize-1;i>index;i--) {
		   a[i]=a[i-1];
	   }
	   size++;
	   a[index]=o;
	 }
  
  @SuppressWarnings("unchecked")
  public E get(int i){
    return (E) a[i];
  }
  @SuppressWarnings("unchecked")
  public E remove(int i){
    size-=1;
    Object o=a[i];
    a[i]=null;
      for(int k=i+1;k<=size;k++){
        a[k-1]=a[k];
      }
    a[size]=null;
    
    if(size==maxSize-increaseFactor){
      maxSize=maxSize-increaseFactor;
      Object[] aCopy=a.clone();
      a=new Object[maxSize];
      for(int j=0;j<aCopy.length;j++){
        a[j]=aCopy[j];
      }
    }
    return (E) o;
    
  }
  public E removeR(E e){
    for(int i=0;i<size;i++){
      if(e.equals(a[i])){
        return remove(i);
      }
    }
    return null;
  }
  
  public E set(int i, E e){
    a[i]=e;
    return (E)a[i];
  }
  @SuppressWarnings("unchecked")
  public String toString(){
    String s="[";
    for(Object o:a){
     if(o!=null){
        E e=(E)o;
        s+=e.toString()+",";
       
     }
      
    }
    s=s.substring(0,s.length()-1);
    s+="]";
    return s;
  }
  public int size(){
    return size;
  }
  @Override
  public Iterator<E> iterator() {
	  return new Itr();
  }
  	private class Itr implements Iterator<E> {
	    int cursor;       // index of next element to return
	    int lastRet = -1; // index of last element returned; -1 if no such
	    int expectedModCount = modCount;
	
	    public boolean hasNext() {
	        return cursor != size;
	    }
	
	    @SuppressWarnings("unchecked")
	    public E next() {
	        checkForComodification();
	        int i = cursor;
	        if (i >= size)
	            throw new NoSuchElementException();
	        Object[] elementData =MyArrayList.this.a;
	        if (i >= elementData.length)
	            throw new ConcurrentModificationException();
	        cursor = i + 1;
	        return (E) elementData[lastRet = i];
	    }
	
	    public void remove() {
	        if (lastRet < 0)
	            throw new IllegalStateException();
	        checkForComodification();
	
	        try {
	            MyArrayList.this.remove(lastRet);
	            cursor = lastRet;
	            lastRet = -1;
	            expectedModCount = modCount;
	        } catch (IndexOutOfBoundsException ex) {
	            throw new ConcurrentModificationException();
	        }
	    }
	
	    @Override
	    @SuppressWarnings("unchecked")
	    public void forEachRemaining(Consumer<? super E> consumer) {
	        Objects.requireNonNull(consumer);
	        final int size = MyArrayList.this.size;
	        int i = cursor;
	        if (i >= size) {
	            return;
	        }
	        final Object[] elementData = MyArrayList.this.a;
	        if (i >= elementData.length) {
	            throw new ConcurrentModificationException();
	        }
	        while (i != size && modCount == expectedModCount) {
	            consumer.accept((E) elementData[i++]);
	        }
	        // update once at end of iteration to reduce heap write traffic
	        cursor = i;
	        lastRet = i - 1;
	        checkForComodification();
	    }
	
	    final void checkForComodification() {
	        if (modCount != expectedModCount)
	            throw new ConcurrentModificationException();
	    }
	}
}