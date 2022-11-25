package learning.mjia.leetcode.grind75.binarysearch;

public class BinarySearchIterative {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1;

        while (left <= right) {
            int mid = (left + right) / 2; // left + (right - left) // 2 == left + half-distance // to avoid overflows if asked in interviews
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
