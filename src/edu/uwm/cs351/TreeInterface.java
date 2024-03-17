package edu.uwm.cs351;

public interface TreeInterface<T> {
	
	// Method to insert a new node with the given key
    void insert(T key);

    // Method to delete a node with the given key
    void delete(T key);

    // Method to search for a node with the given key
    boolean search(T key);

    // Method to check if the tree is empty
    boolean isEmpty();

    // Method to get the height of the tree
    int getHeight();

    // Method to get the size (number of nodes) of the tree
    int getSize();

}
