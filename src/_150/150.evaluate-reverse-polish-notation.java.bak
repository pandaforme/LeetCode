package _150;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (isInteger(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else if (tokens[i].equals("+")) {
                if (stack.size() >= 2) {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    int tmp = op2 + op1;
                    stack.push(tmp);
                }
            } else if (tokens[i].equals("-")) {
                if (stack.size() >= 2) {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    int tmp = op2 - op1;
                    stack.push(tmp);
                }
            } else if (tokens[i].equals("*")) {
                if (stack.size() >= 2) {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    int tmp = op2 * op1;
                    stack.push(tmp);
                }
            } else if (tokens[i].equals("/")) {
                while (stack.peek() == 0) {
                    stack.pop();
                }

                if (stack.size() >= 2) {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    int tmp = op2 / op1;
                    stack.push(tmp);
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new Solution().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(new Solution().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        System.out.println(new Solution().evalRPN(new String[]{"6", "3", "0", "0", "0", "0", "/"}));
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
