//import java.util.Stack;
//
//class MinStack {
//    Stack<Integer> stack = new Stack<>();
//
//
//    Stack<Integer> minStack = new Stack<>();
//
//    int min = Integer.MAX_VALUE;
//
//    /**
//     * initialize your data structure here.
//     */
//    public MinStack() {
//
//    }
//
//    public void push(int x) {
//        min = Math.min(x, min);
//
//        stack.push(x);
//        minStack.push(min);
//    }
//
//    public void pop() {
//        Integer topElement = stack.pop();
//        minStack.pop();
//
//        if (topElement == min) {
//            if (!minStack.isEmpty())
//                min = minStack.peek();
//            else
//                min = Integer.MAX_VALUE;
//        }
//
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return min;
//    }
//}
//
///**
// * Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(x);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();
// */