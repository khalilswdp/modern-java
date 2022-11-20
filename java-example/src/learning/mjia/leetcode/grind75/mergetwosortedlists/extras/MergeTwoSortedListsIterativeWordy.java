package learning.mjia.leetcode.grind75.mergetwosortedlists.extras;

import learning.mjia.leetcode.grind75.mergetwosortedlists.ListNode;

public class MergeTwoSortedListsIterativeWordy {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result, currentIteration;
        if (list1.val >= list2.val) {
            currentIteration = list2;
            list2 = list2.next;
        } else {
            currentIteration = list1;
            list1 = list1.next;
        }
        result = currentIteration;

        while (bothNotNull(list1, list2)) {
            if (list1.val >= list2.val) {
                currentIteration.next = list2;
                list2 = list2.next;
            } else {
                currentIteration.next = list1;
                list1 = list1.next;
            }
            currentIteration = currentIteration.next;
        }

        if (list1 != null) {
            currentIteration.next = list1;
        } else {
            currentIteration.next = list2;
        }

        return result;
    }

    private static boolean bothNotNull(ListNode list1, ListNode list2) {
        return list1 != null && list2 != null;
    }
}

