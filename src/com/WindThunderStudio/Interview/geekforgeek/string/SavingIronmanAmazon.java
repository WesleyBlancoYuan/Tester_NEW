package com.WindThunderStudio.Interview.geekforgeek.string;
/**
 * https://practice.geeksforgeeks.org/problems/save-ironman/
 * Jarvis is weak in computing palindromes for Alphanumeric characters.
 * While Ironman is busy fighting Thanos, he needs to activate sonic punch but Jarvis is stuck in computing palindromes.
 * You are given a string containing the alphanumeric character. Find whether the string is palindrome or not.
 * If you are unable to solve it then it may result in the death of Iron Man.
 * 
 * Input:
 * The first line of the input contains t, the number of test cases. Each line of the test case contains string 'S'.
 * 
 * Output:
 * Each new line of the output contains "YES" if the string is palindrome and "NO" if the string is not a palindrome.
 * 
 * Constraints:
 * 1<=t<=100
 * 1<=|S|<=100000
 * Note: Consider alphabets and numbers only for palindrome check. Ignore symbols and whitespaces.
 * 
 * Example:
 * Input:
 * 2
 * I am :IronnorI Ma, i
 * Ab?/Ba
 * 
 * Output:
 * YES
 * YES
 * @author yangliang.ding
 *
 */
public class SavingIronmanAmazon {
    public static void main(String[] args) {
        SavingIronmanAmazon savingIronmanAmazon = new SavingIronmanAmazon();
        String s1 = "I ám :IronnorI Má, i";
        String s2 = "Ab?/Ba";
        System.out.println(savingIronmanAmazon.saveIronman(s1));
        System.out.println(savingIronmanAmazon.saveIronman(s2));
    }
    public String saveIronman(String s) {
        //remove all non-alphanumeric characters in a string
        // - if all letters are latin letters:
        String noSymbol = s.replaceAll("[^a-zA-Z0-9]", "");
        // - if we must consider Unicode letters: \\p{L} is the definition of an Unicode letter, according to:
        // https://stackoverflow.com/questions/43263680/removing-all-characters-but-letters-in-a-string#answer-43263912
        // and:
        // http://www.regular-expressions.info/unicode.html#prop.
        // \\P{L}: not letter \\p{L}: letter
        String noSymbolUnicode = s.replaceAll("[\\P{L}0-9]", "");
        // the most complete case:\P{M}\p{M}*+, to match different encoding of letters with diacritics. (one code point or two)
        //String noSymbolUnicodeComplete = s.replaceAll("[\\P{M}\p{M}*+0-9]", ""); //not working
        
        //delete whitespace
        //noSymbolUnicodeComplete = noSymbolUnicodeComplete.replaceAll(" ", "");
        noSymbolUnicode = noSymbolUnicode.toLowerCase();
        
        System.out.println("Preprocessed string: " + noSymbolUnicode);
        if (noSymbolUnicode.length() == 1) {
            return "YES";
        } else {
            int length = noSymbolUnicode.length();
            for (int i=0; i<(int)length/2; i++) { //no matter is even or odd
                if (noSymbolUnicode.charAt(i) != noSymbolUnicode.charAt(length-1-i)) {
                    return "NO";
                } else {
                    continue;
                }
                
            }
            return "YES";
        }
    }
}
