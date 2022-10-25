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
		
//		test.add(8);
//		test.add(4);
//		test.add(10);
//		
//		test.add(2);
//		
//		test.add(12);
//		test.add(14);
//		test.add(3);
//		
//		test.add(0);
//		
//		test.add(-1);
		
		test.add(8);
		test.add(2);
		test.add(10);
		test.add(3);
		
		test.remove(8);
		
		
		System.out.println(test.toArrayList());
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

		while (removed == false) {
			if (item.compareTo(temp.data) == 0) {
				if(temp.getLeftChild() == null && temp.getRightChild() == null) {
					if (temp.getParent() == null) {
						root = null;
						removed = true;
						break;
					}
					if(temp.getData().compareTo(temp.getParent().getLeftChild().getData()) == 0) {
						temp.getParent().setLeftChild(null);
					}
					if(temp.getData().compareTo(temp.getParent().getRightChild().getData()) == 0) {
						temp.getParent().setRightChild(null);
					}
					removed = true;
					break;
				}
				
				if(temp.getLeftChild() == null && temp.getRightChild() != null) {
					if(temp.getParent() == null) {
						root = temp.rightChild;
						temp.setParent(null);
						removed = true;
						break;
					}
					if(temp.getData().compareTo(temp.getParent().getLeftChild().getData()) == 0) {
						temp.getParent().setLeftChild(temp.getRightChild());
						removed = true;
						break;
					}
					if(temp.getData().compareTo(temp.getParent().getRightChild().getData()) == 0) {
						temp.getParent().setRightChild(temp.getRightChild());
						removed = true;
						break;
					}
				}
				
				if(temp.getLeftChild() != null && temp.getRightChild() == null) {
					if(temp.getParent() == null) {
						root = temp.leftChild;
						temp.setParent(null);
						removed = true;
						break;
					}
					if(temp.getData().compareTo(temp.getParent().getLeftChild().getData()) == 0) {
						temp.getParent().setLeftChild(temp.getLeftChild());
						removed = true;
						break;
					}
					if(temp.getData().compareTo(temp.getParent().getRightChild().getData()) == 0) {
						temp.getParent().setRightChild(temp.getLeftChild());
						removed = true;
						break;
					}
				}
				
				if(temp.getLeftChild() != null && temp.getRightChild() != null) {
					BinaryNode<Type> successor = temp.getSuccessor();
					BinaryNode<Type> successorRightChild = null;
					if(successor.getRightChild() != null) {
						successorRightChild = successor.getRightChild();
					}
					if(temp.getParent() == null) {
						successor.setLeftChild(temp.getLeftChild());
						successor.setRightChild(temp.getRightChild());
						temp.getLeftChild().setParent(successor);
						temp.getRightChild().setParent(successor);
						if(successor.getData().compareTo(successor.getParent().getLeftChild().getData()) == 0) {
							if (successorRightChild != null) {
								successor.getParent().setLeftChild(successorRightChild);
								successorRightChild.setParent(successor.getParent());
							}
							else {
								successor.getParent().setLeftChild(null);
							}
							
						}
						if(successor.getData().compareTo(successor.getParent().getRightChild().getData()) == 0) {
							if (successorRightChild != null) {
								successor.getParent().setRightChild(successorRightChild);
								successorRightChild.setParent(successor.getParent());
							}
							else {
								successor.getParent().setRightChild(null);
							}
						}
						root = successor;
						successor.setParent(null);
						removed = true;
						break;

					}
					if(temp.getData().compareTo(temp.getParent().getLeftChild().getData()) == 0) {
						temp.getParent().setLeftChild(successor);
						if(successor.getData().compareTo(successor.getParent().getLeftChild().getData()) == 0) {
							if (successorRightChild != null) {
								successor.getParent().setLeftChild(successorRightChild);
								successorRightChild.setParent(successor.getParent());
							}
							else {
								successor.getParent().setLeftChild(null);
							}
							
						}
						if(successor.getData().compareTo(successor.getParent().getRightChild().getData()) == 0) {
							if (successorRightChild != null) {
								successor.getParent().setRightChild(successorRightChild);
								successorRightChild.setParent(successor.getParent());
							}
							else {
								successor.getParent().setRightChild(null);
							}
						}
						removed = true;
						break;
					}
					if(temp.getData().compareTo(temp.getParent().getRightChild().getData()) == 0) {
						successor.getParent().setRightChild(successor);
						if(successor.getData().compareTo(successor.getParent().getLeftChild().getData()) == 0) {
							if (successorRightChild != null) {
								successor.getParent().setLeftChild(successorRightChild);
								successorRightChild.setParent(successor.getParent());
							}
							else {
								successor.getParent().setLeftChild(null);
							}
							
						}
						if(successor.getData().compareTo(successor.getParent().getRightChild().getData()) == 0) {
							if (successorRightChild != null) {
								successor.getParent().setRightChild(successorRightChild);
								successorRightChild.setParent(successor.getParent());
							}
							else {
								successor.getParent().setRightChild(null);
							}
						}
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
			if (this.contains(item) == false) {
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
	    
		BinaryNode<Type> temp = node;
		
	    if (temp.getLeftChild() != null) {
	    	order(temp.leftChild);
	    }
	    
	    inOrder.add(temp.data);
	    
	    if (temp.getRightChild() != null) {
	    	order(temp.rightChild);
	    }	    
	  }  
	
	@Override
	public ArrayList<Type> toArrayList() {
		order(root);
		
		return inOrder;
	}

}
