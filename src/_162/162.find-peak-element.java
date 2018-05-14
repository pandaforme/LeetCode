package _162;

class Solution {
    public int findPeakElement(int[] nums) {
        return hepler(nums, 0, nums.length - 1);
    }

    private int hepler(int[] nums, int start, int end) {
        int middle = (start + end) / 2;

        boolean leftPart = (middle - 1 < start) || nums[middle - 1] < nums[middle];
        boolean rightPart = (middle + 1 > end) || nums[middle] > nums[middle + 1];
        if (leftPart && rightPart)
            return middle;

        if (middle - 1 >= start && nums[middle - 1] > nums[middle])
            return hepler(nums, start, middle - 1);
        else
            return hepler(nums, middle + 1, end);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
