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
        
        for (int i=0; i<words.size(); i++) {
            if (words.get(i).length() >= lineWidth) {
                lineWidth = words.get(i).length();
            }
        }
        char[] output = null;
        StringBuilder sb2 = new StringBuilder("");
        StringBuilder line = null;
        for (String word: words) {
            line = new StringBuilder("");
            for (int i=0; i<lineWidth; i++) {
                line.append(" ");
            }
            switch (just) {
            case 'l':
                line.replace(0, word.length(), word);
                break;
                
            case 'r':
                line.replace(lineWidth-word.length(), lineWidth, word);
                break;
                
            case 'c':
                
                int rest = lineWidth-word.length(); //all the spaces' length
                int begin = 0;
                if (rest % 2 != 0) {
                    begin = (int)(rest/2)+1;
                } else {
                    begin = rest/2;
                }
                
                line.replace(begin, begin+word.length(), word);
                break;
            }
            
            line.append('\n');
            sb2.append(line);
        }
        
        
        output = sb2.toString().toCharArray();
        return output;
    }
    
}
