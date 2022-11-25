package learning.mjia.leetcode.grind75.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumNX {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> thisNumbersIndex = new HashMap<>();
        int i = 0;
        for (int num: nums) {
            if (thisNumbersIndex.containsKey(num)) {
                return new int[] {i, thisNumbersIndex.get(num)};
            }
            thisNumbersIndex.put(target - num, i);
            i++;
        }
        return null;
    }
}
