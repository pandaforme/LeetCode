package interview.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToInteger {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty())
            return 0;

        Pattern pattern = Pattern.compile("^([+-]?)(\\d+)([\\w\\s]*)$");
        Matcher matcher = pattern.matcher(str);

        long result = 0;
        if (matcher.find()) {
            for (int i = matcher.group(2).length() - 1; i >= 0; i--) {
                result += Character.getNumericValue(matcher.group(2).charAt(i)) * Math.pow(10, (matcher.group(2).length() - 1) - i);
            }

            if (matcher.group(1).equals("-"))
                result = -result;

            if (result > Integer.MAX_VALUE)
                result = Integer.MAX_VALUE;
            else if (result < Integer.MIN_VALUE)
                result = Integer.MIN_VALUE;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("-123"));
        System.out.println(new StringToInteger().myAtoi("123"));
        System.out.println(new StringToInteger().myAtoi("+123"));
    }
}
