package com.WindThunderStudio.ExceptionCast;

public class ExceptionCaster {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt("ss");
        } catch (Exception e) {
            printExc(e);
        }
    }
    
    static void printExc(Exception e) {
        System.err.println(e.toString());
    }
}
