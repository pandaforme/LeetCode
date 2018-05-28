package _179;

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        String[] tmp = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            tmp[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(tmp, (s1, s2) -> {
            String t1 = String.valueOf(s1) + String.valueOf(s2);
            String t2 = String.valueOf(s2) + String.valueOf(s1);
            return t2.compareTo(t1);
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : tmp) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString().charAt(0) == '0' ? "0" : stringBuilder.toString();
    }
}
