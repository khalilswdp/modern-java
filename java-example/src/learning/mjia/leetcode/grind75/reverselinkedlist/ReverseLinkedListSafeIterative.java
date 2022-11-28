package learning.mjia.leetcode.grind75.reverselinkedlist;

public class ReverseLinkedListSafeIterative {
    public ListNode reverseList(ListNode head) {
        ListNode currentR = null, currentH = head;

        while (currentH != null) {
            currentR = new ListNode(currentH.val, currentR);
            currentH = currentH.next;
        }

        return currentR;
    }
}
