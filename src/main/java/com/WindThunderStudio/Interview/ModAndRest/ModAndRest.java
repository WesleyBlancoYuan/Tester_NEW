package com.WindThunderStudio.Interview.ModAndRest;

public class ModAndRest {
    public static void main(String[] args) {
        System.out.println("In Java, '%' is not mod, is rest. The flooring is towards 0, not negative infinity. ");
        System.out.println(49 % 100); //49
        System.out.println(-49 % 100); //-49, because -49/100 = 0, not -1.
    }
}
