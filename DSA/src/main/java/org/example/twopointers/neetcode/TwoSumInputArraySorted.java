package org.example.twopointers.neetcode;

import java.util.Arrays;

public class TwoSumInputArraySorted {
    public static int[] twoSum(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while ( nums[low] + nums[high] !=target){

            if (nums[low] + nums[high] < target){
                low ++ ;
            }else{
                high ++;
            }

        }
        return new int[]{low+1 , high+1};
    }

    public static void main (String args[]){
        int[] nums = {2,3,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }
}
