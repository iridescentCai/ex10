package textformatter;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;

@SuppressWarnings("unused")
public abstract class AbstractFormattedText implements FormattedText {

	// we use a recursive list definition for our formatted text
	private String firstLine;
	private AbstractFormattedText remainingText;
	private AbstractFormattedText lastLine;

	/**
	 * A simple default constructor
	 */
	public AbstractFormattedText() {
		firstLine = null;
		remainingText = null;
		lastLine = null;
	}

	/**
	 * Obtain an instance of AbstractFormattedText
	 * @return an instance of AbstractFormattedText
	 */
	public abstract AbstractFormattedText getInstance();

	/**
	 *
	 * @param line
	 *            represents a line of text
	 * @return true after the new line of text has been added to the existing
	 *         except when line is null or "" in which case nothing is added and
	 *         false is returned
	 */
	public boolean add(String line) {
		if (line == null)
			return false;
		if (line.equals(""))
			return false;

		if (firstLine == null) {
			firstLine = line;
			lastLine = this;
		} else {
			AbstractFormattedText newline = getInstance();
			newline.firstLine = line;
			lastLine.remainingText = newline;
			lastLine = newline;
		}
		return true;
	}

	/**
	 * @return the number of lines in the FormattedText
	 *
	 */
	@Override
	public int numlines() {
		int count = 0;
		if (this.firstLine == null)
			return 0;
		else {
			AbstractFormattedText currLine = this;
			count = 1;
			while (currLine.remainingText != null) {
				count++;
				currLine = currLine.remainingText;
			}
		}
		return count;
	}


	/* Count the number of strings, including numbers
	 * @see textformatter.FormattedText#wordCount()
	 */
//	public int wordCount() {
//		int count = 0;
//		if (firstLine == null || firstLine.equals("")) return count;
//		StringTokenizer sc = new StringTokenizer(this.toString()," |\n");
//		while(sc.hasMoreTokens()) {
//			count ++;
//			sc.nextToken();
//		}
//		return count;
//	}

	/* Count the number of strings, excluding numbers
	 * @see textformatter.FormattedText#wordCount()
	 */
	@Override
	public int wordCount() {
		int count = 0;
		if (firstLine == null || firstLine.equals("")) return count;
		Pattern r = Pattern.compile("(\\b[a-zA-Z]+\\b)");
		Matcher m = r.matcher(this.toString());
		while (m.find()) {
			count ++;
		}
		return count;
	}

	@Override
	public String toString() {
		AbstractFormattedText currline = this;
		StringBuilder text = new StringBuilder();
		while (currline != null) {
			text.append(currline.firstLine);
			text.append("\n");
			currline = currline.remainingText;
		}
		return text.toString();
	}

}
