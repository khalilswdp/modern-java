package learning.mjia.leetcode.grind75.implementqueueusingstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStackV2X {

    // Deque is equivalent to Stack, just more modern
    private final Deque<Integer> temporaryStack;
    private final Deque<Integer> outputStack;

    public ImplementQueueUsingStackV2X() {
        temporaryStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    public void push(int x) {
        moveFirstStackToSecond(outputStack, temporaryStack);
        outputStack.push(x);
        moveFirstStackToSecond(temporaryStack, outputStack);
    }

    private void moveFirstStackToSecond(Deque<Integer> outputStack, Deque<Integer> temporaryStack) {
        while (!outputStack.isEmpty()) {
            temporaryStack.push(outputStack.pop());
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
