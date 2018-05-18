package com.WindThunderStudio.Interview.Privalia;

import java.util.Stack;
import java.util.regex.Pattern;
/**
 * 
 * A Calculator using Stack to do arithmetic operations. 
 * (+-\*\/), without parenthesis.
 * Took me 5 hours. 
 * @author WesternGun
 *
 */
public class StackCalculator {
    private StringBuilder number;
    private Stack<Character> symbols;
    private Stack<Integer> numbers;
    private char[] chars;

    public int solution(String exp) {
        if (exp != null && !exp.isEmpty()) {
            chars = exp.toCharArray();
            number = new StringBuilder("");
            symbols = new Stack<>();
            numbers = new Stack<>();
            for (int i = 0; i < exp.length(); i++) {
                String current = new String(new char[] { chars[i] });
                if (Pattern.matches("[0-9]", current)) {
                    number.append(chars[i]);
                    if (i != exp.length() - 1) {
                        continue;
                    } else {
                        calculate(exp, i);
                    }
                } else {
                    calculate(exp, i);
                }
            }
            return numbers.pop();
        }
        return -1;
    }
    
    private void calculate(String exp, int i) {
        try {
            int numberint = Integer.parseInt(number.toString());
            if (chars[i] == '+' || chars[i] == '-') {
                if (symbols.empty()) {
                    numbers.push(new Integer(numberint));
                    symbols.push(chars[i]);
                    number = new StringBuilder("");
                    return;
                } else if (symbols.peek() == '*') {
                    int result = numbers.pop() * numberint;
                    numbers.push(result);
                } else if (symbols.peek() == '/') {
                    int result = numbers.pop() / numberint;
                    numbers.push(result);
                } else if (symbols.peek() == '+') {
                    int result = numbers.pop() + numberint;
                    numbers.push(result);
                } else if (symbols.peek() == '-') {
                    int result = numbers.pop() - numberint;
                    numbers.push(result);
                }
                symbols.pop();
                symbols.push(chars[i]);
                number = new StringBuilder("");
                return;
            } else if (chars[i] == '*' || chars[i] == '/') {
                if (symbols.empty()) {
                    symbols.push(chars[i]);
                    numbers.push(new Integer(numberint));
                    number = new StringBuilder("");
                    return;
                } else if (symbols.peek() == '*') {
                    int result = numbers.pop() * numberint;
                    numbers.push(result);
                } else if (symbols.peek() == '/') {
                    int result = numbers.pop() / numberint;
                    numbers.push(result);
                } else if (symbols.peek() == '+' || symbols.peek() == '-') {
                    symbols.push(chars[i]);
                    numbers.push(new Integer(numberint));
                    number = new StringBuilder("");
                    return;
                }

                symbols.pop();
                symbols.push(chars[i]);
                number = new StringBuilder("");
                return;
            } 
            if (i == exp.length() - 1) { //last number
                numbers.push(numberint);
                while (!symbols.empty()) {
                    int op2 = numbers.pop();
                    int op1 = numbers.pop();
                    int result = 0;
                    if (symbols.peek() == '*') {
                        result = op1 * op2;
                    } else if (symbols.peek() == '/') {
                        result = op1 / op2;
                    } else if (symbols.peek() == '+') {
                        result = op1 + op2;
                    } else if (symbols.peek() == '-') {
                        result = op1 - op2;
                    }
                    symbols.pop();
                    numbers.push(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
