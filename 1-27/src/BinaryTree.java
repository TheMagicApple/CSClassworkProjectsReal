import java.awt.Graphics;
import java.util.ArrayList;

public class BinaryTree<E extends Comparable<E>>{
	private Node<E> root;
	private String s="";
	private ArrayList<Node<E>> list;
	public BinaryTree() {
		
	}
	public void add(E e) {
		add(new Node<E>(e),root);
	}
	private void add(Node<E> n,Node<E> current) {
		//passes++;
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
				Node<E> parent=current;
				Node<E> parentparent=parent.parent;
				Node<E> parentparentparent=null;
				if(parentparent!=null) {
					parentparentparent=parentparent.parent;
					System.out.println(n.data);
					System.out.println(parent.data);
					System.out.println(parentparent.data);
				}
				
				if(parentparent!=null && parentparent.left!=null && parent.left!=null && parentparent.right==null && parent.right==null) {
					rotateRight(parentparent);
					//System.out.println("ROTATE RIGHT"+n.data);
				}
				if(parentparent!=null && parentparent.right!=null && parent.left!=null && parentparent.left==null && parent.right==null) {
					n.right=parent; //2.left=1
					parent.left=null; //1.right=null
					parent.parent=n; //1.parent=2
					parentparent.right=n;
					n.parent=parentparent; //2.parent=3
					rotateLeft(parentparent); 
				}
				if(parentparentparent!=null) {
					System.out.println(parentparentparent.data);
				}
				/*
				if(!isBalanced() && parentparentparent!=null && parentparent!=null	 && parentparentparent.right!=null && parentparentparent.left!=null && parentparent.right!=null && parentparent.left!=null && parent.right==null && parent.left!=null) {
					Node<E> parentparentleft=parentparent.right;
					rotateRight(parentparentparent);
					parentparentparent.left=parentparentleft;
					System.out.println("HELLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLo");
				}
				if(!isBalanced() && parentparentparent!=null && parentparent!=null	 && parentparentparent.left!=null && parentparentparent.right!=null && parentparent.left!=null && parentparent.right!=null && parent.right==null && parent.left!=null) {
					Node<E> parentparentleft=parentparent.left;
					rotateLeft(parentparentparent);
					parentparentparent.right=parentparentleft;
					System.out.println("HELLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLo");
					/*
					System.out.println("node:"+n.data);
					Node<E> parentparentleft=parentparent.left;
					rotateLeft(parentparentparent);
					parentparentparent.right=parentparentleft;
					System.out.println(parentparentparent.left.data);
					System.out.println("HELLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLo");
					
				}
				*/
			
			}else {
				add(n,current.left);
			}
		}
		if(i>0) {
			if(current.right==null) {
				current.right=n;
				n.parent=current;
				Node<E> parent=current;
				Node<E> parentparent=current.parent;
				Node<E> parentparentparent=null;
				if(parentparent!=null) {
					parentparentparent=parentparent.parent;
					System.out.println(n.data);
					System.out.println(parent.data);
					System.out.println(parentparent.data);
				}
				if(parentparent!=null && parentparent.right!=null && parent.right!=null && parentparent.left==null && parent.left==null) {
					rotateLeft(parentparent);
					System.out.println("ROTATE LEFT");
				}
				
				if(parentparent!=null && parentparent.left!=null && parent.right!=null && parentparent.right==null && parent.left==null) {
					n.left=parent; //2.left=1
					parent.right=null; //1.right=null
					parent.parent=n; //1.parent=2
					parentparent.left=n;
					n.parent=parentparent; //2.parent=3
					rotateRight(parentparent); 
				}
				if(parentparentparent!=null) {
					System.out.println(parentparentparent.data);
				}
				/*
				if(!isBalanced() && parentparentparent!=null && parentparent!=null	 && parentparentparent.left!=null && parentparentparent.right!=null && parentparent.left!=null && parentparent.right!=null && parent.left==null && parent.right!=null) {
					Node<E> parentparentleft=parentparent.left;
					rotateLeft(parentparentparent);
					parentparentparent.right=parentparentleft;
					System.out.println("HELLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLo");
				}
				*/
			}else {
				add(n,current.right);
			}
		}
		
	}
	public void A1Left(Node<E> node) {
		
	}
	public boolean contains(E e) {
		return contains(e,root);
	}
	private boolean contains(E e,Node<E> node) {
		if(node==null) {
			return false;
		}
		if(node.data.compareTo(e)==0) {
			return true;
		}
		if(e.compareTo(node.data)>0) {
			return contains(e,node.right);
		}else {
			return contains(e,node.left);
		}
	}
	public String toString() {
		s="";
		return inOrderString(root);
	}
	public String toStringPreOrder() {
		s="";
		return preOrderString(root);
	}
	private String inOrderString(Node<E> node) {
		if(node!=null) {
			inOrderString(node.left);
			s+=node.data+" ";
			inOrderString(node.right);
		}	
		return s;
	}
	private String preOrderString(Node<E> node) {
		if(node!=null) {
			s+=node.data+" ";
			inOrderString(node.right);
			inOrderString(node.left);	
		}	
		return s;
	}
	public int getHeight() {
		return getHeight(root);
	}
	private int getHeight(Node<E> node) {
		if(node==null) {
			return -1;
		}
		int heightLeft=getHeight(node.left);
		int heightRight=getHeight(node.right);
		if(heightLeft>heightRight) {
			return heightLeft+1;
		}else {
			return heightRight+1;
		}
		//return (getHeight(node.getRight())>getHeight(node.getLeft())) ? getHeight(node.getRight())+1 : getHeight(node.getLeft())+1;
	}
	public int getLevel() {
		return getHeight(root)+1;
	}
	/*
	private int getHeight(Node<E> node) {
		if(node==null) {
			return -1;
		}
		return getHeight(node.data,root);
	}
	*/
	public int getHeight(E e) {
		return getHeight(getNode(e,root));
	}
	private Node<E> getNode(E e,Node<E> node){
		if(node==null) {
			return null;
		}
		if(node.data.compareTo(e)==0) {
			return node;
		}
		return e.compareTo(node.data)>0 ? getNode(e,node.right) : getNode(e,node.left);
	}
	public boolean isBalanced() {
		return isBalanced(root);
	}
	private boolean isBalanced(Node<E> node) {
		if(node==null) {
			return true;
		}
		if(Math.abs(getHeight(node.left)-getHeight(node.right))>1){
			return false;
		}
		if(node.left==null && node.right==null) {
			return true;
		}
		return isBalanced(node.left) && isBalanced(node.right);
		//return getHeight(node.left.data)-getHeight(node.right.data)<=1;
	}
	public void clear() {
		root=null;         
	}
	private ArrayList<Node<E>> toList(){
		list=new ArrayList<>();
		return toList(root);
	}
	private ArrayList<Node<E>> toList(Node<E> node){	
		if(node!=null) {
			toList(node.left);
			list.add(node);
			toList(node.right);
		}	
		return list;
	}
	public void drawMe(Graphics g) {
		int totalHeight=getHeight(root);
		ArrayList<Node<E>> a=toList();
		//System.out.println(a);
		int x=50;
		for(Node<E> n:a) {
			
			int height=getHeight(n);
			int down=totalHeight-height;
			g.drawString(n.data.toString(),x,(down+1)*50 );
			n.x=x;
			//System.out.println(x+" "+down*50);
			x+=600/list.size();
		}
		for(Node<E> n:a) {
			int height=getHeight(n);
			int down=totalHeight-height;
			Node<E> left=n.left;
			Node<E> right=n.right;
			if(left!=null) {
				int heightL=getHeight(left);
				int downL=totalHeight-heightL;
				g.drawLine(n.x, (down+1)*50, left.x, (downL+1)*50);
			}
			if(right!=null) {
				int heightL=getHeight(right);
				int downL=totalHeight-heightL;
				g.drawLine(n.x, (down+1)*50, right.x, (downL+1)*50);
			}
		}
	}	
	public void balance() {
		
		//list=new ArrayList<>();
		ArrayList<Node<E>> a=toList();
		//System.out.println(a);
		ArrayList<ArrayList<Node<E>>> split=new ArrayList<>();
		split.add(a);
		//System.out.println(split);
		clear();
		while(true) {
			ArrayList<ArrayList<Node<E>>> splitCopy=new ArrayList<>();
			for(int i=0;i<split.size();i++) {
				splitCopy.add(split.get(i));
			}
			//System.out.println("RUN"+split.get(0).size());
			split.clear();
			for(ArrayList<Node<E>> ar:splitCopy) {
				if(ar.size()!=0) {
					
				
				add(ar.get(ar.size()/2).data);
				ArrayList<Node<E>> firstHalf=new ArrayList<>();
				ArrayList<Node<E>> lastHalf=new ArrayList<>();
				for(int i=0;i<ar.size()/2;i++) {
					firstHalf.add(ar.get(i));
				}
				for(int i=ar.size()/2+1;i<ar.size();i++) {
					lastHalf.add(ar.get(i));
				}
				if(firstHalf.size()!=0) {
					split.add(firstHalf);
				}
				if(lastHalf.size()!=0) {
					split.add(lastHalf);
				}
				}
			}
			if(split.size()==0) {
				break;
			}
		}
		
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
	    		    		root.parent.right=root.right;
	    		    	}
	    				
	    			}else {
	    				
	    			
	    			if(root.right==null && root.left!=null) {
	    				root.parent.left=root.left;
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
	public void rotateRight(Node<E> node) {
		Node<E> top=node;
		Node<E> middle=node.left;
		Node<E> bottom=node.left.left;
		middle.parent=top.parent;
		if(top.parent==null) {
			root=middle;
		}else {
			top.parent.left=middle;
		}
		top.parent=middle;
		middle.right=top;
		top.left=null;
	}
	public void rotateLeft(Node<E> node) {
		Node<E> top=node;
		Node<E> middle=node.right;
		Node<E> bottom=node.right.right;
		middle.parent=top.parent;
		if(top.parent==null) {
			root=middle;
		}else {
			top.parent.right=middle;
		}
		middle.left=top;
		top.parent=middle;
		top.right=null;
		System.out.println(root.data);		 
		/*
		//top.parent=middle;
		top.right=middle.left;
		middle.left=top;
		middle.right=top.right;
		*/
		
		//top.right=null;
	}
}