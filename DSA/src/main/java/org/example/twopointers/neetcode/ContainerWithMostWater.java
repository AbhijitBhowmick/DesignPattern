package org.example.twopointers.neetcode;

import java.util.Arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {

        int maxArea = 0;

        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }


            maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));

        }

        return maxArea;
    }




    public static void main (String args[]){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int target = 6;
        System.out.println(maxArea(height));

    }
}
