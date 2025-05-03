package org.example.arraysandhashing.neetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return IntStream.range(0, nums.length)
                .mapToObj(i -> {
                    int complement = target - nums[i];
                    if (map.containsKey(complement)) {
                        return new int[]{map.get(complement), i};
                    }
                    map.put(nums[i], i);
                    return null;
                })
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(new int[]{});
    }
    public static void main (String args[]){
            int[] nums = {2,3,4};
            int target = 6;
            System.out.println(Arrays.toString(twoSum(nums, target)));

    }
}
