package assign07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.io.TempDir;

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {

	private BinaryNode<Type> root = null;
	private int size = 0;
	
	private ArrayList<Type> inOrder = new ArrayList<Type>();
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> test2 = new BinarySearchTree<Integer>();
		
		ArrayList<Integer> testarr = new ArrayList<Integer>();
		
		testarr.add(8);
		testarr.add(4);
		testarr.add(12);
		testarr.add(2);
		testarr.add(6);
		testarr.add(10);
		testarr.add(14);
		testarr.add(1);
		testarr.add(3);
		testarr.add(5);
		testarr.add(7);
		testarr.add(9);
		testarr.add(11);
		testarr.add(13);
		testarr.add(15);
		
		test.add(8);
		test.add(4);
		test.add(12);
		test.add(2);
		test.add(6);
		test.add(10);
		test.add(14);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);
		test.add(13);
		test.add(15);
		
//		test.remove(4);
//		
//		test.remove(6);
//		
		test2.addAll(testarr);
		System.out.println(test.addAll(testarr));
		System.out.println(test2.containsAll(testarr));
	}

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
		
		public int getLeftOrRight() {
			if(this == this.getParent().getLeftChild()) {
				return -1;
			}
			if(this == this.getParent().getRightChild()) {
				return 1;
			}
			return 0;
		}
		
		public void removeNoChildren() {
			
			if(this.getLeftOrRight() > 0) {
				this.parent.setRightChild(null);
			}
			
			if (this.getLeftOrRight() < 0) {
				this.parent.setLeftChild(null);
			}
			
		}
		
		public void removeHasLeftChild() {
			
			BinaryNode<Type> left = this.leftChild;
			BinaryNode<Type> thisParent = this.parent;
			
			if(this.getLeftOrRight() > 0) {
				thisParent.setRightChild(left);
				left.setParent(thisParent);
			}
			
			if (this.getLeftOrRight() < 0) {
				thisParent.setLeftChild(left);
				left.setParent(thisParent);
			}
			
		}
		
		public void removeHasRightChild() {
			
			BinaryNode<Type> right = this.rightChild;
			BinaryNode<Type> thisParent = this.parent;
			
			if(this.getLeftOrRight() > 0) {
				thisParent.setRightChild(right);
				right.setParent(thisParent);
			}
			
			if (this.getLeftOrRight() < 0) {
				thisParent.setLeftChild(right);
				right.setParent(thisParent);
			}
			
		}
		
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
			
			if(this.getLeftOrRight() > 0) {
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
			} else {successorParent.setLeftChild(null);}
			
			successor.setLeftChild(left);
			left.setParent(successor);
			
			successor.setRightChild(right);
			right.setParent(successor);
			
		}
		
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
			} else {successorParent.setLeftChild(null);}
			
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

			while (added == false) {
				if (item.compareTo(temp.data) > 0) {
					if (temp.getRightChild() != null) {
						temp = temp.rightChild;
						continue;
					} else {
						temp.setRightChild(newNode);
						newNode.setParent(temp);
						added = true;
						break;
					}
				}
				if (item.compareTo(temp.data) < 0) {
					if (temp.getLeftChild() != null) {
						temp = temp.leftChild;
						continue;
					} else {
						temp.setLeftChild(newNode);
						newNode.setParent(temp);
						added = true;
						break;
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

		while (found == false) {
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
			if (this.contains(item) == false) {
			containsall = false;
			}
		}

		return containsall;

	}

	@Override
	public Type first() throws NoSuchElementException {

		if (root == null) {
			throw new NoSuchElementException();
		}
		
		return root.getLeftmostNode().getData();

	}

	@Override
	public boolean isEmpty() {
		return (root == null);
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

		while (removed == false) {
			if (item.compareTo(temp.data) == 0) {
				if(temp.getLeftChild() == null && temp.getRightChild() == null) {
					if(temp.parent == null) {
						root = null;
						removed = true;
						break;
					} else {
					temp.removeNoChildren();
					removed = true;
					break;
					}
				}
				if(temp.getLeftChild() == null && temp.getRightChild() != null) {
					if(temp.parent == null){
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
		
				if(temp.getLeftChild() != null && temp.getRightChild() == null) {
					if(temp.parent == null){
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
				
				if(temp.getLeftChild() != null && temp.getRightChild() != null) {
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

		return removed;
	}

	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		boolean removed = false;

		for (Type item : items) {
			if (this.contains(item) == true) {
				this.remove(item);
				removed = true;
			}
		}

		return removed;
	}

	@Override
	public int size() {
		return size;
	}
	  
	private void order(BinaryNode<Type> node) {
	    		
	    if (node.getLeftChild() != null) {
	    	order(node.leftChild);
	    }
	    
	    inOrder.add(node.data);
	    
	    if (node.getRightChild() != null) {
	    	order(node.rightChild);
	    }	    
	  }  
	
	@Override
	public ArrayList<Type> toArrayList() {
		inOrder.clear();
		
		if (root == null) {
			return inOrder;
		}
		
		order(root);
		
		return inOrder;
	}

}
