package lab4part1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPatternMatcher {

	@Test
	public void testDotPattern() {
		final CheckPattern handler;
		handler = new CheckPattern("c.t");
		assertEquals(2,handler.findFirstIndex("cacat"));
	}

	@Test
	public void testStarPattern() {
		final CheckPattern handler;
		handler = new CheckPattern("c*t");
		assertEquals(5,handler.findFirstIndex("sdsducacat"));
	}
	
	@Test
	public void testCompositePattern() {
		final CheckPattern handler1, handler2;
		handler1 = new CheckPattern(".c.t");
		assertEquals(6,handler1.findFirstIndex("sdsducacat"));
		
		handler2 = new CheckPattern("*c.t");
		assertEquals(0,handler2.findFirstIndex("sdsducacat"));
	}
	
	
}
