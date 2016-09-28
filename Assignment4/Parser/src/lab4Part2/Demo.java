package lab4Part2;

import org.xml.sax.helpers.DefaultHandler;

public class Demo extends DefaultHandler {
    public static void main(String[] args) throws Exception {
    	XMLParserExample parser = new XMLParserExample("sample.txt");
        System.out.println(parser.getHeader());
        System.out.println(parser.getText());
    }
}
