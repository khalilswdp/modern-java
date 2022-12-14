package learning.mjia.leetcode.grind75.middleofthelinkedlist;

public class MiddleOfTheLinkedListNaiveV2 {
    public ListNode middleNode(ListNode head) {
        int depth = findDepth(head);

        depth = depth / 2;

        return returnAtDepth(head, depth);
    }

    public ListNode returnAtDepth(ListNode head, int depth) {
        while (depth > 0) {
            head = head.next;
            depth--;
        }
        return head;
    }

    public int findDepth(ListNode head) {
        if (head == null) {
            return 0;
        } else {
            return 1 + findDepth(head.next);
        }
    }
}

