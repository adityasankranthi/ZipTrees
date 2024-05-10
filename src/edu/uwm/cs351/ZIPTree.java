package edu.uwm.cs351;

import java.util.Random;

public class ZIPTree<T extends Comparable<T>> implements TreeInterface<T> {

    private ZipNode<T> root;
    private Random randomGenerator; 
    
    private static class ZipNode<DataT> {
    	DataT key;
        ZipNode<DataT> left, right;
        int rank;

        ZipNode(DataT key) {
            this.key = key;
            this.rank =0; 
        }
        
    }
    
    public ZIPTree() {
        this.root = null;
        this.randomGenerator = new Random();
    }
    

    @Override
    public void insert(T key) {
    	
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        
        int rank = generateGeometricRank(); 
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
    
    public int generateGeometricRank() {
        // Geometric distribution with parameter p: P(X = k) = (1 - p)^(k - 1) * p
        double p = 0.5;
        return (int) Math.ceil(Math.log(1 - randomGenerator.nextDouble()) / Math.log(1 - p));
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
	    
	    ZipNode<T> left = cur.left;
	    ZipNode<T> right = cur.right;

	    if (left == null) {
	        cur = right;
	    } else if (right == null) {
	        cur = left;
	    } else if (left.rank >= right.rank) {
	        cur = left;
	    } else {
	        cur = right;
	    }

	    if (root.key.equals(key)) {
	        root = cur;
	    } else if (key.compareTo(prev.key) < 0) {
	        prev.left = cur;
	    } else {
	        prev.right = cur;
	    }
	    
	    while (left != null && right != null) {
	        if (left.rank >= right.rank) {
	            do {
	                prev = left;
	                left = left.right;
	            } while (left != null && left.rank >= right.rank);
	            prev.right = right;
	        } else {
	            do {
	                prev = right;
	                right = right.left;
	            } while (right != null && left.rank >= right.rank);
	            prev.left = left;
	        }
	    }
		
	}

	@Override
	public boolean search(T key) {
	    if (key == null) throw new IllegalArgumentException("Key cannot be null");
	    
	    ZipNode<T> current = root;
	    while (current != null) {
	        int cmp = key.compareTo(current.key);
	        if (cmp < 0) {
	            current = current.left; 
	        } else if (cmp > 0) {
	            current = current.right; 
	        } else {
	            return true;
	        }
	    }
	    return false;
	}

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getHeight() {
        return getHeightHelper(root);
    }

    private int getHeightHelper(ZipNode<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightHelper(node.left);
        int rightHeight = getHeightHelper(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public int getSize() {
        return getSizeHelper(root);
    }

    private int getSizeHelper(ZipNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSizeHelper(node.left) + getSizeHelper(node.right);
    }
}

