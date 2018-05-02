package _172;

class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n / 5);
            n /= 5;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(4));
        System.out.println(new Solution().trailingZeroes(5));
        System.out.println(new Solution().trailingZeroes(12));
        System.out.println(new Solution().trailingZeroes(20));
        System.out.println(new Solution().trailingZeroes(30));
    }
}
