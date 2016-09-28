package lab4part1;

public class CharacterHandler extends PatternHandler {

	private PatternHandler next;
	private final char character;

	public CharacterHandler(char character) {
		this.character = character;
	}

	@Override
	public void setSuccessor(PatternHandler successor) {
		this.next = successor;
	}

	@Override
	public boolean handleRequest(String data, int index) {
		if(index == data.length())
			return false;

		if(data.charAt(index)!= character)
			return false;

		else {
			if(next != null)
				return next.handleRequest(data, ++index);
			else {
				if(data.charAt(index) != character)
					return false;
				else 
					return true;
			}
		}
	}
}
