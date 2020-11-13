package textformatter;

public class CenteredText extends AbstractFormattedText {

	private int textwidth;

	/**
	 * Create a new CentredText object with a given text width
	 *
	 * @param textwidth the width of the text, {@code textwidth > 0}
	 */
	public CenteredText(int textwidth) {
		super();
		this.textwidth = textwidth;
	}

	@Override
	public AbstractFormattedText getInstance() {
		return new CenteredText(textwidth);
	}

	/**
	 * Create a centred line of text
	 * @param line the line of text to center
	 */
	private void centerLine(StringBuilder line) {
		int gap = this.textwidth - line.length();
		if (gap <= 0)
			return;
		int leftGap = gap / 2;
		int rightGap = gap - leftGap;
		while (leftGap > 0) {
			line.insert(0, " ");
			leftGap--;
		}
		while (rightGap > 0) {
			line.append(" ");
			rightGap--;
		}
	}

	@Override
	public boolean add(String line) {

		if (line.equals("") || (line == null))
			return super.add(line);

		String[] words = line.split("\\s+");
		StringBuilder sbline = new StringBuilder();
		for (String word : words) {
			int currlength = sbline.length() > 0 ? sbline.length() + 1 : 0;
			if ((currlength + word.length() > this.textwidth) && (currlength > 0)) {
				centerLine(sbline);
				super.add(sbline.toString());
				sbline.delete(0, sbline.length());
			}
			if (sbline.length() > 0)
				sbline.append(" ");
			sbline.append(word);
		}
		if (sbline.length() > 0) {
			centerLine(sbline);
			super.add(sbline.toString());
		}
		return true;
	}
}
