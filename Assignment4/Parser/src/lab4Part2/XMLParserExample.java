package lab4Part2;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
/**
 * This class implements XMLParser using default (non-validating) SAXParser
 * @author Yojana
 */
class XMLParserExample extends DefaultHandler {

	private ArrayList<Node> tagList = new ArrayList<Node>();
	private XMLDocument document;
	private XMLTag testTag;
	private static XMLTag root;
	String filePath;

	public XMLParserExample(String filePath) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(new File(filePath), this );
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getHeader() {
		return root.accept(new HeaderVisitor());
	}

	public String getText() {
		return root.accept(new TextVisitor());
	}

	@Override
	public void startDocument() {

	}

	@Override
	public void endDocument() {

	}

	@Override
	public void startElement(String namespaceURI,String localName,String qname,Attributes atts) {
		if(qname.equalsIgnoreCase("header")) {
			XMLHeader header = new XMLHeader();
			testTag = header;
		}
		if(qname.equalsIgnoreCase("text")) {
			XMLText text = new XMLText();
			testTag = text;
		}
		if(qname.equalsIgnoreCase("CS635Document")) {
			XMLDocument doc = new XMLDocument();
			Node tagNode = new Node();
			tagNode.current = doc;
			tagNode.previous = document;
			tagList.add(tagNode);
			if(document != null)
				document.add(doc);
			else   
				root = doc;
			document = doc;
		} 
	}	

	@Override
	public void endElement(String namespaceURI, String localName, String qname) {
		if(qname.equalsIgnoreCase("CS635Document")) {
			for(int i = 0;i < tagList.size();i++)  {
				if(tagList.get(i).current == document) {
					XMLDocument previous = tagList.get(i).previous;
					if(previous != null)   
						document = previous;
					break;
				}
			}
		}
		if(qname.equalsIgnoreCase("header")) {
			document.add(testTag);
			testTag = null;
		}
		if(qname.equalsIgnoreCase("text")) {
			document.add(testTag);
			testTag = null;
		}
	}

	public void characters(char[] ch, int start, int length) {
		String content = new String(ch,start,length);

		if(testTag != null) {
			testTag.content = content;
		}	   
	}
}