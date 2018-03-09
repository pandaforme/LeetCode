package interview.easy;

import java.util.*;

//Given two arrays, write a function to compute their intersection.
//
//Example:
//Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
public class IntersectionOfTwoArraysII {
    // brute force
    // time complexity: O(n * m)
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    list.add(i);
                    break;
                }
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    // time complexity: O(n * m)
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return list.stream().mapToInt(e -> e).toArray();
    }

    // time complexity: O(n)
    // space complexity: O(n)
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : nums1) {
            if (map.containsKey(i) && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }

        return list.stream().mapToInt(e -> e).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect1(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect2(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
