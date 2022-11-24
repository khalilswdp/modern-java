package learning.mjia.leetcode.grind75.reverselinkedlist;

public class ReverseLinkedListRecursive {
    public ListNode reverseList(ListNode head) {
        // This doesn't work, just a place holder
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        if (head.next != null) {
            newHead = reverseList(head.next);
            head.next.next = newHead;
        }
        head.next = null;
        return newHead;
    }
}
