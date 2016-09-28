package assignment1;

public class BSTNode {
	public String data;  				// Data string at each node

	public BSTNode leftLink, rightLink;	//Attributes of each node 

	/**
	 * Create a new BSTNode object.
	 */
	public BSTNode(String newData){
		data = newData;
		leftLink = rightLink = null;
	}
}