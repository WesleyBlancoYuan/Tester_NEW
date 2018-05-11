package com.WindThunderStudio.Testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Example1 {
    private String input;
    
    public Example1(String input) {
        this.input = input;
    }
    @Test
    public void testClass() {
        assertNotNull("MyClass is not null", new MyClass());
    }
    @Test
    public void testString() {
        assertFalse("The string should not be empty", input.isEmpty());
    }
    @Parameters
    public static Collection stringVals() {
        return Arrays.asList(new Object[][] {
            {"SSS"},{""},{"abcd"},{"Hello world"}
        });
    }
    
}

class MyClass {
}

