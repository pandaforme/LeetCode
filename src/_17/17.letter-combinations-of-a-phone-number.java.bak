package _17;

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));

        return helper(digits, map);
    }

    private List<String> helper(String digits, Map<String, List<String>> map) {
        if (digits.isEmpty())
            return new ArrayList<>();

        if (digits.length() == 1)
            return map.get(String.valueOf(digits.charAt(0)));

        List<String> result = new ArrayList<>();

        List<String> others = helper(digits.substring(1), map);
        List<String> words = map.get(String.valueOf(digits.charAt(0)));
        for (String word : words) {
            for (String other : others) {
                result.add(word + other);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
