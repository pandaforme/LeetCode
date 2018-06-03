package _22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        helper(n, n, "", result);

        return result;
    }

    private void helper(int left, int right, String tmp, List<String> result) {
        if (left > right)
            return;

        if (left > 0)
            helper(left - 1, right, tmp + "(", result);

        if (left < right && right > 0)
            helper(left, right - 1, tmp + ")", result);

        if (left == 0 && right == 0) {
            result.add(tmp);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
