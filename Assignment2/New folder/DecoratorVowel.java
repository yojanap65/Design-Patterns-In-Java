package assignment2;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class overrides iterator methods to display 
 * elements of Binary Search Tree elements having vowel as their first character. 
 * @author Yojana
 */
public class DecoratorVowel extends DecoratorIterator  {

	LinkedList<String> listElement = new LinkedList<String>();

	public DecoratorVowel(Iterator<String> iteratorString) {
		super(iteratorString);
		String[] vowels = {"a","e","i","o","u"};

		while(iteratorString.hasNext()){
			String vowelString = iteratorString.next();
			for (int i = 0; i < vowels.length; i++) {
				if(vowelString.toLowerCase().startsWith(vowels[i])){
					listElement.add(vowelString) ;
				}
			}
		}
	}

	@Override
	public boolean hasNext() {
		return listElement.size() > 0;
	}

	@Override
	public String next() {	
		// Retrieve and remove the head of the list
		return listElement.poll();
	}
}
