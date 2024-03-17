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

