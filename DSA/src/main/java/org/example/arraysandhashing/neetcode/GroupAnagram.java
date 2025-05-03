package org.example.arraysandhashing.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagram {
 public static List<List<String>> groupAnagrams(String[] strs){
    return new ArrayList<>(
            Arrays.stream(strs).collect(Collectors.groupingBy(s -> {
                int[] count = new int[26];
                s.chars().forEach(c -> count[c - 'a']++);
                return Arrays.toString(count);
            })).values()
    );
 }
    public static void main (String args[]){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        int target = 6;
        System.out.println(groupAnagrams(strs));

    }

}
