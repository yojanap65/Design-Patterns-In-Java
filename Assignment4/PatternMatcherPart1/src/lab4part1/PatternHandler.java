package lab4part1;

/**
 * This abstract class Implements Chain of Responsibility Pattern for StringPatternMatcher
 * @author Yojana
 */
public abstract class PatternHandler {
	protected PatternHandler successor;
	abstract public void setSuccessor(PatternHandler successor);
	abstract public boolean handleRequest(String data,int index);
}
