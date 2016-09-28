package lab4Part2;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * This Test class implements test cases to check parsed XML document
 * @author Yojana
 */
public class TestParser {

	@Test
	public void testHeader() {
		XMLParserExample parser = new XMLParserExample("sample.txt");
		assertEquals(parser.getHeader().trim(),"This is an example");		
	}

	@Test
	public void testText() {
		XMLParserExample parser = new XMLParserExample("sample.txt");
		assertEquals(parser.getText().trim(),"This is an example"+"\n"+"Not much here"+"\n"+
				"Just text here");
	}
	

}
