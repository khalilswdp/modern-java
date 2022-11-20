package learning.mjia.leetcode.grind75.twosum.extras;

public class TwoSumN2 {
    public int[] twoSum(int[] nums, int target) {
        int numsLength = nums.length;
        for (int i = 1; i < numsLength; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
