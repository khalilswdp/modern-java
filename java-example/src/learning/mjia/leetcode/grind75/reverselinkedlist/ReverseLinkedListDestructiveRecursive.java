package learning.mjia.leetcode.grind75.reverselinkedlist;

public class ReverseLinkedListDestructiveRecursive {
    public ListNode reverseList(ListNode head) {
        // This doesn't work, just a place holder
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
