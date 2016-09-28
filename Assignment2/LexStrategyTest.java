package assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class LexStrategyTest {

	BinarySearchTree tree = new BinarySearchTree(new LexOrderStrategy());
	String[] testData = {"Marshall","Arya","Cersei","Oberyn","Hodor","John"};

	/**
	 * Asserts toString produces correct entries from Binary Search tree inserted
	 * using LexOrderStrategy
	 */
	@Test
	public void test_lexOrderStrategy() {
		for(int i = 0; i < testData.length; i++) {
			tree.add(testData[i]);
		}
		assertEquals("Arya Cersei Hodor John Marshall Oberyn",tree.toString().trim());		
	}


}
