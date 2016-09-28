package lab4part1;

public class Demo {
	public static void main(String[] args) {

		final CheckPattern handler;
		handler = new CheckPattern(".c*t");
		System.out.println(handler.findFirstIndex("fdcacacat"));
	}

}
