package learning.mjia.leetcode.grind75.middleofthelinkedlist;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fastNode = head, slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        return slowNode;

    }
}

