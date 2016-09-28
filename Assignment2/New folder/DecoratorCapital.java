package assignment2;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class overrides iterator methods to display 
 * elements of Binary Search Tree in CAPITAL letters. 
 * @author Yojana
 */
public class DecoratorCapital extends DecoratorIterator {

	LinkedList<String> listElement = new LinkedList<String>();

	public DecoratorCapital(Iterator<String> iteratorString) {
		super(iteratorString);
		while(iteratorString.hasNext()) {
			String capitalString = iteratorString.next();			
			listElement.add(capitalString) ;		
		}
	}

	@Override
	public boolean hasNext() {
		return listElement.size() > 0;
	}

	@Override
	public String next() {
		// Retrieve and remove the head of the list
		return listElement.poll().toUpperCase();
	}

}
