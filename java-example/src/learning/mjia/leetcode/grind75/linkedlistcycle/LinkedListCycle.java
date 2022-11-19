package learning.mjia.leetcode.grind75.linkedlistcycle;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visitedNodes = new HashSet<>();
        return containsCycle(head, visitedNodes);

    }

    public boolean containsCycle(ListNode head, Set<ListNode> visitedNodes) {
        while (head != null) {
            if (!visitedNodes.contains(head)) {
                visitedNodes.add(head);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }
}
