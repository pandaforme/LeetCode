class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        // formula:
        // dp[i][j] : the longest palindrome subsequence length of si ... sj
        // 1. si == sj => 2 + dp[i + 1][j - 1]
        // 2. si != sj => Max{ dp[i][j - 1], dp[i + 1][j]}
        for (int d = 1; d < s.length(); d++) {
            for (int i = 0; i < s.length() - d; i++) {
                int j = i + d;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindromeSubseq("bbbab"));
        System.out.println(new Solution().longestPalindromeSubseq("cbc"));
        System.out.println(new Solution().longestPalindromeSubseq("cab"));
        System.out.println(new Solution().longestPalindromeSubseq("cbbd"));
    }
}
