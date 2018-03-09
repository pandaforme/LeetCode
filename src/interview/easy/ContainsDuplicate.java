package interview.easy;

import java.util.Arrays;

// Given an array of integers, find if the array contains any duplicates.
// Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
public class ContainsDuplicate {
    // use hashset
    // time complexity: O(n)
    // space complexity: O(n)
//    public boolean containsDuplicate(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//
//        for (int num : nums) {
//            if (set.contains(num)) {
//                return true;
//            }
//
//            set.add(num);
//        }
//
//        return false;
//    }

    // sort array
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                if (nums[i] == nums[i + 1])
                    return true;
            }
        }

        return false;
    }

}
