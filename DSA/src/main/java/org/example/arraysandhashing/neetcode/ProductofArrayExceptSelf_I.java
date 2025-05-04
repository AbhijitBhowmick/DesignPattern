package org.example.arraysandhashing.neetcode;

import java.util.Arrays;

public class ProductofArrayExceptSelf_I {
    public static long[] productExceptSelf(int[] nums) {
        // First pass: count zeros and product of non-zero elements
        int product = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        // Second pass: build result using functional style
        final int finalProduct = product;
        final int finalZeroCount = zeroCount;
        return Arrays.stream(nums)
                .mapToLong(x -> {
                    if(finalZeroCount >1){
                        return 0;
                    }else if(finalZeroCount ==1){
                        return x==0? finalProduct :0;
                    }else {
                        return finalProduct/x ;
                    }
                })
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums))); // Output: [0, 0, 9, 0, 0]
    }
}
