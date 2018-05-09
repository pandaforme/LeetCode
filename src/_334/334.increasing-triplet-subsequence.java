package _334;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= firstMin)
                firstMin = num;
            else if (num <= secondMin)
                secondMin = num;
            else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new Solution().increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        System.out.println(new Solution().increasingTriplet(new int[]{5, 1, 5, 5, 2, 5, 4}));
        System.out.println(new Solution().increasingTriplet(new int[]{2, 1, 5, 0, 3}));
        System.out.println(new Solution().increasingTriplet(new int[]{5, 4, 6, 9, 2, 3, 1, 10, 11}));
    }
}
