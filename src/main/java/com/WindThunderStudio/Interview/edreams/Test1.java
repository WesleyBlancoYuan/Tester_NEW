package com.WindThunderStudio.Interview.edreams;

/**
 * sum-distance: for pairs of index (P, Q), we know that 0<=P<=Q<=N,
 * and we define the sum-distance as: A[P] + A[Q] + (Q-P).
 * For an array A of dimension N, return the maximun of sum-distance.
 * A[N] is in the range of [-10^8, 10^8], and N is in the range of [1, 2^32-1] (I don't remember this part)
 * And the time complexity, at worst case: O(N). Space complexity, at worst: O(1).
 * @author yangliang.ding
 *
 */
public class Test1 {
    public int solution(int[] A) {
        int N = A.length;
        int sumP = Integer.MIN_VALUE*2;
        int sumQ = Integer.MIN_VALUE*2;
        int positionP = 0;
        int positionQ = 0;
        for (int i=0; i<N; i++) {
            //sumP = Math.max(sumP, A[i] - i);
            //sumQ = Math.max(sumQ, A[i] + i);
            if (A[i] - i > sumP) {
                sumP = A[i] - i;
                positionP = i;
                System.out.println("Now P is: " + positionP);
            }
            if (A[i] + i > sumQ) {
                sumQ = A[i] + i;
                positionQ = i;
                System.out.println("Now Q is: " + positionQ);
            }
        }
        System.out.println("Position P: " + positionP + " Position Q: " + positionQ + " P <= Q: " + (positionP <= positionQ));
        return sumP + sumQ;
    }
}
