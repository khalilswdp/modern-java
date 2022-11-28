package learning.mjia.leetcode.grind75.reverselinkedlist;

import java.util.Stack;

public class ReverseLinkedListMemoryHungryIterative {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }

        ListNode result = new ListNode(), current = result;
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null;
        return result.next;
    }
}
