package _75;

import java.util.Arrays;

class Solution {
    public void sortColors(int[] nums) {
        int zeroPointer = 0;
        int twoPointer = nums.length - 1;

        while (zeroPointer < nums.length && nums[zeroPointer] == 0)
            zeroPointer++;

        while (twoPointer >= 0 && nums[twoPointer] == 2)
            twoPointer--;

        for (int i = zeroPointer; i <= twoPointer; i++) {
            if (zeroPointer > twoPointer)
                break;

            if (nums[i] == 0) {
                swap(nums, i, zeroPointer);
                zeroPointer++;
            } else if (nums[i] == 2) {
                swap(nums, i, twoPointer);
                twoPointer--;
                i--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        final int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

//    counting sort
//    public void sortColors(int[] nums) {
//        int[] k = new int[4];
//
//        for (int num : nums) {
//            k[num]++;
//        }
//
//        int index = 0;
//        for (int i = 0; i < k.length; i++) {
//            if (k[i] != 0) {
//                int tmp = k[i];
//                while (tmp > 0) {
//                    nums[index] = i;
//                    index++;
//                    tmp--;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 0, 2, 1, 1, 0};
        new Solution().sortColors(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{1, 2, 0};
        new Solution().sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}
