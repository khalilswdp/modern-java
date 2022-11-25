package learning.mjia.leetcode.grind75.mergetwosortedlists.extras;

import learning.mjia.leetcode.grind75.mergetwosortedlists.ListNode;

public class MergeTwoSortedListsIterativeWordy {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(), current = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        return result.next;
    }
}

