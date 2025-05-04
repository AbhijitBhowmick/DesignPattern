package org.example.arraysandhashing.neetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestConsecutiveSequence {
    //Approach 3: HashSet and Intelligent Sequence Building
    public static int longestConsecutiveSequence(int[] nums){
        Set<Integer> integerSet = IntStream.of(nums).boxed().collect(Collectors.toSet());

        int longestStreak = 0;

        for (int num : integerSet){
            if(!integerSet.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                while(integerSet.contains(currentNum+1)){
                    currentNum += 1 ;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }


        }
        return  longestStreak ;
    }


    public static void main(String args[]){
        int[] nums = {2, 3, 4,5,1,2,10};
        System.out.printf("longestConsecutiveSequence: %s%n", longestConsecutiveSequence(nums));

    }
}
