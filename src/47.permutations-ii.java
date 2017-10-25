//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//class Solution {
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        return find(nums, 0);
//    }
//
//    private List<List<Integer>> find(int[] nums, int start) {
//        if (nums == null || nums.length == 0)
//            return new ArrayList<>();
//
//        if ((nums.length - start) == 1) {
//            List<List<Integer>> results = new ArrayList<>();
//            List<Integer> tmp = new ArrayList<>();
//            tmp.add(nums[nums.length - 1]);
//            results.add(tmp);
//            return results;
//        }
//
//        List<List<Integer>> results = new ArrayList<>();
//        List<List<Integer>> lists = find(nums, start + 1);
//
//        Set<List<Integer>> set = new HashSet<>();
//        for (List<Integer> list : lists) {
//            for (int j = 0; j <= list.size(); j++) {
//                List<Integer> tmp = new ArrayList<>(list);
//                tmp.add(j, nums[start]);
//                set.add(tmp);
//            }
//        }
//
//        results.addAll(set);
//        return results;
//    }
//}