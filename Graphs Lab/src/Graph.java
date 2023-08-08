import java.util.Iterator;

public class Graph<E> {
	public MyHashMap<E,MyHashSet<E>> graph=new MyHashMap<>();
	public void add(E node) {
		graph.put(node, new MyHashSet<>());
	}
	public void addEdge(E node1,E node2) {
		Iterator<E> i=graph.keySet().toIterator();
		E friend1=null;
		E friend2=null;
		while(i.hasNext()) {
			E friend=i.next();
			if(friend!=null) {
				if(friend.hashCode()==node1.hashCode()) {
					friend1=friend;
				}
				if(friend.hashCode()==node2.hashCode()) {
					friend2=friend;
				}
			}
			
		}
		graph.get(friend1).add(friend2);
		graph.get(friend2).add(friend1);
	}
	public void remove(E node) {
		E[] keys=(E[]) graph.keySet().toArray();
		for(int i=0;i<keys.length;i++) {
			if(keys[i]!=null) {
				if(keys[i].hashCode()==(node.hashCode())) {
					graph.remove(keys[i]);
				}else {
					if(graph.get(keys[i]).contains(node)) {
						graph.get(keys[i]).remove(node);
					}
				}
			}
			
		}
	}
	public boolean dfs(E start,E end) {
		E current=start;
		MyHashSet<E> visited=new MyHashSet<>();
		DLList<E> stack=new DLList<>();
		stack.add(new Node<E>(current));
		while(!stack.empty()) {
			current=stack.poll();
			if(current.equals(end)) {
				return true;
			}
			if(!visited.contains(current)) {
				visited.add(current);
				Iterator<E> i=graph.get(current).toIterator();
				while(i.hasNext()) {
					E e=i.next();
					if(e!=null && !visited.contains(e)) {
						stack.add(new Node<E>(e));
					}
				}
					
				
			}
		}
		return false;
		
	}
	public Iterator<E> iterator(){
		return graph.keySet().toIterator();
	}
	public String toString() {
		String s="";
		Iterator<E> i=graph.keySet().toIterator();
		
		while(i.hasNext() ) {
			E key=i.next();
			if(key!=null) {
				//.out.println(key);
				s+=key+": "+graph.get(key)+"\n";
				//System.out.println(graph.get(key));
			}
			
		}
		/*
		for(E key:graph.keySet()) {
			s+=key+": "+graph.get(key)+"\n";
		}
		*/
		return s;
	}
}
