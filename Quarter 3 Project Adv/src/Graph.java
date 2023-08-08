

public class Graph<E> {
	public static int distance;
	MyArrayList<E> path;
	MyHashMap<E,MyHashSet<Pair<E,Pair<Integer,Integer>>>> graph=new MyHashMap<>();
	public void add(E node) {
		graph.put(node, new MyHashSet<>());
	}
	public MyArrayList<E> getPath(){
		return path;
	}
	public void ae(E node1,E node2,Pair<Integer,Integer> pair) {
		graph.get(node1).add(new Pair<>(node2,pair));
		graph.get(node2).add(new Pair<>(node1,pair));
	}
	public void remove(E node) {
		MyArrayList<E> keys=graph.keySet().toArray();
		for(int i=0;i<keys.size();i++) {
			if(keys.get(i).equals(node)) {
				graph.remove(keys.get(i));
			}else {
				if(graph.get(keys.get(i)).contains(node)) {
					graph.get(keys.get(i)).remove(node);
				}
			}
		}
	}
	public MyHashSet<Pair<E,Pair<Integer,Integer>>> get(E node){
		return graph.get(node);
	}
	public int getWeight(E node1,E node2) {
		MyHashSet<Pair<E, Pair<Integer, Integer>>> m=graph.get(node1);
		for(int i=0;i<m.size();i++) {
			Pair<E,Pair<Integer,Integer>> edge=m.toArray().get(i);
			if(edge.a.equals(node2)) {
				return (int) edge.b.a;
			}
		}
		return -1;
	}
	public MyArrayList<Pair<Pair<E, E>, Integer>> shortestPath(E node1,E node2) {
		MyHashMap<E,Pair<Integer,E>> distances=djikstra(node1);
		path=new MyArrayList<>();
		E n=distances.get(node2).b;
		MyArrayList<Integer> colors=new MyArrayList<>();
		E oldN=null;
		E oldoldN=null;
		while(n!=null) {
			path.add(n);
			oldN=n;
			if(oldoldN==null)oldoldN=n;
			//System.out.println("OLDN: "+oldN);
			n=distances.get(n).b;
			MyHashSet<Pair<E,Pair<Integer,Integer>>> pp=graph.get(oldN);
			for(int i=0;i<pp.size();i++) {
				Pair<E,Pair<Integer,Integer>> p=pp.toArray().get(i);
				if(p!=null && p.a.equals(n)) {
					colors.add(p.b.b);
				}
			}
		}
		//Collections.reverse(path);
		//Collections.reverse(colors);
		path.reverse();
		colors.reverse();
		path.add(node2);
		//System.out.println(oldoldN+" "+node2);
		MyHashSet<Pair<E,Pair<Integer,Integer>>> pp=graph.get(oldoldN);
		for(int i=0;i<pp.size();i++) {
			Pair<E,Pair<Integer,Integer>> p=pp.toArray().get(i);
			if(p!=null && p.a.equals(node2)) {
				colors.add(p.b.b);
			}
		}
		//System.out.println(path);
		//System.out.println(colors);
		MyArrayList<Pair<Pair<E,E>,Integer>> directions=new MyArrayList<>();
		int currentColor=0;
		E start=null;
		E end=null;
		for(int i=0;i<path.size();i++) {
			if(i==0) {
				currentColor=colors.get(0);
				start=path.get(i);
			}
			if(i==path.size()-1 || colors.get(i)!=currentColor) {
				end=path.get(i);
				directions.add(new Pair<Pair<E,E>,Integer>(new Pair<E,E>(start,end),currentColor));
				if(i<path.size()-1) {
					start=path.get(i);
					currentColor=colors.get(i);
				}
				
			}
		}
		//System.out.println(directions);
		distance=distances.get(node2).a;
		return directions;
		
	}
	public MyHashMap<E,Pair<Integer,E>> djikstra(E start) {
		MyHashMap<E,Pair<Integer,E>> distances=new MyHashMap<>();
		MyArrayList<E> keys=graph.keySet().toArray();
		for(int i=0;i<keys.size();i++) {
			E key=keys.get(i);
			if(key.equals(start)) {
				distances.put(key, new Pair<>(0,null));
			}else {
				distances.put(key, new Pair<>(999999999,null));
			}
		}
		MyHashSet<E> visited=new MyHashSet<>();
		while(true) {
			E goodNode=null;
			int goodDistance=999999999;
			MyArrayList<E> nodes=graph.keySet().toArray();
			for(int j=0;j<nodes.size();j++) {
				E node=nodes.get(j);
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
			MyHashSet<Pair<E,Pair<Integer,Integer>>> ns=graph.get(goodNode);
			ns.toArray();
			for(int k=0;k<ns.size();k++) {
			//	System.out.println(ns.toArray());
				Pair<E,Pair<Integer,Integer>> n=ns.toArray().get(k);
				if(distances.get(goodNode).a+getWeight(goodNode,n.a)<distances.get(n.a).a) {
					distances.put(n.a, new Pair<>(distances.get(goodNode).a+getWeight(goodNode,n.a),goodNode));
				}	
			}
		}
	}
	
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
	public int hashCode() {
		return a.hashCode()+b.hashCode();
	}
}
