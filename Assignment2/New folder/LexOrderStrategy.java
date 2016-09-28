package assignment2;

/**
 * Concrete class for Strategy interface which determines strategy for 
 * adding nodes to Binary Search tree
 * @author Yojana
 *
 */
public class LexOrderStrategy implements Strategy {

	@Override
	public String orderStrategy(String lexOrderKey) {
		return lexOrderKey;
	}
}
