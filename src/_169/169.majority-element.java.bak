package _169;

class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count = 1;
            } else if (nums[i] == majority) {
                count++;
            } else if (nums[i] != majority) {
                count--;
            }
        }

        return majority;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(new Solution().majorityElement(new int[]{3, 2, 3}));
    }
}
