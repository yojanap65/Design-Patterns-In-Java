package lab4Part2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * This interface implements CompositeVisitor
 * @author Yojana
 */
interface XMLCompositeVisitor {
	public String visit(XMLHeader header);
	public String visit(XMLText text);
	public String visit(XMLDocument document);
}
/**
 * This abstract class gives operations on XMLTags
 * @author Yojana
 */
abstract class XMLTag {
	protected String tagName;
	protected String content;
	public abstract String accept(XMLCompositeVisitor visitor);
}

/**
 * This class implements XMLDocument to accept Composite Visitor
 * @author Yojana
 */
class XMLDocument extends XMLTag {

	ArrayList<XMLTag> nestedTags = new ArrayList<XMLTag>();

	public void add(XMLTag newTag) {
		nestedTags.add(newTag);
	}

	public void remove(XMLTag tags) {
		nestedTags.remove(tags);
	}

	@Override
	public String accept(XMLCompositeVisitor visitor) {
		return visitor.visit(this);
	}
}

/**
 * This class implements XMLHeader for Composite Visitor
 * @author Yojana
 */
class XMLHeader extends XMLTag {
	@Override
	public String accept(XMLCompositeVisitor visitor) {
		return visitor.visit(this);
	}
}

/**
 * This class implements XMLText for Composite Visitor
 * @author Yojana
 */
class XMLText extends XMLTag {
	@Override
	public String accept(XMLCompositeVisitor visitor) {
		return visitor.visit(this);
	}	
}

/**
 * This is helper class for XMLDocument Composite Tree
 * @author Yojana
 */
class Node {
	XMLDocument current;
	XMLDocument previous;
}

/**
 * This class implements custom HeaderVisitor
 * @author Yojana
 */
class HeaderVisitor implements XMLCompositeVisitor {	

	@Override
	public String visit(XMLHeader header) {
		/* To write in header file
		 * private File file = new File("header.txt");
		 * try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(header.content + "\n");
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		} */
		return header.content + "\n";
	}


	@Override
	public String visit(XMLText text) {
		return "";
	}

	@Override
	public String visit(XMLDocument document) {
		String result = "";
		for(XMLTag tag : document.nestedTags) {
			result += tag.accept(this);
		}
		return result;
	}
}

/**
 * This class implements custom TextVisitor
 * @author Yojana
 */
class TextVisitor implements XMLCompositeVisitor {

	@Override
	public String visit(XMLHeader header) {
		return header.content + "\n";
		/* To write in text file
		private File file = new File("text.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(header.content + System.getProperty("line.separator"));
			bw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} */
	}

	@Override
	public String visit(XMLText text) {
		return text.content + "\n";
		/* To append in text file
		try {
			String filename = "text.txt";
			FileWriter fw = new FileWriter(filename,true);
			fw.write(text.content + System.getProperty("line.separator"));
			fw.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		} */
	}

	@Override
	public String visit(XMLDocument document) {
		String result = "";
		for(XMLTag tag : document.nestedTags) {
			result += tag.accept(this);
		}
		return result;
	}
}