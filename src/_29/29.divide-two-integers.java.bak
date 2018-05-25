package _29;

class Solution {
    public int divide(int dividend, int divisor) {
        long dividendL = dividend;
        long divisorL = divisor;
        long unsignedDividendL = Math.abs(dividendL);
        long unsignedDivisorL = Math.abs(divisorL);

        long result = 0;
        int k = 0;
        while ((unsignedDivisorL << k) <= unsignedDividendL)
            k++;
        k--;

        while (k >= 0) {
            long tmp = (unsignedDivisorL << k);
            if (tmp <= unsignedDividendL) {
                result += (1L << k);
                unsignedDividendL -= tmp;
            }
            k--;
        }

        if (dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0) {
            return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
        }

        return -result < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) -result;
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
