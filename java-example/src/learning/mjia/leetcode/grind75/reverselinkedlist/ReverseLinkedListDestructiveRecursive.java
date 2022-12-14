package learning.mjia.leetcode.grind75.reverselinkedlist;

public class ReverseLinkedListDestructiveRecursive {
    public ListNode reverseList(ListNode first) {
        // This doesn't work, just a place holder
        if (first == null) {
            return null;
        } else if (first.next == null) {
            return first;
        } else {
            ListNode secondToFirst = first.next;
            first.next = null;
            ListNode theVeryLast = reverseList(secondToFirst);
            secondToFirst.next = first;

            return theVeryLast;
        }
    }
}
