//package leetcode.contest;
//
//class Solution {
//    public boolean checkValidString(String s) {
//        return check(s, 0, 0);
//    }
//
//    private boolean check(String s, int start, int count) {
//        if (count < 0)
//            return false;
//
//        for (int i = start; i < s.length(); i++) {
//            if (s.charAt(i) == '(')
//                count++;
//
//            if (s.charAt(i) == ')' && count <= 0)
//                return false;
//
//            if (s.charAt(i) == ')')
//                count--;
//
//            if (s.charAt(i) == '*')
//                return check(s, i + 1, count + 1) ||
//                        check(s, i + 1, count - 1) ||
//                        check(s, i + 1, count);
//        }
//
//        return count == 0;
//
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.checkValidString("(*))"));
//        System.out.println(solution.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
//    }
//
//}