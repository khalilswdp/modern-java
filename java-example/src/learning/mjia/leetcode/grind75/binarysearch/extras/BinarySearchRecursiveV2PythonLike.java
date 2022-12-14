package learning.mjia.leetcode.grind75.binarysearch.extras;

public class BinarySearchRecursiveV2PythonLike {
    public static int search(int[] nums, int target) {
        int numsLength = nums.length;
        if (numsLength == 0) {
            return -1;
        } else if (numsLength == 1 && nums[0] != target) {
            return -1;
        }

        int mid = numsLength / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            int[] rightNums = arraySlice(nums, mid + 1, numsLength - 1);
            int indexAtRight = search(rightNums, target);
            return indexAtRight == -1 ? -1 : mid + 1 + indexAtRight;
        } else {
            int[] leftNums = arraySlice(nums, 0, mid - 1);
            int indexAtLeft = search(leftNums, target);
            return indexAtLeft;
        }
    }

    public static int[] arraySlice(int[] nums, int start, int end) {
        int length = end - start + 1;
        int[] result = new int[length];

        int k = 0;
        for (int i = start; i <= end && k < length; i++, k++) {
            result[k] = nums[i];
        }

        return result;
    }
}
