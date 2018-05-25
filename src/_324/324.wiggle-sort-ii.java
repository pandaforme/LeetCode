package _324;

import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        int median = findKth(nums, 0, nums.length - 1, (int) Math.ceil(nums.length / 2d));

        int[] tmp = new int[nums.length];
        int small = 0;
        int big = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < median) {
                tmp[small] = nums[i];
                small++;
            } else if (nums[i] > median) {
                tmp[big] = nums[i];
                big--;
            }
        }

        for (int i = small; i <= big; i++) {
            tmp[i] = median;
        }

        big = nums.length - 1;
        small = (nums.length % 2 == 0) ? nums.length / 2 - 1 : nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                nums[i] = tmp[big];
                big--;
            } else {
                nums[i] = tmp[small];
                small--;
            }
        }
    }

    private int findKth(int[] nums, int start, int end, int k) {
        if (start > end)
            return -1;

        int pivot = nums[end];
        int less = start;

        for (int i = start; i <= end - 1; i++) {
            if (nums[i] <= pivot) {
                swap(nums, less, i);
                less++;
            }
        }

        swap(nums, less, end);

        int pth = less - start + 1;
        if (pth == k)
            return nums[less];

        if (pth > k)
            return findKth(nums, start, less - 1, k);
        else
            return findKth(nums, less + 1, end, k - pth);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        new Solution().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{3, 2, 2, 2, 6};
        new Solution().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 3, 2, 2, 3};
        new Solution().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 3, 2, 2, 3, 1};
        new Solution().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));


        nums = new int[]{4, 5, 5, 6};
        new Solution().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 3, 2, 2, 2, 1, 1, 3, 1, 1, 2};
        new Solution().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

    }



}
