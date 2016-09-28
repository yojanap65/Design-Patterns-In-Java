package assignment2;
/**
 * This program implements Binary search tree using java design patterns.
 * Abstract class Node declares attributes for each node of Binary Search Tree
 * @author Yojana
 *
 */
public abstract class Node {

	protected String key;
	protected Node left = null , right = null, root = null;
	protected boolean isLeft = false, isRight = false;

	public abstract boolean isNull();
	public abstract void addNode(String newElement, Strategy bs);

}
