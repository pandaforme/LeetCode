package interview.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;

        Map<Character, Integer> map = new HashMap<>();
        while (i < s.length() && j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                if (i <= map.get(s.charAt(j))) {
                    i = map.get(s.charAt(j)) + 1;
                }
            }

            map.put(s.charAt(j), j);
            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aab"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("au"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
    }
}
