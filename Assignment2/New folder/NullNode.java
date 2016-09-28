package assignment2;

/**
 * Implements Null Object Pattern to avoid null checks for Binary Search Tree
 * @author Yojana
 *
 */
public class NullNode extends Node{

	public NullNode(Node node) {
		this.root = node;
	}

	/**
	 * Checks if the object is null or not
	 */
	public boolean isNull() {
		return true;
	}
	
	public String toString() {
		return "";
	}
	
	/**
	 * Adds new node into Binary Search Tree according to given strategy
	 */
	@Override
	public void addNode(String newElement, Strategy bs) {
		if (root.isLeft == true) {
			root.isLeft = false;
			Node newRealNode = new RealNode(newElement);
			root.left = newRealNode;
		} else if (root.isRight == true) {
			root.isRight = false;
			Node newRealNode = new RealNode(newElement);
			root.right = newRealNode;
		}
	}
}
