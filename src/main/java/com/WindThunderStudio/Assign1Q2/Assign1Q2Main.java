package com.WindThunderStudio.Assign1Q2;

public class Assign1Q2Main {
    public static void main(String[] args) {
        String srcText = "The quick brown antidisestablishmentarianistic fox jumps over the lazy dog";
        
        char[] charText = srcText.toCharArray();
        
        char[] outText = Assign1Q2.justify(charText, 20, 'l');
        
        System.out.println();
        System.out.print(outText);
        
        outText = Assign1Q2.justify(charText, 20, 'r');
        System.out.println();
        System.out.print(outText);
        
        outText = Assign1Q2.justify(charText, 20, 'c');
        System.out.println();
        System.out.print(outText);
    }
    
    
}
