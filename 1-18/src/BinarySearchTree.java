public class BinarySearchTree<E extends Comparable<E>>{
    private Node<E> root;
    private String s="";
    public BinarySearchTree(){
        root = null;
    }

    public void add(E obj){
        if(root == null){
            Node<E> node = new Node<>(obj);
            root=node;
        }
        else{
            add(obj, root);
        }
    }

    private Node<E> add(E obj, Node<E> node){
        if(node == null){
            node = new Node<E>(obj);
            return node;
        }
        else if(obj.compareTo(node.value) < 0){
            node.left = add(obj, node.left);
        }
        else if(obj.compareTo(node.value) > 0){
            node.right = add(obj, node.right);
        }
        return node;
    }
    public String toString() {
    	s="";
    	if(root!=null) {
    		//System.out.println(root.value);
        	printInOrder(root);
        	return s;
    	}else {
    		return "";
    	}
    	
    }
    private void printInOrder(Node<E> n) {
		
    	if(n!=null) {
			printInOrder(n.left);
			s+=n.value+" ";
			printInOrder(n.right);
		}
		
	}
    public void remove(E e) {
    	remove(e,root,null,false,null);
    }
    private void remove(E e,Node<E> root,Node<E> parent,boolean ihatebinarytrees,Node<E> ultimateParent) {
    	if(root.value.compareTo(this.root.value)==0 && root.left==null && root.right==null) {
    		this.root=null;
    		//System.out.println(root.value);
    		return;
    	}
    	if(ihatebinarytrees) {
    		if(root.left==null) {
    			//this is the lowest node to the right
    			if(root.right==null) {
    				//this node is a leaf
    				ultimateParent.value=root.value;
    				if(parent.left.value.compareTo(root.value)==0) {
	    				parent.left=null;
	    			}else {
	    				parent.right=null;
	    			}
    			}else {
    				parent.left=root.right;
    			}
    		}else {
    			remove(e,root.left,root,true,ultimateParent);
    		}
    	}else {
	    	if(root.value.compareTo(e)==0) {
	    		if(root.left==null && root.right==null) {
	    			
	    			if(parent.left.value.compareTo(root.value)==0) {
	    				parent.left=null;
	    			}else {
	    				parent.right=null;
	    			}
	    		}else {
	    			if(root.left==null && root.right!=null) {
	    				if(root.value.compareTo(this.root.value)==0) {
	    					Node<E> n=root.right;
	    					//System.out.println(n.value);
	    					this.root=null;
	    					this.root=n;
	    					//System.out.println(root.value);
	    					
	    		    	}else {
	    		    		parent.left=root.right;
	    		    	}
	    				
	    			}else {
	    				
	    			
	    			if(root.right==null && root.left!=null) {
	    				parent.right=root.left;
	    			}
	    			if(root.right!=null && root.left!=null) {
	    				remove(e,root.right,root,true,root);
	    			}
	    			}
	    		}
	    	}else {
	    		if(root.value.compareTo(e)<0) {
	    			remove(e,root.right,root,false,null);
	    		}else {
	    			remove(e,root.left,root,false,null);
	    		}
	    	}
    	}
    }
    

    public String toStringPreOrder(){
        s = "";
        toStringPreOrder(root);
        return s;
    }
    private void toStringPreOrder(Node<E> n){
        if(n!= null){
            s+=(n.value+" ");
            toStringPreOrder(n.left);
            toStringPreOrder(n.right);
        }
        return;
    }
    public boolean contains(E obj){
        return contains(obj,root);
    }
    private boolean contains(E obj, Node<E> node){
       //System.out.println(node.value);
    	if(node == null){
            return false;
        }
        else if(obj.compareTo(node.value) > 0){
            //System.out.println("obj is greater than node");
        	return contains(obj, node.right);
        }
        else if(obj.compareTo(node.value) < 0){
        	//System.out.println("obj is less than node");
        	return contains(obj, node.left);
        }
        else{
           //System.out.println("obj is equal to node");
        	return true;
        }
    	
    	
      
    		
        
    }
    public void clear(){
        root = null;
    }






}
