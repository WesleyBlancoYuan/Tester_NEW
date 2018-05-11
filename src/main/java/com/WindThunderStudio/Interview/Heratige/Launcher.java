package com.WindThunderStudio.Interview.Heratige;

public class Launcher {
    public static void main(String[] args) {
        Bird b = new Bird();
        b.fly();
        
        Superman sp = new Superman();
        sp.fly();
        
        SupermanSon sss = new SupermanSon();
        sss.fly();
    }
}
