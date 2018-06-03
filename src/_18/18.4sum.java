package _18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        return kSum(nums, target, 0, nums.length - 1, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int start, int end, int k) {
        if (k == 2)
            return twoSum(nums, target, start, end);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (i - 1 >= start && nums[i - 1] == nums[i])
                continue;

            List<List<Integer>> remains = kSum(nums, target - nums[i], i + 1, end, k - 1);
            for (List<Integer> remain : remains) {
                List<Integer> list = new ArrayList<>(remain);
                list.add(nums[i]);
                result.add(list);

            }
        }

        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();

        if (start >= end)
            return result;

        int i = start;
        int j = end;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);

                int tmp = nums[i];
                while (i < end && nums[i] == tmp)
                    i++;

                tmp = nums[j];
                while (j >= start && nums[j] == tmp)
                    j--;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
