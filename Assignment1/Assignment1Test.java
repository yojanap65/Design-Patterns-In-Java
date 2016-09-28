package assignment1;
/**
 * This class tests all logic within class TraverseTree.
 **/
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Assignment1Test {
	TraverseTree tree = new TraverseTree();
	List<String> name = new ArrayList<String>();
	String[] data = {"John","Marshall","Arya","Cersei","Eddard","Oberyn","Hodor"};
	/**
	 * Assert insertTree() correctly inserts String elements into binary search tree.
	 */
	@Test
	public void test_insertTree() {
		// Add data string to array list
		for(int i=0;i<data.length;i++)
			name.add(data[i]);
		assertEquals(data[0],name.get(0));
		assertEquals(data[1],name.get(1));
		assertEquals(data[2],name.get(2));
		assertEquals(data[3],name.get(3));
		assertEquals(data[4],name.get(4));
		assertEquals(data[5],name.get(5));
		assertEquals(data[6],name.get(6));

		for(int i=0;i<name.size();i++)
			tree.insertTree(name.get(i));
	}

	/**
	 * Asserts inorderTraversal produces the correctly formatted string.
	 * inorderTraversal produces the same result after insertTree of newData
	 */
	@Test
	public void test_inorderTraversal() {
		test_insertTree();
		assertEquals("Arya Cersei Eddard Hodor John Marshall Oberyn",tree.inorderTraversal(tree.getRoot()).trim());
	}

	/**
	 * Asserts reverseTraversal produces the correctly formatted string.
	 */
	@Test
	public void test_ReverseTraversal() {
		test_insertTree();
		assertEquals("Oberyn Eddard Arya",tree.reverseTraversal(tree.getRoot()).trim());
	}

}
