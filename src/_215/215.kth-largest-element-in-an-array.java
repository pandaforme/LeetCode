package _215;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int findKthSmallest(int[] nums, int start, int end, int k) {
        int pivot = nums[end];

        int small = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, small, i);
                small++;
            }
        }

        swap(nums, small, end);

        int pth = small - start + 1;
        if (pth == k)
            return nums[small];
        else if (pth > k)
            return findKthSmallest(nums, start, small - 1, k);
        else
            return findKthSmallest(nums, small + 1, end, k - pth);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{1}, 1));
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
