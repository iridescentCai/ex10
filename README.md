**CPEN 221 / Fall 2020 / Exercise 10**

Text Formatting
=========

`FormattedText` is a datatype that essentially represents a sequence of lines (of text). It has four methods:

1. `boolean add(String line)` that allows one to add a line of text and it returns true (in all cases except when `line` is `null` and `line` is `""`);
2. `String toString()` that returns a `String` representation of the text;
3. `int numlines()` that returns the number of lines of text.
4. `int wordCount()` that returns the number of words in the text. A word is a sequence of any non-whitespace characters separated from other words by whitespace.

`FormattedText` is an `interface` in Java. This `interface` is implemented by the `AbstractFormattedText` class, which is an `abstract class`.

**TODO**: You should implement the `wordCount()` in `AbstractFormattedText`.

**TODO**: You should implement the `RightJustifiedText` class that is a concrete class that extends `AbstractFormattedText`. `RightJustifiedText` maintains text with right justification: if the text in a line is shorter than the width of the line then all the additional whitespace appears at the left of the line and the text is pushed to the right.

* Once text is formatted, each line of text contains exactly one space between words.

+ If a line is longer than the line width then it is split into additional lines such that no line is greater than the line width and no word is split over two lines (and each line is as long as possible).
+ If a single word is greater than the width of a line then it should be in a separate line (and it is okay to violate the line width in this case).

For this task, a **word** is a contiguous sequence of characters and words are separated by a space (or multiple white space characters as the case may be -- read the requirements carefully).

> You are provided the implementation of a `CentredText` class that is similar to `RightJustifiedText` but keeps the text centred.
>
> This exercise emphasizes the use of `interface`s and `abstract class`es.
>
> Use the provided test cases to guide your implementation.

## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes **unless asked to**.
+ You can use additional standard Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.
