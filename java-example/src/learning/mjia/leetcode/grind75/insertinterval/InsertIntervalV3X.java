package learning.mjia.leetcode.grind75.insertinterval;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertIntervalV3X {
    public static void main(String[] args) {
        System.out.println(insert(new int[][] {
                new int[]{1,3},
                new int[]{6,9}},
                new int[] {2,5}));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int newArray[][] = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            newArray[i] = intervals[i];
        }
        newArray[intervals.length] = newInterval;
        Arrays.sort(newArray, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval: newArray ) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0])
                merged.add(interval);
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
