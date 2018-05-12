package _46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return helper(nums, 0);
    }

    private List<List<Integer>> helper(int[] nums, int start) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0)
            return result;

        if (start == nums.length - 1) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[start]);

            result.add(tmp);
            return result;
        }

        List<List<Integer>> others = helper(nums, start + 1);
        for (List<Integer> other : others) {
            for (int i = 0; i <= other.size(); i++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(other);
                tmp.add(i, nums[start]);
                result.add(tmp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
}