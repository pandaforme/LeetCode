package _17;

import java.util.*;

class Solution {
    static Map<Character, List<String>> map = new HashMap<>();

    static {
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty())
            return new ArrayList<>();

        if (digits.length() == 1) {
            return map.get(digits.charAt(0));
        }

        return helper(digits, 0);
    }

    private List<String> helper(String digits, int start) {
        if (digits.length() - start == 1)
            return map.get(digits.charAt(start));

        List<String> result = new ArrayList<>();
        final List<String> remains = helper(digits, start + 1);

        for (String s : map.get(digits.charAt(start))) {
            for (String remain : remains) {
                result.add(s + remain);
            }
        }

        return result;
    }
}
