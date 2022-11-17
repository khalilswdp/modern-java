package learning.mjia.leetcode.grind75.maximumsubarray;

public class MaximumSubarrayDivideAndConquerV2OnLessMemoryLessReadable {
    public static void main(String[] args) {
        maxSubArray(new int[]{8,-19,5,-4,20});
    }
    public static int maxSubArray(int[] nums) {
        // This can be implemented from the bottom up?
        return findMaximumSubarrayByComparingMSDs(nums, 0, nums.length - 1)[1];
    }

    private static int[] findMaximumSubarrayByComparingMSDs(int[] nums, int start, int end) {
        if (start == end) {
            return new int[] { nums[start], nums[start], nums[start], nums[start] };
        } else {
            int mid = start + (end - start) / 2;
            return compareMSDs(findMaximumSubarrayByComparingMSDs(nums, start, mid),
                    findMaximumSubarrayByComparingMSDs(nums, mid + 1, end));
        }
    }

    private static int[] compareMSDs(int[] left, int[] right) {
        return new int[] {
                left[0] + right[0],
                Math.max(left[3] + right[2],
                        Math.max(left[1], right[1])),
                Math.max(left[2], left[0] + right[2]),
                Math.max(right[3], right[0] + left[3]) };
    }
}