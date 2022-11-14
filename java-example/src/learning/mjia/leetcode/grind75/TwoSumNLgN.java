package learning.mjia.leetcode.grind75;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSumNLgN {
    public int[] twoSum(int[] nums, int target) {
        List<ArraySortedMapper> elements = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            elements.add(new ArraySortedMapper(i, nums[i]));
        }

        Collections.sort(elements);

        int minNumIndex = 0;
        int maxNumIndex = nums.length - 1;

        while (minNumIndex < maxNumIndex) {
            if (elements.get(minNumIndex).value + elements.get(maxNumIndex).value < target) {
                minNumIndex++;
            } else if (elements.get(minNumIndex).value + elements.get(maxNumIndex).value > target) {
                maxNumIndex--;
            } else {
                return new int[] {elements.get(minNumIndex).index, elements.get(maxNumIndex).index};
            }
        }

        return null;
    }

    static class ArraySortedMapper implements Comparable<ArraySortedMapper> {

        int index, value;

        ArraySortedMapper(int index, int value){
            this.index = index;
            this.value = value;
        }

        public int compareTo(ArraySortedMapper e) {
            return this.value - e.value;
        }
    }
}
