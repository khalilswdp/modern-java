package learning.mjia.leetcode.grind75.containsduplicate;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            int currentCount = count.getOrDefault(num, 0);
            if (currentCount > 0) {
                return true;
            }
            count.put(num, 1 + currentCount);
        }

        return false;
    }
}
