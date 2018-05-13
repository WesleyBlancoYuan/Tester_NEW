package com.WindThunderStudio.Assign1Q2;

public class StringBuilderReplaceTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(10);
        for (int i=0; i<10; i++){
            sb.append(" ");
        }
        sb.replace(3, 5, "at");
        System.out.println(sb.toString());
    }
}
