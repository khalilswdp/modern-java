package learning.mjia.leetcode.grind75.reverselinkedlist;

public class ReverseLinkedListDestructiveIterative {
    public ListNode reverseList(ListNode head) {
        ListNode current = head, next = head, previous = null;
        while (next != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
