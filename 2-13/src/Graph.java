import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph<E> {
	HashMap<E,HashSet<E>> graph=new HashMap<>();
	public void add(E node) {
		graph.put(node, new HashSet<>());
	}
	public void addEdge(E node1,E node2) {
		graph.get(node1).add(node2);
		graph.get(node2).add(node1);
	}
	public void remove(E node) {
		E[] keys=(E[]) graph.keySet().toArray();
		for(int i=0;i<keys.length;i++) {
			if(keys[i].equals(node)) {
				graph.remove(keys[i]);
			}else {
				if(graph.get(keys[i]).contains(node)) {
					graph.get(keys[i]).remove(node);
				}
			}
		}
	}
	public String toString() {
		String s="";
		for(E key:graph.keySet()) {
			s+=key+": "+graph.get(key)+"\n";
		}
		return s;
	}
	public E bfs(E node,E start) {
		Queue<E> queue=new LinkedList<>();
		HashSet<E> visited=new HashSet<>();
		E current=start;
		queue.add(current);
		while(!queue.isEmpty()) {
			//System.out.println("visited:"+visited);
			
			current=queue.poll();
			//System.out.println("current:"+current);
			if(!visited.contains(current)) {
				System.out.println(current);
				if(current.equals(node)) {
					//System.out.println("RETURN");
					return current;
				}
				visited.add(current);
				for(E neighbor:graph.get(current)) {
					if(!visited.contains(neighbor)) {
						//System.out.println("neighbor:"+neighbor);
						queue.add(neighbor);
					}
				}
			}
			
		}
		return null;
	}
	public E dfs(E node,E start) {
		Stack<E> stack=new Stack<>();
		HashSet<E> visited=new HashSet<>();
		E current=start;
		stack.add(current);
		while(!stack.isEmpty()) {
			current=stack.pop();
			if(!visited.contains(current)) {
				System.out.println(current);
				if(current.equals(node)) {
					return current;
				}
				visited.add(current);
				for(E neighbor:graph.get(current)) {
					if(!visited.contains(neighbor)) {
						stack.add(neighbor);
					}
				}
			}
			
		}
		return null;
	}
	public void displayAll(){
		for(E user:graph.keySet()) {
			System.out.println(user);
		}
	}
	public void displayConnections(E you) {
		for(E connection:graph.get(you)) {
			System.out.print(connection+" ");
		}
		System.out.println();
	}
	public void searchAndConnect(E you,E them) {
		Stack<E> stack=new Stack<>();
		HashSet<E> visited=new HashSet<>();
		E current=you;
		stack.add(current);
		while(!stack.isEmpty()) {
			current=stack.pop();
			if(!visited.contains(current)) {
				System.out.println(current);
				if(current.equals(them)) {
					addEdge(you,them);
				}
				visited.add(current);
				for(E neighbor:graph.get(current)) {
					if(!visited.contains(neighbor)) {
						stack.add(neighbor);
					}
				}
			}
			
		}
	}
}
