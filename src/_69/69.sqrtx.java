package _69;

class Solution {
    public int mySqrt(int x) {
        return (int) helper(x, 1, x);
    }

    private long helper(int x, long start, long end) {
        if (start > end)
            return end;

        long middle = (start + end) / 2;
        if (middle * middle == x) {
            return middle;
        }

        if (middle * middle < x)
            return helper(x, middle + 1, end);

        return helper(x, start, middle - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(4));
        System.out.println(new Solution().mySqrt(16));
        System.out.println(new Solution().mySqrt(8));
        System.out.println(new Solution().mySqrt(2147395599));
    }
}
