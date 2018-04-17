package interview.easy;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case ')':
                    if (stack.isEmpty())
                        return false;
                    if (stack.peek() != '(')
                        return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty())
                        return false;
                    if (stack.peek() != '[')
                        return false;
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty())
                        return false;
                    if (stack.peek() != '{')
                        return false;
                    stack.pop();
                    break;
            }
        }

        return stack.isEmpty();
    }
}
