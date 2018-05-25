package _29;

class Solution {
    public int divide(int dividend, int divisor) {
        long dividendL = Math.abs(Long.valueOf(dividend));
        long divisorL = Math.abs(Long.valueOf(divisor));

        int k = 0;
        while ((divisorL << k) <= dividendL) {
            k++;
        }
        k--;

        long result = 0;
        while (k >= 0) {
            if ((divisorL << k) <= dividendL) {
                result += (1L << k);
                dividendL -= (divisorL << k);
            }

            k--;
        }

        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            return result >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
        } else {
            return -result < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) -result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(10, 3));
        System.out.println(new Solution().divide(7, -3));
        System.out.println(new Solution().divide(-2147483648, -1));
        System.out.println(new Solution().divide(-2147483648, 2));
    }
}
