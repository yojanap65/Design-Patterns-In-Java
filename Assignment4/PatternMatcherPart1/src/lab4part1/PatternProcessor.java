package lab4part1;

public class PatternProcessor {
	private boolean successor = true;
	private PatternHandler previous;
	private PatternHandler head;

	public boolean handleRequest(String data,int index) {
		return head.handleRequest(data, index);
	}

	public void addHandler(PatternHandler handler) {
		if(successor == true) {
			head = handler;
			previous = head;
			successor = false;
		} else {
			if(previous != null)
				previous.setSuccessor(handler);
			previous = handler;
		}
	}	
}
