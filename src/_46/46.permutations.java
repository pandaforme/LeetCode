package _46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        return helper(nums, 0);
    }

    private List<List<Integer>> helper(int[] nums, int start) {
        List<List<Integer>> result = new ArrayList<>();

        if ((nums.length - start) == 1) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[nums.length - 1]);
            result.add(tmp);
            return result;
        }


        List<List<Integer>> remains = helper(nums, start + 1);
        for (List<Integer> remain : remains) {
            for (int i = 0; i <= remain.size(); i++) {
                List<Integer> tmp = new ArrayList<>(remain);
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
