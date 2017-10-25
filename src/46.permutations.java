//import java.util.ArrayList;
//import java.util.List;
//
//class Solution {
//    public List<List<Integer>> permute(int[] nums) {
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
//        for (List<Integer> list : lists) {
//            for (int j = 0; j <= list.size(); j++) {
//                List<Integer> tmp = new ArrayList<>(list);
//                tmp.add(j, nums[start]);
//                results.add(tmp);
//            }
//        }
//
//        return results;
//    }
//}