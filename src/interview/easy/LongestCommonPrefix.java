package interview.easy;

import datastructure.Trie;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if ((strs.length == 0)) {
            return "";
        }

        String result = "";

        int p = 0;
        while (true) {
            if (isAllSame(strs, p)) {
                result += String.valueOf(strs[0].charAt(p));
                p++;
            } else {
                break;
            }
        }

        return result;

    }

    private boolean isAllSame(String[] strs, int position) {
        StringBuilder tmp1 = new StringBuilder();
        StringBuilder tmp2 = new StringBuilder();

        for (int i = 0; i < strs.length; i++) {
            if (position >= strs[i].length())
                return false;

            tmp1.append(String.valueOf(strs[i].charAt(position)));
            tmp2.append(String.valueOf(strs[0].charAt(position)));
        }

        return tmp1.toString().equals(tmp2.toString());
    }

    // O(nlogn)
    public String longestCommonPrefix1(String[] strs) {
        if ((strs.length == 0)) {
            return "";
        }

        return find(strs, 0, strs.length - 1);
    }


    // follow up
    public String longestCommonPrefix2(String q, String[] strs) {
        if ((strs.length == 0)) {
            return "";
        }

        if (strs.length == 1)
            return strs[0];

        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }

        return trie.searchLongestPrefix(q);
    }

    private String find(String[] strs, int left, int right) {
        if (left == right)
            return strs[left];

        int middle = left + (right - left) / 2;

        String leftPart = find(strs, left, middle);
        String rightPart = find(strs, middle + 1, right);

        return longestCommonPrefix(leftPart, rightPart);
    }

    private String longestCommonPrefix(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i))
                result.append(String.valueOf(s1.charAt(i)));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"abcdefgrt", "abc", "abcd"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"abcdefgrt", "", "abcd"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix1(new String[]{"abcdefgrt", "abc", "abcd"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix1(new String[]{"abcdefgrt", "", "abcd"}));
    }
}
