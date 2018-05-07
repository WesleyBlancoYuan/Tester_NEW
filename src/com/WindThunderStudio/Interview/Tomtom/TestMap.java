package com.WindThunderStudio.Interview.Tomtom;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 555);
        map.put(2, 666);
        map.put(3, 777);
        System.out.println(map.size());
        for (Integer i: map.keySet()) {
            System.out.println(map.get(i));
        }
        
        Integer r = (Integer)map.get(1);
        System.out.println(map.size());
        for (Integer i: map.keySet()) {
            System.out.println(map.get(i));
        }
    }
}
