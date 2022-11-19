package learning.mjia.leetcode.grind75.implementqueueusingstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStack {

    // Deque is equivalent to Stack, just more modern
    private final Deque<Integer> inputStack;
    private final Deque<Integer> outputStack;

    public ImplementQueueUsingStack() {
        inputStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        if (outputStack.isEmpty()) {
            balanceIfNecessary();
        }
        return outputStack.pop();
    }

    private void balanceIfNecessary() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }

    public int peek() {
        if (outputStack.isEmpty()) {
            balanceIfNecessary();
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return outputStack.isEmpty() && inputStack.isEmpty();
    }
}
