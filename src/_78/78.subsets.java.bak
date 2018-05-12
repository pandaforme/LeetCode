package _78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums, 0);
    }

    private List<List<Integer>> helper(int[] nums, int current) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        if (current == nums.length - 1) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[current]);

            result.add(tmp);
            result.add(new ArrayList<>());

            return result;
        }

        // want nums[current]
        List<List<Integer>> others = helper(nums, current + 1);
        for (List<Integer> list : others) {
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(nums[current]);
            result.add(tmp);
        }

        // don't want nums[current]
        result.addAll(others);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }
}
