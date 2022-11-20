package learning.mjia.leetcode.grind75.twosum;

import java.util.HashMap;

public class TwoSumNX {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> leftToIndex = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            if (leftToIndex.containsKey(nums[index])) {
                return new int[] {index, leftToIndex.get(nums[index])};
            } else {
                leftToIndex.put(target - nums[index], index);
            }
        }
        return null;
    }
}
