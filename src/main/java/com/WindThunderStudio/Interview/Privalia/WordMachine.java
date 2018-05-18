package com.WindThunderStudio.Interview.Privalia;

import java.util.Stack;
import java.util.regex.Pattern;

public class WordMachine {
    
    class Solution {
        public int solution(String S) {
            String[] ops = S.split(" ");
            double max = Math.pow(2, 20) - 1;
            Stack<Integer> seq = new Stack<>();
            for (int i=0; i<ops.length; i++) {
                if (Pattern.matches("[0-9]*", ops[i])) {
                    if (seq.size()>=2000) {
                        return -1;
                    } else {
                        try {
                            Integer current = new Integer(Integer.parseInt(ops[i]));
                            if (current > max || current < 0) {
                                return -1;
                            } else {
                                seq.push(current);
                            }
                        } catch (NumberFormatException e) {
                            return -1;
                        }
                    }
                } else {
                    switch ((String)ops[i]) {
                    case "POP":
                        if (seq.size() == 0) {
                            return -1;
                        } else {
                            seq.pop();
                        }
                        break;
                    case "DUP":
                        if (seq.size() == 0 || seq.size() == 2000) {
                            return -1;
                        } else {
                            Integer dup = (Integer)seq.peek();
                            seq.push(dup);
                        }
                        break;
                    case "+":
                        if (seq.size() <= 1) {
                            return -1;
                        } else {
                            Integer op1 = seq.pop();
                            Integer op2 = seq.pop();
                            Integer sum = op1 + op2;
                            if (sum > max) {
                                return -1;
                            }
                            seq.push(sum);
                        }
                        break;
                    case "-":
                        if (seq.size() <= 1) {
                            return -1;
                        } else {
                            Integer op1 = seq.pop();
                            Integer op2 = seq.pop();
                            if (op1 < op2) {
                                return -1;
                            } else {
                                Integer diff = op1 - op2;
                                seq.push(diff);
                            }
                        }
                        break;
                    } 
                }
            }
            if (seq.size() < 1) {
                return -1;
            } else {
                return seq.peek();
            }
        }
    }
}
