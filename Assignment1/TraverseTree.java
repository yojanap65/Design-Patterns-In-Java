package assignment1;

public class TraverseTree {
	//Root node of Binary Search Tree
	private BSTNode root; 

	/**
	 * @param newData inserts NewData string into into binary search tree
	 */
	public void insertTree(String newData) {
		//If tree is empty
		if (root == null) { 
			root = new BSTNode(newData);
			return ;
		}
		BSTNode localNode = root;
		while (true) {				
			if (newData.compareTo(localNode.data) < 0) { 		// Insert into left subtree
				if (localNode.leftLink == null ) {
					localNode.leftLink = new BSTNode(newData);
					return; 
				}
				else
					localNode = localNode.leftLink ;
			}
			else if (newData.compareTo(localNode.data) > 0) {	// Insert into right subtree
				if (localNode.rightLink == null ) {
					localNode.rightLink = new BSTNode(newData);
					return; 
				}
				else
					localNode = localNode.rightLink ;
			}
			else 
				break; 											// Data is already present in the tree
		}
	}

	/**
	 * @return 	root of binary search tree
	 */
	public BSTNode getRoot(){
		return this.root;
	}

	/**
	 * @param treeNode The node to begin the inorderTraversal.
	 * @return 	A String representation of the current binary search tree.                 
	 */
	public String inorderTraversal(BSTNode treeNode) {
		String inorderString = "";
		if (treeNode.leftLink != null)
			inorderString += inorderTraversal(treeNode.leftLink); 	// Left link
		if(treeNode.data != null)
			inorderString += treeNode.data + " "; 			// Root Node
		if (treeNode.rightLink != null)
			inorderString += inorderTraversal(treeNode.rightLink);	// Right link
		return inorderString;
	}

	/** 
	 * @param treeNode The node to begin the reverseTraversal.
	 * @return 	A String representation of the current binary search tree in reverse order
	 * 			with elements having first letter as vowel
	 */
	public String reverseTraversal(BSTNode treeNode) {
		char[] vowels = {'a','e','i','o','u'};
		String reverseString = "";
		if (treeNode.rightLink != null)
			reverseString += reverseTraversal(treeNode.rightLink);	// Right link

		for (int i = 0; i < vowels.length; i++) {			//Check if first letter is vowel
			if (treeNode.data.toLowerCase().charAt(0) == vowels[i])
				reverseString += treeNode.data + " ";		// Root Node
		}
		if (treeNode.leftLink != null)
			reverseString += reverseTraversal(treeNode.leftLink);	// Left link
		return reverseString;
	}
}