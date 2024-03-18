package edu.uwm.cs351;

/**
 * An AVL Tree implementation.
 * @param <T> The type of elements stored in the tree, must implement Comparable.
 */

public class AVLTree<T extends Comparable<T>> implements TreeInterface<T> {

	//Data structure
	private AVLNode<T> root;
    
	/**
     * AVLNode class represents a node in the AVL tree.
     * @param <DataT> The type of data stored in the node.
     */
	private static class AVLNode<DataT> {
		DataT key;
		AVLNode<DataT> left, right;
		int height;

		AVLNode(DataT key) {
			this(key, null, null);
		}

		AVLNode(DataT key, AVLNode<DataT> l, AVLNode<DataT> r) {
			this.left = l;
			this.right = r;
			height = 1;
			this.key=key;

		}
	}

	@Override
    public void insert(T key) {
		if (key == null) {
	        throw new IllegalArgumentException("Key cannot be null");
	    }
        root = insert(root, key);
    }

    private AVLNode<T> insert(AVLNode<T> node, T key) {
        if (node == null) {
            return new AVLNode<>(key);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key);
        } else if (cmp > 0) {
            node.right = insert(node.right, key);
        }else {
            node.key = key; 
        }

    
        node.height = 1 + Math.max(height(node.left), height(node.right));

       
        int balance = getBalance(node);

        //  4 cases

        // Left Left Case
        if (balance > 1 && key.compareTo(node.left.key) < 0) {
            return rotateRight(node);
        }

        // Right Right Case
        if (balance < -1 && key.compareTo(node.right.key) > 0) {
            return rotateLeft(node);
        }

        // Left Right Case
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left Case
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    private int height(AVLNode<T> node) {
        return node == null ? 0 : node.height;
    }
    
    private int getBalance(AVLNode<T> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private AVLNode<T> rotateRight(AVLNode<T> y) {
        AVLNode<T> x = y.left;
        AVLNode<T> T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> x) {
        AVLNode<T> y = x.right;
        AVLNode<T> T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }


	@Override
	public void delete(T key) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean search(T key) {
		// TODO Auto-generated method stub
		return search(root, key);
	}

	private boolean search(AVLNode<T> node, T key) {
		if (node == null) {
			return false;
		}
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			return true;
		} else if (cmp < 0) {
			return search(node.left, key);
		} else {
			return search(node.right, key);
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root == null;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return root == null ? 0 : root.height;
    }

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return getSize(root);
	}
	int count=0;
	private int getSize(AVLNode<T> node) {
	    if (node == null) {
	        return 0;
	    }
	    return 1 + getSize(node.left) + getSize(node.right);
	}

}
