package _215;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int findKthSmallest(int[] nums, int start, int end, int k) {
        int i = start;
        int j = end - 1;
        int pivot = nums[end];

        while (i <= j) {
            while (i < end && nums[i] <= pivot) {
                i++;
            }

            while (j >= start && nums[j] > pivot) {
                j--;
            }

            if (i <= j)
                swap(nums, i, j);
        }

        swap(nums, i, end);

        int pth = i - start + 1;
        if (pth == k)
            return nums[i];
        else if (k < pth)
            return findKthSmallest(nums, start, i - 1, k);
        else
            return findKthSmallest(nums, i + 1, end, k - pth);
    }

//    private int findKthSmallest(int[] nums, int start, int end, int k) {
//        int pivot = nums[end];
//        int left = start;
//
//        for (int i = start; i < end; i++) {
//            if (nums[i] <= pivot) {
//                swap(nums, left, i);
//                left++;
//            }
//        }
//        swap(nums, left, end);
//
//        int pth = left - start + 1;
//        if (pth == k)
//            return nums[left];
//        else if (k < pth)
//            return findKthSmallest(nums, start, left - 1, k);
//        else
//            return findKthSmallest(nums, left + 1, end, k - pth);
//    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4, 1}, 6));
        System.out.println(new Solution().findKthLargest(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
        System.out.println(new Solution().findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 3));
    }
}
