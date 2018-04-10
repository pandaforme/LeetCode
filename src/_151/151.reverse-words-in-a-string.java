package _151;

class Solution {
    // if a interviewer allow you to use API to solve it, it definitely an easy test...
    // but I think that it should not allow to use API to solve it
    public String reverseWords(String s) {
        if (s == null || s.isEmpty())
            return "";

        String reverseString = reverseString(s);
        int end;

        String result = "";
        for (int start = 0; start < reverseString.length(); start++) {
            if (Character.isSpaceChar(reverseString.charAt(start))) {
                continue;
            }

            end = start + 1;
            while (end < reverseString.length() && !Character.isSpaceChar(reverseString.charAt(end)))
                end++;

            if (start < end) {
                result += reverseString(reverseString.substring(start, end));
                result += " ";
                start = end - 1;
            }
        }

        return result.equals("") ? "" : result.substring(0, result.length() - 1);
    }

    private String reverseString(String s) {
        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < result.length() / 2; i++) {
            Character tmp = result.charAt(i);
            result.setCharAt(i, result.charAt((s.length() - 1) - i));
            result.setCharAt((s.length() - 1) - i, tmp);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the sky is blue"));
        System.out.println(new Solution().reverseWords("   the sky is blue    "));
        System.out.println(new Solution().reverseWords("   the     sky is blue    "));
    }
}
