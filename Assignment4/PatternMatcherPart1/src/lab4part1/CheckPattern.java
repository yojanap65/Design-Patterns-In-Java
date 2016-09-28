package lab4part1;

/**
 * This class implements initialization and check for Dot and Star patterns
 * @author Yojana
 */
public class CheckPattern {

	private String pattern;
	private PatternProcessor processor; 
	private int index = 0;

	public CheckPattern(String pattern) {
		this.pattern = pattern;
		initializePattern();
	}

	/**
	 * This method is for finding Index of first occurrence of the pattern
	 * @param data : Input string for finding pattern index
	 * @return : Index of first occurrence of the pattern
	 */
	public int findFirstIndex(String data) {
		while(index != data.length()) {
			if(processor.handleRequest(data, index) == true)
				return index;
			else
				index++;
		}
		return -1;
	}

	public void initializePattern() {
		processor = new PatternProcessor();
		while(index != pattern.length()) {
			if(pattern.charAt(index) == '*') {
				processor.addHandler(new StarHandler(pattern.charAt(index)));
				index = index + 1;
			} else if(pattern.charAt(index) == '.') {
				processor.addHandler(new DotHandler(pattern.charAt(index)));
				index = index + 1;
			} else {
				processor.addHandler(new CharacterHandler(pattern.charAt(index)));
				index = index + 1;
			}
		}
		index=0;
	}
}