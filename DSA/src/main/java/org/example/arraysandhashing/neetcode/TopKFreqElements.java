package org.example.arraysandhashing.neetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFreqElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Long> freqmap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        return freqmap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main (String args[]){
        int[] nums = {1,1,1,2,2,3};
        int k = 2 ;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

    }
}
