package learning.mjia.leetcode.grind75.reverselinkedlist;

public class ReverseLinkedListIterative {
    public ListNode reverseList(ListNode head) {
        ListNode current = head, shouldPointTo = null, pointsTo;
        while (current != null) {
            pointsTo = current.next;
            current.next = shouldPointTo;
            shouldPointTo = current;
            current = pointsTo;
        }

        return shouldPointTo;
    }
}
