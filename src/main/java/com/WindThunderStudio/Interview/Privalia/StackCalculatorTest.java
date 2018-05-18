package com.WindThunderStudio.Interview.Privalia;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StackCalculatorTest {
    @Parameter(0)
    public String input;
    @Parameter(1)
    public int output;
    public StackCalculator cal;
    
    public StackCalculatorTest() {
        this.cal = new StackCalculator();
    }
    @Parameters
    public static Collection paramTest() {
        return Arrays.asList(new Object[][] {
            {"10-3*2", 4}, {"15-6+9/3", 12}, {"3+5-12", -4}, {"3*2-2", 4}, {"3+6/3*2", 7},
            {"2-6*2", -10}, {"5+6-10", 1}, {"5*4-18", 2}, {"25*4-20/5", 96}
        });
    }
    
    @Test
    public void testCalculator() {
        assertEquals(input + " was expected to equal to " + output, output, cal.solution(input));
    }
}
