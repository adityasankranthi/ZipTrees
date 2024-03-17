package edu.uwm.cs351;

public class AVLTree<T extends Comparable<T>> implements TreeInterface<T> {
	
	// TODO: Data structure
	
	private AVLNode<T> root;
	
	private static class AVLNode<DataT> {
		DataT key;
	    AVLNode<DataT> left, right;
	    int height;

	    AVLNode(DataT key) {
	        this(key,null,null);
	    }
	    AVLNode(DataT key,AVLNode<DataT> l, AVLNode<DataT> r)
	    {
	    	this.left=l;
	    	this.right=r;
	    	height=1;
	    	
	    }
	}
		
	@Override
	public void insert(T key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean search(T key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
