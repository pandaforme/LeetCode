package interview.easy;

public class ClimbingStairs {
    // the equation:
    // f(n) = f(n - 1) + f(n - 2)
    // transform it into a dp problem
    // dp[n] = dp[n - 1] + dp[n - 2]
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(2));
        System.out.println(new ClimbingStairs().climbStairs(3));
        System.out.println(new ClimbingStairs().climbStairs(4));
    }
}
