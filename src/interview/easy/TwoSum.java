package interview.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
public class TwoSum {

    // time complexity: O(n)
    // space complexity: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return result;
    }

    // time complexity: O(nlogn)
    // space complexity: O(n)
    public int[] twoSum1(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                result[0] = left;
                result[1] = right;
                return result;
            }

            if (nums[left] < target - nums[right])
                left++;
            else
                right--;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new TwoSum().twoSum1(new int[]{2, 7, 11, 15}, 9)));
    }
}
