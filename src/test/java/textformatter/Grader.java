package textformatter;

import org.junit.Test;

import static org.junit.Assert.*;

public class Grader {

    @Test
    public void test1() {
        AbstractFormattedText text = new RightJustifiedText(10);
        text.add("abc");
        text.add("defghi");
        assertEquals(2, text.numlines());
    }

    @Test
    public void test2() {
        AbstractFormattedText text = new RightJustifiedText(10);
        assertEquals(0, text.numlines());
    }

    @Test
    public void test3() {
        AbstractFormattedText text = new RightJustifiedText(30);
        text.add("Help!");
        text.add("Et tu, Brute?");
        assertEquals(2, text.numlines());
    }

    @Test
    public void test4() {
        AbstractFormattedText text = new RightJustifiedText(30);
        text.add("Help!");
        text.add("Et tu, Brute?");
        String expectedOutput = "                         Help!\n" + "                 Et tu, Brute?\n";
        // note that \n denotes a new line
        // and is not considered part of the line width
        assertEquals(expectedOutput, text.toString());
    }

    @Test
    public void test5() {
        AbstractFormattedText text = new RightJustifiedText(30);
        text.add("1234567890 1234567890 123456789 012345.");
        String expectedOutput = "         1234567890 1234567890\n" + "             123456789 012345.\n";
        assertEquals(expectedOutput, text.toString());
    }

    @Test
    public void test6() {
        AbstractFormattedText text = new RightJustifiedText(10);
        text.add("abcdefghijkl");
        String expectedOutput = "abcdefghijkl\n";
        assertEquals(expectedOutput, text.toString());
    }

    @Test
    public void test7() {
        AbstractFormattedText text = new RightJustifiedText(10);
        text.add("abcd abcdefghijkl");
        String expectedOutput = "      abcd\n" + "abcdefghijkl\n";
        assertEquals(expectedOutput, text.toString());
    }

    @Test
    public void test8() {
        AbstractFormattedText text = new RightJustifiedText(30);
        text.add("123 456 789 1011 121314 15161718");
        String expectedOutput = "       123 456 789 1011 121314\n" + "                      15161718\n";
        assertEquals(expectedOutput, text.toString());
        assertEquals(2, text.numlines());
    }

    @Test
    public void test9() {
        AbstractFormattedText text = new RightJustifiedText(11);
        text.add("111");
        text.add("222");
        text.add("333");
        text.add("4444444");
        String expectedOutput = "        111\n" + "        222\n" + "        333\n" + "    4444444\n";
        assertEquals(expectedOutput, text.toString());
    }

    @Test
    public void test10() {
        AbstractFormattedText text = new RightJustifiedText(11);
        assertEquals(false, text.add(""));
    }


    @Test
    public void test11() {
        AbstractFormattedText text = new RightJustifiedText(11);
        text.add("111\n222\n333");
        assertEquals("111 222 333\n", text.toString());
    }

    @Test
    public void test12() {
        AbstractFormattedText text = new RightJustifiedText(11);
        text.add("111 222 333 444");
        assertEquals("111 222 333\n        444\n", text.toString());
    }

    @Test
    public void test13() {
        AbstractFormattedText text = new RightJustifiedText(11);
        text.add("111\n222\n333\n444");
        assertEquals("111 222 333\n        444\n", text.toString());
    }

    @Test
    public void test14() {
        AbstractFormattedText text = new RightJustifiedText(11);
        text.add("abcdefghijkl\nabc");
        assertEquals("abcdefghijkl\n        abc\n", text.toString());
    }

    @Test
    public void test15() {
        AbstractFormattedText text = new RightJustifiedText(11);
        text.add("abcdefghijkl\nabc");
        assertEquals(2, text.wordCount());
    }

    @Test
    public void test16() {
        AbstractFormattedText text = new RightJustifiedText(11);
        text.add("111\n222\n333\n444");
        assertEquals(4, text.wordCount());
    }

    @Test
    public void test17() {
        AbstractFormattedText text = new RightJustifiedText(11);
        text.add("111\n222\n333\n444");
        text.add("111 222");
        text.add("333");
        assertEquals(7, text.wordCount());
    }

    @Test
    public void test18() {
        AbstractFormattedText text = new RightJustifiedText(11);
        text.add("abcdef+ghi");
        text.add("333");
        assertEquals(2, text.wordCount());
    }

}
