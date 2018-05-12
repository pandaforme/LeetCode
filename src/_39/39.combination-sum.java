package _39;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        helper(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void helper(int[] candidates, int target, int start, List<Integer> tmp, List<List<Integer>> result) {
        if (target < 0)
            return;

        if (target == 0) {
            result.add(tmp);
            return;
        }

        if (start >= candidates.length)
            return;

        helper(candidates, target, start + 1, tmp, result);

        List<Integer> list = new ArrayList<>(tmp);
        list.add(candidates[start]);
        helper(candidates, target - candidates[start], start, list, result);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
