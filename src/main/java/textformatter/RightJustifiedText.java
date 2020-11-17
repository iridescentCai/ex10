package textformatter;


public class RightJustifiedText extends AbstractFormattedText{

    private int textWidth;

    /**Create a new RightJustifiedText object with a given text width
     * @param textWidth the width of the text, {@code textwidth > 0}
     */
    public RightJustifiedText(int textWidth) {
        this.textWidth = textWidth;
    }

    @Override
    public AbstractFormattedText getInstance() {
        return new RightJustifiedText(textWidth);
    }


    /**Create a Right line of text
     * @param line the line of text to Right
     */
    private void rightLint(StringBuilder line) {
        int gap = this.textWidth - line.length();
        if (gap <= 0)
            return;
        while (gap > 0) {
            line.insert(0, " ");
            gap --;
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
            if ((currlength + word.length() > this.textWidth) && (currlength > 0)) {
                rightLint(sbline);
                super.add(sbline.toString());
                sbline.delete(0, sbline.length());
            }
            if (sbline.length() > 0)
                sbline.append(" ");
            sbline.append(word);
        }
        if (sbline.length() > 0) {
            rightLint(sbline);
            super.add(sbline.toString());
        }
        return true;
    }

}
