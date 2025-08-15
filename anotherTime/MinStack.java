package anotherTime;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<int[]> stack = new ArrayDeque<>();
    public MinStack() {}

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
            return;
        }

        int[] lastVal = stack.peek();
        stack.push(new int[]{val, Math.min(lastVal[1], val)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.push(2147483647);
        minStack.getMin();
    }
}
