package org.example.arraysandhashing.neetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> integerMap = new HashMap<>();
//         for (int num :nums) {
//             if (null == integerMap.get(num)) {
//                 integerMap.put( num,num);
//             } else {
//                 break;
//             }
//         }
        //Standard java -no early termination
//        Set<Integer> unique = Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.toSet());
//
//        return unique.size() < nums.length;
//    }
        Optional<Integer> firstDuplicate = Arrays.stream(nums)
                .boxed()
                .filter(num -> integerMap.putIfAbsent(num, num) != null)
                .findFirst();
        return firstDuplicate.isPresent();
    }

    public static void main(String args[]){
        int[] nums = {2, 3, 4,5,1,2};
        System.out.printf("HasDuplicate: %b%n", hasDuplicate(nums));

    }
}
