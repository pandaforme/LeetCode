package _29;

class Solution {
    public int divide(int dividend, int divisor) {
        long dividendL = dividend;
        long divisorL = divisor;

        long result = helper(Math.abs(dividendL), Math.abs(divisorL), 0, Math.abs(dividendL));

        if (dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0) {
            return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
        }

        return -result < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) -result;
    }

    private long helper(long dividend, long divisor, long start, long end) {
        if (start > end)
            return end;

        long middle = (start + end) / 2;

        if (middle * divisor == dividend)
            return middle;

        if (middle * divisor > dividend)
            return helper(dividend, divisor, start, middle - 1);

        return helper(dividend, divisor, middle + 1, end);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(0, 3));
        System.out.println(new Solution().divide(10, 3));
        System.out.println(new Solution().divide(7, -3));
        System.out.println(new Solution().divide(1, Integer.MAX_VALUE));
        System.out.println(new Solution().divide(Integer.MAX_VALUE, 1));
        System.out.println(new Solution().divide(1, Integer.MIN_VALUE));
        System.out.println(new Solution().divide(Integer.MIN_VALUE, 1));
        System.out.println(new Solution().divide(Integer.MIN_VALUE, -1));
        System.out.println(new Solution().divide(Integer.MIN_VALUE, 2));
        System.out.println(new Solution().divide(-9, -3));
    }
}
