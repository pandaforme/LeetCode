package _120;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;

        int[] dp = new int[triangle.size()];

        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < dp.length; j++) {
                if (j >= triangle.get(i).size()) {
                    dp[j] = 0;
                    continue;
                }

                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        int result = 0;
        for (int i : dp) {
            if (i != 0) {
                result = i;
                break;
            }

        }

        return result;
    }
}
