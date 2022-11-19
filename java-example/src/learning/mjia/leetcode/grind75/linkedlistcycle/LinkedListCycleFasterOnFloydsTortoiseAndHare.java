package learning.mjia.leetcode.grind75.linkedlistcycle;

public class LinkedListCycleFasterOnFloydsTortoiseAndHare {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;

    }
}
