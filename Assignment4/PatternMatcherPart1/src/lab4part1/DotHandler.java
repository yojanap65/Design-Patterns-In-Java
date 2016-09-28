package lab4part1;

public class DotHandler extends PatternHandler{

	private PatternHandler next;
	private final char dot;

	public DotHandler(char dot) {
		this.dot = dot;
	}

	@Override
	public void setSuccessor(PatternHandler successor) {
		this.next = successor;
	}

	@Override
	public boolean handleRequest(String data, int index) {
		if(index==data.length())
			return false;

		if(dot=='.') {
			if(next!=null)
				return next.handleRequest(data, ++index);
			else
				return false;
		}

		else {
			if(next!=null)
				return next.handleRequest(data, ++index);
			else {
				if(data.charAt(index)!=dot)
					return false;
				else 
					return true;
			}
		}
	}
}
