package _11;

class Solution {
    public int maxArea(int[] height) {
        int result = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            result = Math.max(result, w * h);

            if (h == height[left])
                left++;
            else
                right--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().maxArea(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new Solution().maxArea(new int[]{7, 8, 3, 4, 2}));
    }
}
