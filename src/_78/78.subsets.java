package _78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null && nums.length == 0)
            return new ArrayList<>();

        return helper(nums, 0);
    }

    private List<List<Integer>> helper(int[] nums, int start) {
        List<List<Integer>> result = new ArrayList<>();

        if (start >= nums.length) {
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> lists = helper(nums, start + 1);
        result.addAll(lists);

        for (List<Integer> list : lists) {
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(nums[start]);
            result.add(tmp);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }
}
