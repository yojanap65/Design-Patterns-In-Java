package assignment2;

import java.util.Iterator;
/**
 * Concrete class for Iterator interface used for decorator pattern
 * @author Yojana
 */
public  abstract class DecoratorIterator implements Iterator<String> {

	Iterator<String> iteratorString; 

	public DecoratorIterator(Iterator<String> iteratorString) {
		this.iteratorString = iteratorString;
	}
}
