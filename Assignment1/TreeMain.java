package assignment1;

import java.util.ArrayList;
import java.util.List;


public class TreeMain {
	public static void main(String[] args) {
		TraverseTree tree = new TraverseTree();
		List<String> names=new ArrayList<String>();
		names.add("John");
		names.add("Marshall");
		names.add("Arya");
		names.add("Cersei");
		names.add("Eddard");
		names.add("Oberyn");
		names.add("Hodor");

		for (int i = 0; i < names.size(); i++)
			tree.insertTree(names.get(i));

		// Display in alphabetical order
		System.out.println(tree.inorderTraversal(tree.getRoot()));

		// Display in reverse alphabetical order starting with vowels 
		System.out.println(tree.reverseTraversal(tree.getRoot()));
	}
}