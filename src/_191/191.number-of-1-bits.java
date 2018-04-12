package _191;

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            int tmp = n & 0x0001;
            if (tmp == 1)
                result++;
            n = n >>> 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11));
    }
}
