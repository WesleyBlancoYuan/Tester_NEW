package com.WindThunderStudio.Assign1Q2;

import java.util.ArrayList;
import java.util.List;

public class Assign1Q2 {
    protected static char[] justify(char[] inputText, int lineWidth, char just) {
        StringBuffer sb = new StringBuffer("");
        List<String> words = new ArrayList<String>();
        
        for (int i=0; i<inputText.length; i++) {
            if (inputText[i] != ' ' && inputText[i] != '\n') {
                sb.append(inputText[i]);
            } else {
                inputText[i] = '\n';
                words.add(sb.toString());
                sb = new StringBuffer(""); //clear content
            }
        }
        words.add(sb.toString()); //add last word because the last char is not space/'\n'.
        
        char[] output = null;
        StringBuilder sb2 = new StringBuilder(0);
        for (int i=0; i<words.size(); i++) {
            String word = words.get(i);
            char[] line = new char[lineWidth-1]; //last char is for \n
            switch (just) {
            case 'l':
                for (int j=0; j<word.length(); j++) {
                    line[j] = word.toCharArray()[j];
                }
                break;
                
            case 'r':
                for (int j=lineWidth-1-word.length(); j<lineWidth-1; j++) {
                    line[j] = word.toCharArray()[j-(word.length()-lineWidth-1)];
                }
                break;
                
            case 'c':
                
                int rest = lineWidth-1 - word.length();
                int begin = 0;
                if (rest % 2 != 0) {
                    begin = (int)(rest/2)+1;
                } else {
                    begin = rest/2;
                }
                for (int j=begin; j<begin+word.length(); j++) {
                    line[j] = word.toCharArray()[j-(begin)];
                }
                break;
            }
            
            for (int k=0; k<line.length; k++) {
                sb2.append(line[k]);
            }
            sb2.append('\n');
        }
        output = new char[sb2.length()];
        for (int i=0; i<output.length; i++) {
            output[i] = sb2.charAt(i);
        }
        return output;
//        StringBuilder result = new StringBuilder("");
//        StringBuilder sb2 = null;
//        for (String word: words) {
//            sb2 = new StringBuilder(lineWidth);
//            for (int i=0; i<lineWidth; i++) {
//                sb2.setCharAt(i, ' ');
//            }
//            switch (just) {
//            case 'l':
//                sb2.replace(0, word.length(), word);
//                result.append(sb2).append('\n');
//                break;
//                
//            case 'r':
//                sb2.replace(lineWidth-word.length()-1, lineWidth, word);
//                result.append(sb2).append('\n');
//                break;
//                
//            case 'c':
//                int rest = lineWidth - word.length();
//                if (rest % 2 != 0) {
//                    sb2.replace(((int)(rest/2))+1, lineWidth - rest/2-1, word);
//                } else {
//                    sb2.replace(rest/2, lineWidth - rest/2, word);
//                }
//                result.append(sb2).append('\n');
//                break;
//                
//            default:
//                break;
//            }
//        }
    }
    
}
