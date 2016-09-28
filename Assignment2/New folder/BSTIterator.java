package assignment2;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements Iterator class and overrides its methods for Binary Search Tree
 * @author Yojana
 */
public class BSTIterator implements Iterator<String>{
	ArrayDeque<Node> stack = new ArrayDeque<Node>();
	Node currentNode;


	public BSTIterator(Node rootNode) {
		while (!(rootNode.isNull())) {
			stack.push(rootNode);
			rootNode = rootNode.left;
		}
	}

	@Override
	public boolean hasNext() {
		return stack.size() > 0;
	}

	@Override
	public String next() {
		if(!hasNext())
			throw new NoSuchElementException();
		if(!stack.isEmpty()) {
			currentNode =  stack.pop();
			String result = currentNode.key;
			if (!(currentNode.right.isNull())) {
				currentNode = currentNode.right;
				while(!(currentNode.isNull())){
					stack.push(currentNode);
					currentNode = currentNode.left;
				}
			}
			return result;
		}
		else
			throw new java.util.EmptyStackException();
	}
}