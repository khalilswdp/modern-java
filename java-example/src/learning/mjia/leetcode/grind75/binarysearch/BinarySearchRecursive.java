package learning.mjia.leetcode.grind75.binarysearch;

public class BinarySearchRecursive {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start == end && nums[start] == target) {
            return start;
        } else if (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                return search(nums, target, mid + 1, end);
            } else {
                return search(nums, target, start, end - 1);
            }
        } else {
            return -1;
        }
    }
}
