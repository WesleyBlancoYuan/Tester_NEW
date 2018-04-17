package com.WindThunderStudio.Interview.Tomtom;

import java.util.Arrays;

public class Test2 {
    class Solution {
        public int solution(int[] A) {
            int N = A.length;
            int[] sum1 = new int[N];
            int[] sum2 = new int[N];
            int[] sum2Rev = new int[N];
            sum1[0] = A[0];
            for (int i=1; i<N; i++) {
                sum1[i] = A[i] + sum1[i-1];
            }
            System.out.println(sum1);
            sum2[0] = A[N-1];
            for (int i=N-2; i>=0; i--) {
                sum2[i] = A[i] + sum2[i+1];
            }
            System.out.println(sum2);
            for (int i=0; i<N; i++) {
                sum2Rev[i] = sum2[N-1-i];
            }
            System.out.println(sum2Rev);
            
            for (int i=0; i<N; i++) {
                if (sum1[i]<=(i+1)*A[i] && sum2Rev[i]>= (N-1-i)*A[i]) {
                    return i;
                }
            }
            return -1;
        }
    }
}
