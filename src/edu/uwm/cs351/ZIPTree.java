package edu.uwm.cs351;

public class ZIPTree<T extends Comparable<T>> implements TreeInterface<T> {

    private ZipNode<T> root;
    
    private static class ZipNode<DataT> {
    	DataT key;
        ZipNode<DataT> left, right;
        int rank;

        ZipNode(DataT key) {
            this.key = key;
            this.rank =0; 
        }
        
    }

    @Override
    public void insert(T key) {
        int rank = (int) (Math.random() * Integer.MAX_VALUE); // Generate random rank
        ZipNode<T> newNode = new ZipNode<>(key);
        newNode.rank = rank;
        
        if (root == null) { 
            root = newNode;
            return;
        }
        
        ZipNode<T> cur = root;
        ZipNode<T> prev = null;
        
        while (cur != null && (rank < cur.rank || (rank == cur.rank && key.compareTo(cur.key) > 0))) {
            prev = cur;
            if (key.compareTo(cur.key) < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        
        if (cur == root) {
            root = newNode;
        } else if (key.compareTo(prev.key) < 0) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }
        
        if (cur == null) {
            newNode.left = newNode.right = null;
            return;
        }
        
        if (key.compareTo(cur.key) < 0) {
            newNode.right = cur;
        } else {
            newNode.left = cur;
        }
        
        prev = newNode;
        while (cur != null) {
            ZipNode<T> fix = prev;
            if (cur.key.compareTo(key) < 0) {
                while (cur != null && cur.key.compareTo(key) < 0) {
                    prev = cur;
                    cur = cur.right;
                }
            } else {
                while (cur != null && cur.key.compareTo(key) > 0) {
                    prev = cur;
                    cur = cur.left;
                }
            }
            if (fix.key.compareTo(key) > 0 || (fix == newNode && prev.key.compareTo(key) > 0)) {
                fix.left = cur;
            } else {
                fix.right = cur;
            }
        }
    }


	@Override
	public void delete(T key) {
		if (root == null) return;
	    ZipNode<T> cur = root;
	    ZipNode<T> prev = null;
	    while (!cur.key.equals(key)) {
	        prev = cur;
	        if (key.compareTo(cur.key) < 0) {
	            cur = cur.left;
	        } else {
	            cur = cur.right;
	        }
	        if (cur == null) return; 
	    }
		
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

