package _8;

class Solution {
    public int myAtoi(String str) {
        if (str == null || str.trim().isEmpty())
            return 0;

        String s = str.trim().split(" ")[0];
        boolean isPositive = s.charAt(0) != '-';

        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && (s.charAt(i) == '-' || s.charAt(i) == '+'))
                continue;

            if (!Character.isDigit(s.charAt(i))) {
                if (!isPositive)
                    result = -result;
                return (int) result;
            }

            result = result * 10 + Character.getNumericValue(s.charAt(i));

            if (!isPositive) {
                if (-result <= Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            } else {
                if (result >= Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }
        }

        if (!isPositive)
            result = -result;

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("42"));
        System.out.println(new Solution().myAtoi("  -42"));
        System.out.println(new Solution().myAtoi("4193 with words"));
        System.out.println(new Solution().myAtoi("words and 987"));
        System.out.println(new Solution().myAtoi("-91283472332"));
        System.out.println(new Solution().myAtoi("3.14159"));
        System.out.println(new Solution().myAtoi("-0012a42"));
        System.out.println(new Solution().myAtoi("9223372036854775808"));
    }
}
