package _324;

import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int[] result = new int[nums.length];
        int index = nums.length - 1;
        for (int i = 1; i < result.length; i += 2) {
            result[i] = nums[index];
            index--;
        }

        index = 0;
        for (int i = (nums.length % 2 == 1) ? nums.length - 1 : nums.length - 2; i >= 0; i -= 2) {
            result[i] = nums[index];
            index++;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
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
