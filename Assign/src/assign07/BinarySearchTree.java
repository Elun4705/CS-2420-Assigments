package assign07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.io.TempDir;

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	
	private BinaryNode<Type> root = null;
	private Type temp = root.data;
	
	@SuppressWarnings("hiding")
	public class BinaryNode<Type> {

		private Type data;

		private BinaryNode<Type> leftChild;

		private BinaryNode<Type> rightChild;

		public BinaryNode(Type data, BinaryNode<Type> leftChild, BinaryNode<Type> rightChild) {
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		public BinaryNode(Type data) {
			this(data, null, null);
		}
		
		public Type getData() {
			return data;
		}

		/**
		 * @param data - the node data to be set
		 */
		public void setData(Type data) {
			this.data = data;
		}

		/**
		 * @return reference to the left child node
		 */
		public BinaryNode<Type> getLeftChild() {
			return leftChild;
		}

		/**
		 * @param leftChild - reference of the left child node to be set
		 */
		public void setLeftChild(BinaryNode<Type> leftChild) {
			this.leftChild = leftChild;
		}

		/**
		 * @return reference to the right child node
		 */
		public BinaryNode<Type> getRightChild() {
			return rightChild;
		}

		/**
		 * @param rightChild - reference of the right child node to be set
		 */
		public void setRightChild(BinaryNode<Type> rightChild) {
			this.rightChild = rightChild;
		}

		/**
		 * @return reference to the leftmost node in the binary tree rooted at this node
		 */
		public BinaryNode<Type> getLeftmostNode() {
			if (leftChild == null)
				return this;
			
			BinaryNode<Type> temp = this;
			while (temp.getLeftChild() != null)
				temp = temp.getLeftChild();
			return temp;
		}

		/**
		 * @return reference to the rightmost node in the binary tree rooted at this node
		 */
		public BinaryNode<Type> getRightmostNode() {
			if (rightChild == null)
				return this;
			
			BinaryNode<Type> temp = this;
			while (temp.getRightChild() != null)
				temp = temp.getRightChild();
			return temp;
			}

		/**
		 * @return the height of the binary tree rooted at this node
		 * 
		 * The height of a tree is the length of the longest path to a leaf
		 * node. Consider a tree with a single node to have a height of zero.
		 */
		public int height() {
			if (leftChild == null & rightChild == null)
				return 0;
			
			int leftCount = 0;
			int rightCount = 0;
			
			if (leftChild != null)
				leftCount = leftChild.height();
			

			if (rightChild != null)
				rightCount = rightChild.height();
			
			return Math.max(leftCount, rightCount) + 1;
		}
	}

	@Override
	public boolean add(Type item) {

//		if (this.contains(item)) {
//			return false;
//		}
//		
//		if (item.compareTo(temp) < 0) {
//			setLeftChild(item);
//			return true;
//		}
//		
//		if (item.compareTo(temp) > 0) {
//			this.leftChild = item;
//			return true;
//		}
		
	}

	@Override
	public boolean addAll(Collection<? extends Type> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Type item) {
		
//		if (item.compareTo(this.temp) == 0) {
//			return true;
//		}
//	
//		if (item.compareTo(temp) < 0) {
//			this.temp = root.rightChild.getData();
//			contains(item);
//		}
//		
//		if (item.compareTo(temp) > 0) {
//			this.temp = root.leftChild.getData();
//			contains(item);
//		}
		
		
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<? extends Type> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type first() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type last() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Type item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Type> toArrayList() {
		// TODO Auto-generated method stub
		return null;
	}

}
