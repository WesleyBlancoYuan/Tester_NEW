package com.WindThunderStudio.Interview.Tomtom;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        System.out.println(map.size());
        
        Integer r = (Integer)map.get(1);
        System.out.println(map.size());
    }
}
