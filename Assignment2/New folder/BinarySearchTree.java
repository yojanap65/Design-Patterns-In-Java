package assignment2;

import java.util.AbstractList;
import java.util.Iterator;

/**
 * The BinarySearchTree class implements a Binary Search tree as a collection 
 * using design patterns like :
 *  1.Null Object Pattern:	To remove null checks
 *  2.Strategy Pattern:		To decide strategy for adding nodes to tree	 
 *  3.Iterator Pattern:		To traverse through Binary Search Tree
 *  4.Decorator Pattern:	To perform required display functionalities.
 * @author Yojana
 */
public class BinarySearchTree extends AbstractList<String> {

	private Node rootNode;
	private int size = 0;
	private Strategy bstStrategy;

	/**
	 * Pass strategy deign pattern of choice for binary search tree
	 * @param strategy: Decide strategy for adding elements into binary search tree
	 */
	public BinarySearchTree(Strategy strategy) {
		this.bstStrategy = strategy;
	}
	/**
	 * Returns total number of nodes in Binary Search Tree
	 * @return total number of nodes in Binary Search Tree
	 */
	public int size() {
		return size;
	}

	/**
	 *  Returns true if this binary search tree is empty
	 *  @return true if this binary search tree is empty
	 */
	public boolean isEmpty() {
		return (rootNode == null);
	}

	/**
	 * Returns true if new element is added successfully to this binary search tree
	 * @return true if new element is added successfully to this binary search tree
	 */
	public boolean add(String newElement) {
		try {
			if (size == 0) {
				rootNode = new RealNode(newElement);
			} else {
				rootNode.addNode(newElement, bstStrategy);
			}
			size = size + 1;
			return true;
		} catch (SecurityException e) {
			return false;
		}
	}
	/**
	 * Enables traversing through a Binary Search Tree
	 * @return iterator for Binary Search Tree traversal
	 */
	public Iterator<String> iterator() {
		return new BSTIterator(rootNode);
	}

	/**
	 *
	 * @return string format for each node element of Binary Search Tree
	 */
	@Override
	public String toString() {
		StringBuffer traverse = new StringBuffer();
		Iterator<String> stringIterator = iterator();
		while (stringIterator.hasNext()) {
			traverse.append(stringIterator.next() + " ");
		}
		return traverse.toString();
	}

	/**
	 * @return resultant array for the binary search tree
	 */
	public String[] toArray() {
		String[] inputData = new String[size];
		Iterator<String> bstIterator = iterator();
		for (int i = 0; bstIterator.hasNext(); i++) {
			inputData[i] = bstIterator.next();
		}
		return inputData;
	}

	/**
	 * Operation Not Supported for Binary Search Tree
	 */
	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Operation not supported by Binary Search Tree!");
	}		

}
