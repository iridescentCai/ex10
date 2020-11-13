package textformatter;

import javax.swing.AbstractAction;

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

	@Override
	public int wordCount() {
		// TODO: Implement this method
		return -1;
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
