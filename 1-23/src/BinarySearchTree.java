import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>>  {
	Node<E> root;
	String s;
	public void add(E e) {
		add(new Node<E>(e),root);
	}
	private void add(Node<E> n,Node<E> current) {
		if(root==null) {
			root=n;
			//System.out.println(root);
			return;
		}
		int i=n.data.compareTo(current.data);
		if(i<0) {
			if(current.left==null) {
				current.left=n;
				n.parent=current;
			}else {
				add(n,current.left);
			}
		}
		if(i>0) {
			if(current.right==null) {
				current.right=n;
				n.parent=current;
			}else {
				add(n,current.right);
			}
		}
	}
	public String toString() {
		s="";
		inOrderString(root);
		return s;
	}
	public void remove(E e) {
		remove(e,root,false,null);
	}
	private void remove(E e,Node<E> root,boolean ihatebinarytrees,E ref) {
    	if(root.data.compareTo(this.root.data)==0 && root.left==null && root.right==null) {
    		this.root=null;
    		//System.out.println(root.data);
    		return;
    	}
    	if(ihatebinarytrees) {
    		if(root.left==null) {
    			//this is the lowest node to the right
    			if(root.right==null) {
    				//this node is a leaf
    				Node<E> ultimateParent=root;
    				while(ultimateParent.data.compareTo(ref)!=0) {
    					ultimateParent=ultimateParent.parent;
    				}
    				ultimateParent.data=root.data;
    				if(root.parent.left.data.compareTo(root.data)==0) {
	    				root.parent.left=null;
	    			}else {
	    				root.parent.right=null;
	    			}
    			}else {
    				root.parent.left=root.right;
    			}
    		}else {
    			remove(e,root.left,true,ref);
    		}
    	}else {
	    	if(root.data.compareTo(e)==0) {
	    		if(root.left==null && root.right==null) {
	    			
	    			if(root.parent.left.data.compareTo(root.data)==0) {
	    				root.parent.left=null;
	    			}else {
	    				root.parent.right=null;
	    			}
	    		}else {
	    			if(root.left==null && root.right!=null) {
	    				if(root.data.compareTo(this.root.data)==0) {
	    					Node<E> n=root.right;
	    					//System.out.println(n.data);
	    					this.root=null;
	    					this.root=n;
	    					//System.out.println(root.data);
	    					
	    		    	}else {
	    		    		root.parent.left=root.right;
	    		    	}
	    				
	    			}else {
	    				
	    			
	    			if(root.right==null && root.left!=null) {
	    				root.parent.right=root.left;
	    			}
	    			if(root.right!=null && root.left!=null) {
	    				remove(e,root.right,true,root.data);
	    			}
	    			}
	    		}
	    	}else {
	    		if(root.data.compareTo(e)<0) {
	    			remove(e,root.right,false,null);
	    		}else {
	    			remove(e,root.left,false,null);
	    		}
	    	}
    	}
    }
    /*
	private void inOrderString(Node<E> n) {
		if(n!=null) {
			inOrderString(n.left);
			s+=n.data+" ";
			inOrderString(n.right);
		}
	}
	*/
	
	  private void inOrderString(Node<E> n){
	  		Stack<Node<E>> stack=new Stack<>();
	  		stack.add(n);
	  		Node<E> current=n;
	  		while(!stack.isEmpty()) {
	  			current=stack.pop();
	  			if(current!=null) {
	  				s+=current.data+" ";
	  				Node<E>[] neighbors=new Node[] {current.right,current.left};
		  			for(Node<E> neighbor:neighbors) {
		  				if(neighbor!=null) {
		  					stack.add(neighbor);
		  				}
		  			}
	  			}
	  		}
	  }
	 
}
