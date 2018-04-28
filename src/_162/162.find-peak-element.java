package _162;

class Solution {
    public int findPeakElement(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }

    private int helper(int start, int end, int[] nums) {
        if (start > end)
            return -1;

        int middle = (start + end) / 2;

        if (((middle - 1 < 0) || nums[middle] > nums[middle - 1]) && ((middle + 1 > end) || nums[middle] > nums[middle + 1]))
            return middle;

        if (middle - 1 >= 0 && nums[middle - 1] > nums[middle])
            return helper(start, middle - 1, nums);
        else
            return helper(middle + 1, end, nums);
    }

//    // brute force
//    public int findPeakElement(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int beforeIndex = i - 1;
//            int beforeValue = Integer.MIN_VALUE;
//            int afterIndex = i + 1;
//            int afterValue = Integer.MIN_VALUE;
//
//            if (beforeIndex >= 0)
//                beforeValue = nums[beforeIndex];
//
//            if (afterIndex < nums.length)
//                afterValue = nums[afterIndex];
//
//            boolean biggerThanLeft = false;
//            if (beforeValue == Integer.MIN_VALUE)
//                biggerThanLeft = true;
//            else
//                biggerThanLeft = (nums[i] > beforeValue);
//
//
//            boolean biggerThanRight = false;
//            if (afterValue == Integer.MIN_VALUE)
//                biggerThanRight = true;
//            else
//                biggerThanRight = (nums[i] > afterValue);
//
//            if (biggerThanLeft && biggerThanRight)
//                return i;
//        }
//
//        return -1;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPeakElement(new int[]{Integer.MIN_VALUE}));
        System.out.println(new Solution().findPeakElement(new int[]{1, 2}));
        System.out.println(new Solution().findPeakElement(new int[]{3, 2, 1}));
        System.out.println(new Solution().findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
