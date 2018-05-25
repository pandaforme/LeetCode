package _166;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        StringBuilder stringBuilder = new StringBuilder();

        if ((numerator > 0 || denominator > 0) && (numerator < 0 || denominator < 0))
            stringBuilder.append("-");

        long absNumerator = Math.abs(Long.valueOf(numerator));
        long absDenominator = Math.abs(Long.valueOf(denominator));
        stringBuilder.append(absNumerator / absDenominator);

        long remainder = absNumerator % absDenominator;
        if (remainder == 0)
            return stringBuilder.toString();
        else
            stringBuilder.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0 && !map.containsKey(remainder)) {
            long newNumerator = remainder * 10L;
            stringBuilder.append(newNumerator / absDenominator);
            map.put(remainder, stringBuilder.length() - 1);
            remainder = newNumerator % absDenominator;
        }

        if (map.containsKey(remainder)) {
            stringBuilder.insert(map.get(remainder), "(");
            stringBuilder.append(")");
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(1, 2));
        System.out.println(new Solution().fractionToDecimal(2, 1));
        System.out.println(new Solution().fractionToDecimal(2, 3));
        System.out.println(new Solution().fractionToDecimal(1, 4));
        System.out.println(new Solution().fractionToDecimal(1, 3));
        System.out.println(new Solution().fractionToDecimal(3, 11));
        System.out.println(new Solution().fractionToDecimal(4, 15));
        System.out.println(new Solution().fractionToDecimal(68, 55));
        System.out.println(new Solution().fractionToDecimal(-22, -2));
        System.out.println(new Solution().fractionToDecimal(-1, -2147483648));
    }
}
