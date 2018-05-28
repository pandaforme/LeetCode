package _50;

class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1d;

        if (n < 0)
            return helper(1 / x, -n);

        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (x == 1d || n == 0)
            return 1d;

        double half = helper(x, n / 2);

        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, 3));
        System.out.println(new Solution().myPow(2.1, 3));
        System.out.println(new Solution().myPow(2.00000, -2));
    }
}
