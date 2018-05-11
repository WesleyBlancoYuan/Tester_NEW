package com.WindThunderStudio.Interview.codility.a_iteration;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Find the longest binary gap in a binary positive integer
 * (the length of the longest "0"s in a binary number)
 * Input: N ([1, Integer.MAX_VALUE])
 * Time: O(log(N))
 * Space: O(1)
 *
 */

public class BinaryGap {
    public int N;
    
    public int solution(int N) {
        int rest = 0;
        int div = 1;
        int count = 0;
        int maxCount = 0;
        while (div > 0) {
            div = (int)(N/2); //towards 0
            rest = N % 2; // all positive so no difference.
            if (rest == 0) {
                count ++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return maxCount;
    }
}
/**
 * Tester class
 * @author yangliang.ding
 *
 */
@RunWith(Parameterized.class)
class BinaryGapTest {
    @Parameters
    public Collection testWithN() {
        return Arrays.asList(new Object[][] {
                {1}, {1999}, {Integer.MAX_VALUE}, {10000000}
        });
    }
}
