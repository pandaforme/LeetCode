package _91;

class Solution {
//    public int numDecodings(String s) {
//        if (s.length() == 0 || (s.length() == 1 && Integer.valueOf(s) != 0))
//            return 1;
//
//        if (s.length() == 1 && Integer.valueOf(s) == 0)
//            return 0;
//
//        int result = 0;
//        if (Character.getNumericValue(s.charAt(0)) != 0) {
//            result = numDecodings(s.substring(1));
//            int v = Integer.valueOf(s.substring(0, 2));
//            if (10 <= v && v <= 26)
//                result += numDecodings(s.substring(2));
//        }
//
//        return result;
//    }


    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0')
                dp[i] = dp[i - 1];

            if (i - 2 >= 0) {
                int v = Integer.valueOf(s.substring(i - 2, i));
                if (10 <= v && v <= 26)
                    dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("01"));
        System.out.println(new Solution().numDecodings("10"));
        System.out.println(new Solution().numDecodings("226"));
    }
}
