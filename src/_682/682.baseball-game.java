package _682;

import java.util.Stack;
import java.util.regex.Pattern;

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        Pattern pattern = Pattern.compile("^[-+]?[\\d]*$");

        for (String op : ops) {
            if (op.equals("D")) {
                if (!stack.isEmpty()) {
                    Integer integer = stack.peek();
                    int tmp = integer * 2;
                    stack.push(tmp);
                    sum += tmp;
                }
            } else if (op.equals("C")) {
                if (!stack.isEmpty()) {
                    int tmp = stack.pop();
                    sum -= tmp;
                }
            } else if (op.equals("+")) {
                if (!stack.isEmpty()) {
                    Integer i1 = stack.pop();
                    Integer i2 = stack.pop();
                    stack.push(i2);
                    stack.push(i1);
                    stack.push(i1 + i2);
                    sum += (i1 + i2);
                }
            } else if (pattern.matcher(op).matches()) {
                Integer tmp = Integer.valueOf(op);
                stack.push(tmp);
                sum += tmp;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(new Solution().calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }
}
