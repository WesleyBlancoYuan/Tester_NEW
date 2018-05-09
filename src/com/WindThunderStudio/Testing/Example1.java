package com.WindThunderStudio.Testing;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Example1 extends TestCase{
    protected void testClass() {
        assertNotNull("MyClass is not null", new MyClass());
    }
    protected void testString(String input) {
        assertFalse("The string is not empty", input.isEmpty());
    }
    
    public static void main(String[] args) {
        TestCase testCase = new Example1() {
            @Override
            protected void runTest() throws Throwable {
                testClass();
                System.out.println("Good Class");
                testString("SSSS");
                System.out.println("Good String");
            }
        };
        
        testCase.run();
        
    }
}

class MyClass {
    public MyClass() {
        
    }
}

