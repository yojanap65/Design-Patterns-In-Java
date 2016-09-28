package assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseStrategyTest {

	BinarySearchTree tree = new BinarySearchTree(new ReverseOrderStrategy());
	String[] testData = {"Marshall","Arya","Cersei","Oberyn","Hodor","John"};

	/**
	 * Asserts toString produces correct entries from Binary Search tree inserted
	 * using ReverseOrderStrategy
	 */
	@Test
	public void test_reverseOrderStrategy() {
		for(int i = 0; i < testData.length; i++) {
			tree.add(testData[i]);
		}
		assertEquals("Arya Cersei Marshall John Oberyn Hodor",tree.toString().trim());		
	}

}
