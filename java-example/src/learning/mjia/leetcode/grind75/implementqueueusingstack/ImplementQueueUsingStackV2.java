package learning.mjia.leetcode.grind75.implementqueueusingstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStackV2 {

    // Deque is equivalent to Stack, just more modern
    private final Deque<Integer> temporaryStack;
    private final Deque<Integer> outputStack;

    public ImplementQueueUsingStackV2() {
        temporaryStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!outputStack.isEmpty()) {
            temporaryStack.push((outputStack.pop()));
        }
        outputStack.push(x);
        while (!temporaryStack.isEmpty()) {
            outputStack.push(temporaryStack.pop());
        }
    }

    public int pop() {
        return outputStack.pop();
    }

    public int peek() {
        return outputStack.peek();
    }

    public boolean empty() {
        return outputStack.isEmpty();
    }
}
