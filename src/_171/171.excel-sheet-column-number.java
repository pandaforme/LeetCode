package _171;

class Solution {
    public int titleToNumber(String s) {
        // the ASCII code of A is 65

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Math.pow(26, s.length() - 1 - i) * (s.charAt(i) - 64);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("A"));
        System.out.println(new Solution().titleToNumber("AB"));
        System.out.println(new Solution().titleToNumber("ZY"));
        System.out.println(new Solution().titleToNumber("AZ"));
    }
}
