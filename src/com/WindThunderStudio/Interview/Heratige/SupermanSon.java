package com.WindThunderStudio.Interview.Heratige;

public class SupermanSon extends Superman {
    @Override
    public void fly() {
        super.fly();
        System.out.println("I am little superman!");
    }
}
