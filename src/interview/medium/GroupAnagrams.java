package interview.medium;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, Integer> map = new HashMap<>();

        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {

            List<Integer> tmp = new ArrayList<>(Collections.nCopies(26, 0));
            for (int i = 0; i < str.length(); i++) {
                tmp.set(str.charAt(i) - 97, tmp.get(str.charAt(i) - 97) + 1);
            }

            if (!map.containsKey(tmp)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);

                map.put(tmp, result.size() - 1);
            } else {
                result.get(map.get(tmp)).add(str);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"}));
    }
}
