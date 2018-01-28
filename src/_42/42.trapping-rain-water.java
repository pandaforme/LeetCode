package _42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2)
            return 0;

        List<Integer> leftMax = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(height[i], max);
            leftMax.add(max);
        }

        List<Integer> rightMax = new ArrayList<>(Collections.nCopies(height.length, null));
        max = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            rightMax.set(i, max);
        }


        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.min(leftMax.get(i), rightMax.get(i)) - height[i];
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}