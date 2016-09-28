package assignment2;

/**
 * Implements Null Object Pattern to avoid null checks for Binary Search Tree
 * RealNode adds nodes to Binary Search tree in alphabetical order 
 * @author Yojana
 *
 */
public class RealNode extends Node {

	public RealNode(String key) {
		this.key = key;
		this.left = new NullNode(this);
		this.right= new NullNode(this);
	}

	public boolean isNull() {
		return false;
	}

	/**
	 * Adds new RealNode into Binary Search Tree according to given strategy
	 */
	@Override
	public void addNode(String key, Strategy bstStrategy) {
		if (bstStrategy.orderStrategy(key).toLowerCase().compareToIgnoreCase(bstStrategy.orderStrategy(this.key)) <= 0) {
			if (this.left.isNull()) {
				isLeft = true;
			}
			left.addNode(key, bstStrategy);
		} else {
			if (this.right.isNull()) {
				isRight = true;
			}
			right.addNode(key, bstStrategy);
		}
	}

	/* Another insertion sequence strategy
	 * @Override
	public void insert(String key, Strategy bstStrategy) {
		// TODO Auto-generated method stub
		int lengthKey = 0, lengthNewKey = 0;

		lengthKey = bstStrategy.orderStrategy(key).length();
		lengthNewKey = bstStrategy.orderStrategy(this.key).length();

		if (lengthKey <= lengthNewKey) {
			if (this.left.isNil()) {
				isLeft = true;
			}
			left.insert(key, bstStrategy);
		} else {
			if (this.right.isNil()) {
				isRight = true;
			}
			right.insert(key, bstStrategy);
		}
	}
	 */
}
