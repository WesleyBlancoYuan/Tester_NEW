package com.WindThunderStudio.Interview.Bandit_Yapiko;

public class Recursive {
    public static void main(String[] args) {
        Recursive recursive = new Recursive();
        System.out.println(recursive.recursive(38));
    }
    
    public int recursive(int n)
    {
       if (n <= 10){
          return n * 2;
       }else{
          return recursive(recursive(n / 3));
       }
    }
}
