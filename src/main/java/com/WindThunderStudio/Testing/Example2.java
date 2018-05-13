package com.WindThunderStudio.Testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class Example2 {
    @Parameter(0) // cannot be private if we use @Parameter
    /* private */ public String numberStr;
    @Parameter(1) // cannot be private if we use @Parameter
    /* private */ public long number;
    
//    public Example2(String string, long number) {
//        this.numberStr = string;
//        this.number = number;
//    }
    
    @Test(expected=NumberFormatException.class) //only when we want to have an exception, we do "expect="
    public void testStringShouldEqualsToNumberWithException() throws Exception {
        assertEquals("The string parsed does not equal to the number", Long.parseLong(numberStr), number);
    }
    @Test
    public void testStringShouldEqualsToNumberNoException(){
        assertEquals("The string parsed does not equal to the number", Long.parseLong(numberStr), number);
    }
    
    @Parameters(name = "{index}: convert string: {0} -> {1}")
    public static Collection stringAndNumber() {
        return Arrays.asList(new Object[][] {
            {"123", 123}, {"3333", 3333}, {"343434343434", 34343434}, {"sss", 1}
        });
    }
    
}
