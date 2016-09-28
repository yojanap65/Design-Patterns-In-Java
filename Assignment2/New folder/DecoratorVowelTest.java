package assignment2;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class DecoratorVowelTest {

	BinarySearchTree tree = new BinarySearchTree(new LexOrderStrategy());
	String[] testData = {"Marshall","Arya","Cersei","Oberyn","Hodor","John"};

	/**
	 * Asserts add inserts data into Binary Search Tree using LexOrderStrategy
	 */
	@Test
	public void test_add() {
		for(int i = 0; i < testData.length; i++) {
			tree.add(testData[i]);
		}
		assertEquals("Arya Cersei Hodor John Marshall Oberyn", tree.toString().trim());
	}

	/**
	 * Asserts DecoratorVowel produces capitalized data from Binary Search Tree
	 */
	@Test
	public void test_DecoratorVowel() {
		StringBuffer output = new StringBuffer();
		test_add();
		Iterator<String> decoratorIterator = tree.iterator();
		DecoratorVowel vowel = new DecoratorVowel(decoratorIterator);
		while(vowel.hasNext())
			output.append(vowel.next() + " ");
		assertEquals("Arya Oberyn", output.toString().trim());	
	}
}
