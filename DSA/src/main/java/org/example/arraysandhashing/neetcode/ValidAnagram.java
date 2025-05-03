package org.example.arraysandhashing.neetcode;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;

        Map<Character,Long> sFreq = s.toLowerCase().chars().mapToObj(c ->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Map<Character,Long> tFreq = t.toLowerCase().chars().mapToObj(c ->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        return sFreq.equals(tFreq);
      }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t)); // true
    }



    }

