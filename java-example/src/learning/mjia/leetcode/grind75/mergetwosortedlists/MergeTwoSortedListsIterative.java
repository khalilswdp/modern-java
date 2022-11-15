package learning.mjia.leetcode.grind75.mergetwosortedlists;

public class MergeTwoSortedListsIterative {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode currentIteration = null;
        while (isOneOfTheListsNotNull(list1, list2)) {
            ListNode newOne = new ListNode();
            if (isSecondSmaller(list1, list2)) {
                newOne.val = list2.val;
                list2 = list2.next;
            } else if (isSecondSmaller(list2, list1)) {
                newOne.val = list1.val;
                list1 = list1.next;
            }
            if (result == null) {
                result = newOne;
                currentIteration = result;
            } else {
                currentIteration.next = newOne;
                currentIteration = currentIteration.next;
            }
        }
        return result;
    }

    private static boolean isSecondSmaller(ListNode list1, ListNode list2) {
        return list1 == null || (list2 != null && list1.val >= list2.val);
    }

    private static boolean isOneOfTheListsNotNull(ListNode list1, ListNode list2) {
        return list1 != null || list2 != null;
    }
}

