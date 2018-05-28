package _166;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder stringBuilder = new StringBuilder();

        if ((numerator > 0 || denominator > 0) && (numerator < 0 || denominator < 0))
            stringBuilder.append("-");

        long numeratorL = Math.abs(Long.valueOf(numerator));
        long denominatorL = Math.abs(Long.valueOf(denominator));

        if (numeratorL >= denominatorL) {
            stringBuilder.append(numeratorL / denominatorL);
        } else {
            stringBuilder.append(0);
        }

        long remainder = numeratorL % denominatorL;
        if (remainder != 0) {
            stringBuilder.append(".");
        }

        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            numeratorL = remainder * 10L;

            long q = numeratorL / denominatorL;

            if (!map.containsKey(remainder)) {
                stringBuilder.append(q);
                map.put(remainder, stringBuilder.length() - 1);
            } else {
                stringBuilder.insert(map.get(remainder), "(");
                stringBuilder.append(")");
                break;
            }

            remainder = numeratorL % denominatorL;
        }


        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(1, 2));
        System.out.println(new Solution().fractionToDecimal(2, 1));
        System.out.println(new Solution().fractionToDecimal(1, 3));
        System.out.println(new Solution().fractionToDecimal(2, 3));
        System.out.println(new Solution().fractionToDecimal(68, 55));
        System.out.println(new Solution().fractionToDecimal(-22, -2));
        System.out.println(new Solution().fractionToDecimal(-1, -2147483648));
    }
}
