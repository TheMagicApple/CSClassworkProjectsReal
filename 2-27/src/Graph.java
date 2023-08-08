import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph<E> {
	HashMap<E,HashSet<Pair<E,Integer>>> graph=new HashMap<>();
	public void add(E node) {
		graph.put(node, new HashSet<>());
	}
	public void addEdge(E node1,E node2,int weight) {
		graph.get(node1).add(new Pair<>(node2,weight));
		graph.get(node2).add(new Pair<>(node1,weight));
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
	public int getWeight(E node1,E node2) {
		for(Pair edge:graph.get(node1)) {
			if(edge.a.equals(node2)) {
				return (int) edge.b;
			}
		}
		return -1;
	}
	public void shortestPath(E node1,E node2) {
		HashMap<E,Pair<Integer,E>> distances=djikstra(node1);
		ArrayList<E> path=new ArrayList<>();
		E n=distances.get(node2).b;
		while(n!=null) {
			path.add(n);
			n=distances.get(n).b;
		}
		Collections.reverse(path);
		path.add(node2);
		System.out.println(path);
		System.out.println(distances.get(node2).a);
	}
	public HashMap<E,Pair<Integer,E>> djikstra(E start) {
		HashMap<E,Pair<Integer,E>> distances=new HashMap<>();
		for(E key:graph.keySet()) {
			if(key.equals(start)) {
				distances.put(key, new Pair<>(0,null));
			}else {
				distances.put(key, new Pair<>(999999999,null));
			}
		}
		HashSet<E> visited=new HashSet<>();
		while(true) {
			E goodNode=null;
			int goodDistance=999999999;
			for(E node:graph.keySet()) {
				if(!visited.contains(node)) {
					if(distances.get(node).a<goodDistance) {
						goodDistance=distances.get(node).a;
						goodNode=node;
					}
				}
			}
			if(goodNode==null) {
				return distances;
			}else {
				visited.add(goodNode);
			}
			for(Pair<E,Integer> node:graph.get(goodNode)) {
				if(distances.get(goodNode).a+getWeight(goodNode,node.a)<distances.get(node.a).a) {
					distances.put(node.a, new Pair<>(distances.get(goodNode).a+getWeight(goodNode,node.a),goodNode));
				}	
			}
		}
	}
	/*
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
	*/
}
class Pair<A,B>{
	public A a;
	public B b;
	public Pair(A a,B b) {
		this.a=a;
		this.b=b;
	}
	public String toString(){
		return a+":"+b;
	}
}
