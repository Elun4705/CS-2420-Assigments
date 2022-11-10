package assign07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * A generic BinarySearchTree class
 * 
 * @author Emmanuel Luna and Andy Huo
 *
 * @param <Type>
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {

	private BinaryNode<Type> root = null;
	private int size = 0;

	/**
	 * A generic BinaryNode Class
	 * 
	 * @author Emmanuel Luna and Andy Huo
	 *
	 * @param <Type>
	 */
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

		/**
		 * @return reference to the parent node
		 */
		public BinaryNode<Type> getParent() {
			return parent;
		}

		/**
		 * @param parent - reference of the parent node to be set
		 */
		public void setParent(BinaryNode<Type> parent) {
			this.parent = parent;
		}

		/**
		 * Helper code for determining whether a node is the parent's left or right
		 * child
		 * 
		 * @return a negative integer if it's the left child, a positive integer if it's
		 *         the right
		 */
		public int getLeftOrRight() {
			if (this == this.getParent().getLeftChild()) {
				return -1;
			}
			if (this == this.getParent().getRightChild()) {
				return 1;
			}
			return 0;
		}

		/**
		 * Helper code for removing a node with no children
		 */
		public void removeNoChildren() {

			if (this.getLeftOrRight() > 0) {
				this.parent.setRightChild(null);
			}

			if (this.getLeftOrRight() < 0) {
				this.parent.setLeftChild(null);
			}

		}

		/**
		 * Helper code for removing a node with a left child
		 */
		public void removeHasLeftChild() {

			BinaryNode<Type> left = this.leftChild;
			BinaryNode<Type> thisParent = this.parent;

			if (this.getLeftOrRight() > 0) {
				thisParent.setRightChild(left);
				left.setParent(thisParent);
			}

			if (this.getLeftOrRight() < 0) {
				thisParent.setLeftChild(left);
				left.setParent(thisParent);
			}

		}

		/**
		 * Helper code for removing a node which has one right child
		 */
		public void removeHasRightChild() {

			BinaryNode<Type> right = this.rightChild;
			BinaryNode<Type> thisParent = this.parent;

			if (this.getLeftOrRight() > 0) {
				thisParent.setRightChild(right);
				right.setParent(thisParent);
			}

			if (this.getLeftOrRight() < 0) {
				thisParent.setLeftChild(right);
				right.setParent(thisParent);
			}

		}

		/**
		 * Helper code for removing a node which has two children
		 */
		public void removeHasTwoChildren() {

			BinaryNode<Type> successor = this.getSuccessor();
			BinaryNode<Type> successorParent = successor.getParent();
			BinaryNode<Type> thisParent = this.parent;
			BinaryNode<Type> successorRight = null;
			BinaryNode<Type> right = this.getRightChild();
			BinaryNode<Type> left = this.getLeftChild();

			if (successor.getRightChild() != null) {
				successorRight = successor.getRightChild();
			}

			if (this.getLeftOrRight() > 0) {
				thisParent.setRightChild(successor);
				successor.setParent(thisParent);

			}

			if (this.getLeftOrRight() < 0) {
				thisParent.setLeftChild(successor);
				successor.setParent(thisParent);
			}

			if (successorRight != null) {
				successorRight.setParent(successorParent);
				successorParent.setLeftChild(successorRight);
			} else {
				successorParent.setLeftChild(null);
			}

			successor.setLeftChild(left);
			left.setParent(successor);

			successor.setRightChild(right);
			right.setParent(successor);

		}

		/**
		 * HelperCode for removing the root of a BST with two children
		 * 
		 * @return the successor node
		 */
		public BinaryNode<Type> removeRootHasTwoChildren() {

			BinaryNode<Type> successor = this.getSuccessor();
			BinaryNode<Type> successorParent = successor.getParent();
			BinaryNode<Type> successorRight = null;
			BinaryNode<Type> right = this.getRightChild();
			BinaryNode<Type> left = this.getLeftChild();

			if (successor.getRightChild() != null) {
				successorRight = successor.getRightChild();
			}

			if (successorRight != null) {
				successorRight.setParent(successorParent);
				successorParent.setLeftChild(successorRight);
			} else {
				successorParent.setLeftChild(null);
			}

			successor.setLeftChild(left);
			left.setParent(successor);

			successor.setRightChild(right);
			right.setParent(successor);

			successor.setParent(null);

			return successor;
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
		 * @return reference to the successor node, the leftmost node in the tree rooted
		 *         at this node's right child
		 */
		public BinaryNode<Type> getSuccessor() {

			return this.getRightChild().getLeftmostNode();

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

	/**
	 * Add's the item to it's correct place in the BST
	 * 
	 * @param item - the item to be added
	 * @return whether the item has been added
	 */
	@Override
	public boolean add(Type item) {

		if (this.contains(item)) {
			return false;
		}

		BinaryNode<Type> newNode = new BinaryNode<Type>(item);

		if (root == null) {
			root = newNode;
			size++;
			return true;
		}

		BinaryNode<Type> temp = root;
		Boolean added = false;

		while (added == false) {
			if (item.compareTo(temp.data) > 0) {
				if (temp.getRightChild() == null) {
					temp.setRightChild(newNode);
					newNode.setParent(temp);
					size++;
					return true;
				} else {
					temp = temp.rightChild;
				}
			} else {
				if (temp.getLeftChild() == null) {
					temp.setLeftChild(newNode);
					newNode.setParent(temp);
					size++;
					return true;
				} else {
					temp = temp.leftChild;
				}
			}
		}

		size++;
		return added;

	}

	/**
	 * Adds all items within the collection that aren't already contained within the
	 * BST to the BST
	 * 
	 * @param items - a collection of items to be added
	 * @return true if even one item was added, false otherwise
	 */
	@Override
	public boolean addAll(Collection<? extends Type> items) {

		boolean added = false;

		for (Type item : items) {
			if (this.add(item)) {
				added = true;
			}
		}

		return added;
	}

	/**
	 * Clear's the BST
	 */
	@Override
	public void clear() {

		this.root = null;

	}

	/**
	 * Checks the BST to see if it contains the item
	 * 
	 * @param item - the item to be checked for
	 * @return whether the BST contains the item
	 */
	@Override
	public boolean contains(Type item) {

		if (root == null) {
			return false;
		}

		BinaryNode<Type> temp = root;
		Boolean found = false;

		while (found == false) {
			if (item.compareTo(temp.data) == 0) {
				return true;
			} else {
				if (item.compareTo(temp.data) > 0) {
					if (temp.getRightChild() == null) {
						return false;
					} else {
						temp = temp.rightChild;
					}
				} else {
					if (temp.getLeftChild() == null) {
						return false;
					} else {		
						temp = temp.leftChild;
					}
				}
			}
		}

		return found;
	}

	/**
	 * Checks to see if the BST contains all the items in the given collection
	 * 
	 * @param items - the items to be checked for
	 * @return true if all items are contained in the list, false otherwise
	 */
	@Override
	public boolean containsAll(Collection<? extends Type> items) {

		for (Type item : items) {
			if (this.contains(item) == false) {
				return false;
			}
		}

		return true;

	}

	/**
	 * Returns the first (smallest) item in the BST
	 * 
	 * @return the smallest item
	 * @throws NoSuchElementException
	 */
	@Override
	public Type first() throws NoSuchElementException {

		if (root == null) {
			throw new NoSuchElementException();
		}

		return root.getLeftmostNode().getData();

	}

	/**
	 * Returns whether the BST is empty or not
	 * 
	 * @return true if the BST is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	/**
	 * Returns the last (largest) item in the BST
	 * 
	 * @return the largest item
	 * @throws NoSuchElementException
	 */
	@Override
	public Type last() throws NoSuchElementException {

		if (root == null) {
			throw new NoSuchElementException();
		}

		return root.getRightmostNode().getData();

	}

	/**
	 * Removes the given item from the BST
	 * 
	 * @param item - the item to be removed
	 * @return true if the item was removed, false otherwise
	 */
	@Override
	public boolean remove(Type item) {
		if (root == null) {
			return false;
		}

		if (this.contains(item) == false) {
			return false;
		}

		BinaryNode<Type> temp = root;
		Boolean removed = false;

		while (removed == false) {
			if (item.compareTo(temp.data) == 0) {
				if (temp.getLeftChild() == null && temp.getRightChild() == null) {
					if (temp.parent == null) {
						root = null;
						removed = true;
						break;
					} else {
						temp.removeNoChildren();
						removed = true;
						break;
					}
				}
				if (temp.getLeftChild() == null && temp.getRightChild() != null) {
					if (temp.parent == null) {
						BinaryNode<Type> newRoot = temp.getRightChild();
						root = newRoot;
						newRoot.setParent(null);
						removed = true;
						break;
					} else {
						temp.removeHasRightChild();
						removed = true;
						break;
					}
				}

				if (temp.getLeftChild() != null && temp.getRightChild() == null) {
					if (temp.parent == null) {
						BinaryNode<Type> newRoot = temp.getLeftChild();
						root = newRoot;
						newRoot.setParent(null);
						removed = true;
						break;
					}
					temp.removeHasLeftChild();
					removed = true;
					break;
				}

				if (temp.getLeftChild() != null && temp.getRightChild() != null) {
					if (temp.parent == null) {
						root = temp.removeRootHasTwoChildren();
						removed = true;
						break;
					} else {
						temp.removeHasTwoChildren();
						removed = true;
						break;
					}
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

		size--;
		return removed;
	}

	/**
	 * Removes all of the items in the given collection
	 * 
	 * @param items - the given collection of items to be removed
	 * @return true if any items were removed, false otherwise
	 */
	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		boolean removed = false;

		for (Type item : items) {
			if (this.remove(item)) {
				removed = true;
			}
		}

		return removed;
	}

	/**
	 * Returns the number of objects in the array
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns an ArrayList with the objects in the BST from smallest to largest
	 * 
	 * @return an ArrayList of the ordered BST
	 */
	@Override
	public ArrayList<Type> toArrayList() {
		ArrayList<Type> inOrder = new ArrayList<Type>();

		if (root == null)
			return inOrder;

		Stack<BinaryNode<Type>> orderStack = new Stack<BinaryNode<Type>>();
		BinaryNode<Type> current = root;

		while (current != null || orderStack.size() > 0) {
			while (current != null) {
				orderStack.push(current);
				current = current.leftChild;
			}

			current = orderStack.pop();

			inOrder.add(current.data);
			current = current.rightChild;
		}
		
		return inOrder;
	}

}
