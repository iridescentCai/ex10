package textformatter;

public interface FormattedText {

    /**
     * Add a line of text.
     *
     * @param line represents a line of text
     * @return true after the new line of text has been added to the existing
     * except when line is null or "" in which case nothing is added and
     * false is returned
     */
    public boolean add(String line);

    /**
     * Obtain the number of lines of text.
     * @return the number of lines in the FormattedText
     */
    public int numlines();

    /**
     * Obtain the number of words in the text. A "word" is any sequence
     * of non-whitespace characters separated by whitespace from other words.
     *
     * @return the number of words in this FormattedText
     */
    public int wordCount();


}
