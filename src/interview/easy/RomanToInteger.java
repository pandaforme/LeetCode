package interview.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int count = 0;
        int previous = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(String.valueOf(s.charAt(i)));

            if (previous < value)
                count += (value - 2 * previous);
            else
                count += value;

            previous = value;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
        System.out.println(new RomanToInteger().romanToInt("LVIII"));
        System.out.println(new RomanToInteger().romanToInt("IX"));
    }
}
