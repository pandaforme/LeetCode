package _678;

class Solution {
    public boolean checkValidString(String s) {
        if (s.length() == 0)
            return true;

        return helper(s, 0, 0);
    }

    private boolean helper(String s, int start, int leftCount) {
        if (leftCount < 0)
            return false;

        if (start >= s.length() && leftCount == 0)
            return true;
        else if (start >= s.length() && leftCount != 0)
            return false;

        if (s.charAt(start) == '(')
            return helper(s, start + 1, leftCount + 1);

        if (s.charAt(start) == ')')
            return helper(s, start + 1, leftCount - 1);

        return helper(s, start + 1, leftCount + 1) ||
                helper(s, start + 1, leftCount - 1) ||
                helper(s, start + 1, leftCount);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString("()"));
        System.out.println(new Solution().checkValidString("(*)"));
        System.out.println(new Solution().checkValidString("(*))"));
        System.out.println(new Solution().checkValidString("()*"));
        System.out.println(new Solution().checkValidString("))(("));
        System.out.println(new Solution().checkValidString(""));
    }
}
