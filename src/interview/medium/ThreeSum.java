package interview.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if ((nums.length == 0)) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        // the harder part is to handle duplicate elements and duplicate results which are different orders
        List<List<Integer>> result = new ArrayList<>();
        Integer previous = null;
        for (int i = 0; i < nums.length; i++) {
            if (previous != null && nums[i] == previous)
                continue;

            List<List<Integer>> twoSum = twoSum(nums, 0 - nums[i], i + 1, nums.length - 1);
            for (List<Integer> list : twoSum) {
                list.add(0, nums[i]);
                result.add(list);
            }

            previous = nums[i];

        }

        return result;
    }

    // because we have a sorted array, not need to a auxiliary data structure
    // furthermore, using this technique is hard to handle duplicate results
    // it is easy to implement it if using two pointers
    private List<List<Integer>> twoSum(int[] nums, int target, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();

        while (start < end) {
            if (nums[start] + nums[end] == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[start]);
                tmp.add(nums[end]);
                result.add(tmp);

                final int tmpEnd = nums[end];
                while (end >= 0 && nums[end] == tmpEnd) {
                    end--;
                }

                final int tmpStart = nums[start];
                while (start < nums.length && nums[start] == tmpStart) {
                    start++;
                }


            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;

            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(new ThreeSum().threeSum(new int[]{0, 2, 2, 3, 0, 1, 2, 3, -1, -4, 2}));
    }
}
