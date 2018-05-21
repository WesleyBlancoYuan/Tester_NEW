package com.WindThunderStudio.Interview.Privalia;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.WindThunderStudio.Interview.Privalia.WordMachine.Solution;

@RunWith(Parameterized.class)
public class WordMachineTest {
    @Parameter(0)
    public String input;
    @Parameter(1)
    public int output;
    public Solution cal;
    
    public WordMachineTest() {
        this.cal = new WordMachine().new Solution();
    }
    @Parameters
    public static Collection paramTest() {
        return Arrays.asList(new Object[][] {
            {"13 DUP 4 POP 5 DUP + DUP + -", 7}
        });
    }
    
    @Test
    public void testCalculator() {
        assertEquals(input + " was expected to equal to " + output, output, cal.solution(input));
    }
}
