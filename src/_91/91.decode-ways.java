package _91;

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];

            Integer tmp = Integer.valueOf(s.substring(i - 2, i));
            if (10 <= tmp && tmp <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[s.length()];
    }
//    public int numDecodings(String s) {
//        return helper(0, s);
//    }
//
//    private int helper(int start, String s) {
//        if (s == null || s.isEmpty())
//            return 0;
//
//        if (start >= s.length())
//            return 1;
//
//        if (s.charAt(start) == '0')
//            return 0;
//
//        if (start == s.length() - 1)
//            return 1;
//
//        int result = helper(start + 1, s);
//        Integer tmp = Integer.valueOf(s.substring(start, start + 2));
//        if (10 <= tmp && tmp <= 26)
//            result += helper(start + 2, s);
//
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("01"));
        System.out.println(new Solution().numDecodings("10"));
        System.out.println(new Solution().numDecodings("0"));
        System.out.println(new Solution().numDecodings("326"));
        System.out.println(new Solution().numDecodings("226"));
        System.out.println(new Solution().numDecodings("2212"));
    }
}
