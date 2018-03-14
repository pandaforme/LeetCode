package interview.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            } else
                return false;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if ((entry.getValue() != 0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagram("rat", "car"));
        System.out.println(new ValidAnagram().isAnagram("aamm", "aaam"));
    }
}
