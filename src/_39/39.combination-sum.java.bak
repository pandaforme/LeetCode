package _39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return find(candidates, target, 0);
    }

    public List<List<Integer>> find(int[] candidates, int target, int start) {
        if (target <= 0)
            return new ArrayList<>();

        List<List<Integer>> results = new ArrayList<>();
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                results.add(list);
                return results;
            }

            List<List<Integer>> lists = find(candidates, target - candidates[i], i);
            for (List<Integer> list : lists) {
                list.add(candidates[i]);
                results.add(list);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}