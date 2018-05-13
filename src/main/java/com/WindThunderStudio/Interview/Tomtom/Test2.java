package com.WindThunderStudio.Interview.Tomtom;

import java.util.Arrays;
/**
 * magnitude pole
 * @author yangliang.ding
 *
 */
public class Test2 {
    class Solution {
        public int solution(int[] A) {
            int N = A.length;
            boolean[] minA = new boolean[N];
            boolean[] maxA = new boolean[N];
            
            int max = A[0];
            int min = A[N-1];
            /* when the index increases, find the max value;
              if not max, is false */
            for (int i=0; i<N; i++) {
                if (A[i] >= max) {
                    max = A[i];
                    minA[i] = true;
                } else {
                    minA[i] = false;
                }
            }

            /* when the index decreases, find the min value;
              if not min, is false */
            for (int i=N-1; i>=0; i--) {
                if (A[i] <= min) {
                    min = A[i];
                    maxA[i] = true;
                } else {
                    maxA[i] = false;
                }
            }

            /* when one value is the max in the first array, and
              is the min in the second array, it is the magnitude pole.*/
            for (int i=0; i<N; i++) {
                if (minA[i] && maxA[i]) {
                    return i;
                }
            }
            /* if nothing is returned till now, there is not magnitude pole. */
            return -1;
        }
    }
}
