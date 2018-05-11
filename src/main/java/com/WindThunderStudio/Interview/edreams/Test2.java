package com.WindThunderStudio.Interview.edreams;

import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        class Solution {
            public int[] solution(int[] T) {
                int M = T.length;
                int[] result = new int[M]; //including distance 0; return [1, M-1]
                for (int i=0; i<M; i++) {
                    result[i] = 0;
                }
                int capital = 0;
                for (Integer i: T) {
                    if (i == T[i]) {
                        capital = i;
                        break;
                    }
                }
                for (Integer i: T) {
                    if (i == capital) {
                        continue;
                    }
                    int node = 0;
                    int distance = 1;
                    //find the route
                    while (T[node] != capital) {
                        node = T[node];
                        distance ++;
                    }
                    result[distance-1] ++;
                }
                
                return Arrays.copyOfRange(result, 1, M); 
            }
        }
    }

}
