package assignment2;

/**
 * Concrete class for Binary Search Tree Strategy Interface
 * @author Yojana
 */
public class ReverseOrderStrategy implements Strategy {

	@Override
	public String orderStrategy(String key) {
		String reverse = new StringBuffer(key).reverse().toString();
		return reverse;
	}
}
