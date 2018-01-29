package _8;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty())
            return 0;

        Pattern pattern = Pattern.compile("^([+-]?)(\\d+)([\\w\\s]*)$");
        Matcher matcher = pattern.matcher(str);

        Stack<Character> stack = new Stack<>();
        long result = 0;
        if (matcher.find()) {
            for (int i = 0; i < matcher.group(2).length(); i++) {
                stack.push(matcher.group(2).charAt(i));
            }

            int i = 0;
            while (!stack.isEmpty()) {
                result += Character.getNumericValue(stack.pop()) * Math.pow(10, i);
                i++;
            }

            if (matcher.group(1).equals("-")) {
                if (-result < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                else
                    return (int) -result;
            } else {
                if (result > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else
                    return (int) result;
            }
        }

        return (int) result;

    }
}
