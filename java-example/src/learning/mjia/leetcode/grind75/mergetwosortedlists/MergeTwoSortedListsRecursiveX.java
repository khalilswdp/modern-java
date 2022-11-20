package learning.mjia.leetcode.grind75.mergetwosortedlists;

public class MergeTwoSortedListsRecursiveX {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2: list1;
        } else if (list1.val >= list2.val) {
            return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        } else {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        }
    }
    // Equally this:
    // This is I believe, lighter, since we don't create a new ListNode on each step. But also, messes up list1
    // and list2 if they are passed on by reference.
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //        if (list1 == null) {
    //            return list2;
    //        } else if (list2 == null) {
    //            return list1;
    //        } else {
    //            if (list1.val <= list2.val) {
    //                list1.next = mergeTwoLists(list1.next, list2);
    //                return list1;
    //            } else {
    //                list2.next = mergeTwoLists(list1, list2.next);
    //                return list2;
    //            }
    //        }
    //    }
}

