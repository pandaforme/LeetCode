package _15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            List<List<Integer>> twoSums = twoSum(nums, i + 1, nums.length - 1, -nums[i]);
            for (List<Integer> list : twoSums) {
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(0, nums[i]);
                result.add(tmp);
            }
        }

        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> result = new ArrayList<>();

        while (start < end) {
            if (nums[start] + nums[end] == target) {
                result.add(Arrays.asList(nums[start], nums[end]));

                int tmp = nums[start];
                while (start <= end && nums[start] == tmp)
                    start++;

                tmp = nums[end];
                while (end >= start && nums[end] == tmp)
                    end--;
            } else if (nums[start] + nums[end] > target) {
                int tmp = nums[end];
                while (end >= start && nums[end] == tmp)
                    end--;
            } else {
                int tmp = nums[start];
                while (start <= end && nums[start] == tmp)
                    start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
