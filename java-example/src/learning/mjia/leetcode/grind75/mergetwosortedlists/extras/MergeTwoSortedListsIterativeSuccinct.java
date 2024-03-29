package learning.mjia.leetcode.grind75.mergetwosortedlists.extras;

import learning.mjia.leetcode.grind75.mergetwosortedlists.ListNode;

public class MergeTwoSortedListsIterativeSuccinct {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(), currentIteration = result;
        while (isOneOfTheListsNotNull(list1, list2)) {
            if (isSecondSmaller(list1, list2)) {
                currentIteration.next = list2;
                list2 = list2.next;
            } else if (isSecondSmaller(list2, list1)) {
                currentIteration.next = list1;
                list1 = list1.next;
            }
            currentIteration = currentIteration.next;
        }
        return result.next;
    }

    private static boolean isSecondSmaller(ListNode list1, ListNode list2) {
        return list1 == null || (list2 != null && list1.val >= list2.val);
    }

    private static boolean isOneOfTheListsNotNull(ListNode list1, ListNode list2) {
        return list1 != null || list2 != null;
    }
}

