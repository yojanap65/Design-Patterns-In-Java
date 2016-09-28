package lab4part1;

public class StarHandler extends PatternHandler {

	private PatternHandler next;
	private final char star;

	public StarHandler(char star) {
		this.star = star;
	}

	@Override
	public void setSuccessor(PatternHandler successor) {
		this.next = successor;
	}
	
	@Override
	public boolean handleRequest(String data, int index) {
		if(index == data.length())
			return false;

		if(star == '*') {
			if(next != null) {
				while(index != data.length()) {
					if(next.handleRequest(data, index) == true) 
						return true;
					else
						index++;
				}
				return false;
			} else 
				return false;
		} else {
			if(next != null) 
				return next.handleRequest(data, ++index);
			else {
				if(data.charAt(index) != star)
					return false;
				else 
					return true;
			}
		}
	}
}
