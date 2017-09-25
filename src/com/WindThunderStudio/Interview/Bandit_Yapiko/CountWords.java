package com.WindThunderStudio.Interview.Bandit_Yapiko;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CountWords {
    public static void main(String[] args) {
        String sentence = "The cat sat on the mat.  The mat was blue. The cat was brown. The sun was bright.";
        CountWords cw = new CountWords();
        cw.countWords(sentence);
    }
    
    
    public void countWords(String sentence) {
        char[] letters = sentence.toCharArray(); //split sentence into letters
        int letterNum = letters.length; //count letters
        //iterate the array to obtain words
        int begin = 0; //word start index
        int end = 0; //word end index
        boolean moveToNext = false; //flag to mark if begin moves to next word
        //get the words
        List<String> words = new ArrayList<String>(); //don't know the number of words, need a collection that can auto-expand
        for (int i=0; i < letterNum; i++) {
            if (letters[i] != ' ' && letters[i] != '.') {
                if (moveToNext) {begin = i; moveToNext = false;}
                //end++; //wrong
            } else if (!moveToNext){
                String word = sentence.substring(begin, end);
                words.add(word);
//                end++; //wrong: if we have letter not equal to space/period, but moveToNext is true, end will not increment;
                moveToNext = true;
            }
            end++; //cannot use separate end++; end++ every time here is correct; 
            //end must sync with i.
            
        }
        //count the words
        Map<String, Integer> counts = new HashMap<String, Integer>(); //use key to avoid word duplicate
        for (int i=0; i<words.size(); i++) { //initialize set; every word one occurence
            counts.put(words.get(i).toUpperCase(), new Integer(0)); //error: when put key into map, the case may differ, too,
            //must convert all to uppercase/lowercase and then put
        }
        
        //iterate the keyset, find the same word's occurence, save to the value set
        Iterator<String> it = counts.keySet().iterator();
        while (it.hasNext()) {
            String current = it.next();
            for (int i=0; i<words.size(); i++) {
            
                if (words.get(i).equalsIgnoreCase(current)){ //the case may differ
                    int time = ((Integer)counts.get(current)).intValue();
                    time++;
                    counts.put(current, new Integer(time));
                }
            
            }
        }
        
        //output with map
        
        Iterator<String> it2 = counts.keySet().iterator();
        while (it2.hasNext()){
            String now = it2.next();
            System.out.println("The word " + now + " has appeared " + counts.get(now) + " times. ");
        }

        
        
    }
}
