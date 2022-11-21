package learning.mjia.leetcode.grind75.linkedlistcycle;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleX {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        while (head != null) {
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }
}
