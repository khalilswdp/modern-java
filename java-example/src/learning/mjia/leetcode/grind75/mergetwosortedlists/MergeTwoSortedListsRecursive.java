package learning.mjia.leetcode.grind75.mergetwosortedlists;

public class MergeTwoSortedListsRecursive {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2: list1;
        } else if (list1.val >= list2.val) {
            return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        } else {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        }
    }
}

