package learning.mjia.leetcode.grind75.binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int numsLength = nums.length;
        int left = 0, right = numsLength -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
