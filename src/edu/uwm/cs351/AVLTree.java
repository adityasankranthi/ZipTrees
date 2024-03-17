package edu.uwm.cs351;

public class AVLTree<T extends Comparable<T>> implements TreeInterface<T> {

	// TODO: Data structure

	private AVLNode<T> root;

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
