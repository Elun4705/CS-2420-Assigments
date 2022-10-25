package assign07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.io.TempDir;

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {

	private BinaryNode<Type> root = null;
	private int size = 0;

	@SuppressWarnings("hiding")
	public class BinaryNode<Type> {

		private Type data;

		private BinaryNode<Type> leftChild;

		private BinaryNode<Type> rightChild;
		
		private BinaryNode<Type> parent;

		public BinaryNode(Type data, BinaryNode<Type> leftChild, BinaryNode<Type> rightChild, BinaryNode<Type> parent) {
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.parent = parent;
		}

		public BinaryNode(Type data) {
			this(data, null, null, null);
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
		
		public BinaryNode<Type> getParent() {
			return parent;
		}
		
		public void setParent(BinaryNode<Type> parent) {
			this.parent = parent;
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
		 * @return reference to the rightmost node in the binary tree rooted at this
		 *         node
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
		 *         The height of a tree is the length of the longest path to a leaf
		 *         node. Consider a tree with a single node to have a height of zero.
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

		if (this.contains(item)) {
			return false;
		}

		else {

			BinaryNode<Type> newNode = new BinaryNode<Type>(item);

			if (root == null) {
				root = newNode;
				size++;
				return true;
			}

			BinaryNode<Type> temp = root;
			Boolean added = false;

			while (added = false) {
				if (item.compareTo(temp.data) > 0) {
					if (temp.getRightChild() != null) {
						temp = temp.rightChild;
					} else {
						temp.setRightChild(newNode);
						newNode.setParent(temp);
						added = true;
					}
				}
				if (item.compareTo(temp.data) < 0) {
					if (temp.getLeftChild() != null) {
						temp = temp.leftChild;
					} else {
						temp.setLeftChild(newNode);
						newNode.setParent(temp);
						added = true;
					}
				}
			}
			
			size++;
			return added;

		}

	}

	@Override
	public boolean addAll(Collection<? extends Type> items) {

		boolean added = false;

		for (Type item : items) {
			if (this.contains(item) == false) {
				this.add(item);
				added = true;
			}
		}

		return added;
	}

	@Override
	public void clear() {

		this.root = null;

	}

	@Override
	public boolean contains(Type item) {

		if (root == null) {
			return false;
		}

		BinaryNode<Type> temp = root;
		Boolean found = false;

		while (found = false) {
			if (item.compareTo(temp.data) == 0) {
				found = true;
			} else {
				if (item.compareTo(temp.data) > 0) {
					if (temp.getRightChild() != null) {
						temp = temp.rightChild;
					} else {
						return false;
					}
				}
				if (item.compareTo(temp.data) < 0) {
					if (temp.getLeftChild() != null) {
						temp = temp.leftChild;
					} else {
						return false;
					}
				}
			}
		}

		return found;

		// travel through list, if can't find, return false
	}

	@Override
	public boolean containsAll(Collection<? extends Type> items) {

		Boolean containsall = true;

		for (Type item : items) {
			if (this.contains(item) == false);
			containsall = false;
		}

		return containsall;

	}

	@Override
	public Type first() throws NoSuchElementException {

		return root.data;

	}

	@Override
	public boolean isEmpty() {
		return (root.data == null);
	}

	@Override
	public Type last() throws NoSuchElementException {

		if (root == null) {
			throw new NoSuchElementException();
		}
		
		return root.getRightmostNode().getData();
		
	}

	@Override
	public boolean remove(Type item) {
		if (root == null) {
			return false;
		}
		
		if(this.contains(item) == false) {
			return false;
		}

		BinaryNode<Type> temp = root;
		Boolean removed = false;

		while (removed = false) {
			if (item.compareTo(temp.data) == 0) {
				if(temp.getLeftChild() == null && temp.getRightChild() == null) {
					temp = null;
					removed = true;
				}
				
				if(temp.getLeftChild() == null && temp.getRightChild() != null) {
					if(temp.getData().compareTo(temp.getParent().getLeftChild().getData()) == 0) {
						temp.getParent().setLeftChild(temp.getRightChild());
						removed = true;
					}
					if(temp.getData().compareTo(temp.getParent().getRightChild().getData()) == 0) {
						temp.getParent().setRightChild(temp.getRightChild());
						removed = true;
					}
				}
				
				if(temp.getLeftChild() != null && temp.getRightChild() == null) {
					if(temp.getData().compareTo(temp.getParent().getLeftChild().getData()) == 0) {
						temp.getParent().setLeftChild(temp.getLeftChild());
						removed = true;
					}
					if(temp.getData().compareTo(temp.getParent().getRightChild().getData()) == 0) {
						temp.getParent().setRightChild(temp.getLeftChild());
						removed = true;
					}
				}
				
				if(temp.getLeftChild() != null && temp.getRightChild() != null) {
					
				}
				
			} else {
				if (item.compareTo(temp.data) > 0) {
					if (temp.getRightChild() != null) {
						temp = temp.rightChild;
					}
				}
				if (item.compareTo(temp.data) < 0) {
					if (temp.getLeftChild() != null) {
						temp = temp.leftChild;
					}
				}
			}
		}

		return removed;
	}

	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ArrayList<Type> toArrayList() {
		// TODO Auto-generated method stub
		return null;
	}

}
