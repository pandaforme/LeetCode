package _179;

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        String[] tmp = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = String.valueOf(nums[i]);
        }


        Arrays.sort(tmp, (s1, s2) -> {
            String c1 = s1 + s2;
            String c2 = s2 + s1;

            return c2.compareTo(c1);
        });

        if(tmp[0].startsWith("0"))
            return "0";

        StringBuilder result = new StringBuilder();

        for (String s : tmp)
            result.append(s);


        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{10, 2}));
        System.out.println(new Solution().largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
