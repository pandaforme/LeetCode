package _227;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        char sign = '+';
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                number = number * 10 + Character.getNumericValue(s.charAt(i));
            }

            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(number);
                    number = 0;
                    sign = s.charAt(i);
                } else if (sign == '-') {
                    stack.push(-number);
                    number = 0;
                    sign = s.charAt(i);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                    number = 0;
                    sign = s.charAt(i);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                    number = 0;
                    sign = s.charAt(i);
                }
            }

        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("1*2-3/4+5*6-7*8+9/10"));
        System.out.println(new Solution().calculate("3+2*2"));
        System.out.println(new Solution().calculate(" 3/2 "));
        System.out.println(new Solution().calculate(" 3+5 / 2 "));
    }
}
