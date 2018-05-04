package com.WindThunderStudio.Interview.Tomtom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/**
 * Given a N-dimensioned array A, for index K, if A[K] = M, we let that A[K] point to A[M+K].
 * For example, if we have [1, -1, 2, 2, 1, 0], at first K = 0. So:
 *  - A[0] = 1, so A[0] points to A[0+1] = A[1].
 *  - A[1] = -1, so A[1] points to A[1-1] = A[0].
 *  Thus it will not jump out. Return -1.
 *  If M+K >= N, then jump out. Return steps needed for jumping out.
 *  For example, for A=[2, 3, -1, 1, 3]: will jump out in 4 steps.
 *  1<=N<=10^6, -10^6<=A[K]<=10^6.
 *  
 * @author WesternGun
 * 
 * Final result: correct, but I didn't consider that 'next' can be negative!!!! 
 * Index of an array cannot be negative!!!!! Big mistake.
 * 
 * And, the return value should be consistent! always times or times+1:
 * imagine that when I jump out at the first step: A[100000] and jumps out, should return 1.
 */
public class Test1 {
    public static void main(String[] args) {
        Solution s1 = new Test1().new Solution();
        List<Integer> a = new ArrayList<>();
        int[] A = new int[] {2, 3, -1, 1, 3};
//        int[] A = new int[10];
//        for (int i=0; i<10; i++) {
//            A[i] = new Random().nextInt(20) - 10;
//            System.out.println("A has element: " + A[i]);
//        }
        int result = s1.solution(A);
        System.out.println(result);
    }
    class Solution {
        public Solution() {}
        
        public int solution(int[] A) {
            
            int next = A[0] + 0;
            int N = A.length;
            Map<Integer, Integer> count = new HashMap<Integer, Integer>();
            for (int i=0; i<N; i++) {
                count.put(i, 0);
            }
            
            count.put(0, 1); //already pass position 0 once
            int times = 0;
            while (next < N && next >= 0) { /* next index can be negative!!!!! Error!!!! */
                times ++;
                next = A[next] + next;
                System.out.println("Now the next index is: " + next);
                
                if (next > N || next < 0) { /* next index can be negative!!!!! Error!!!! */
                    System.out.println("Now jump out. ");
                    return times+1;
                }
                count.put(next, count.get(next) + 1);
                if (count.get(next) > 1) {
                    System.out.println("Repeated index " + next + ", will not jump out");
                    return -1;
                } else {
                    continue;
                }
                
            }
            return times + 1; //be consistent!!! didn't consider the first step jumping out.
        }
    }
}
