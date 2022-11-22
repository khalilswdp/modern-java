package learning.mjia.leetcode.grind75.insertinterval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        System.out.println(insert(new int[][] {
                new int[]{1,3},
                new int[]{6,9}},
                new int[] {2,5}));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int length = intervals.length;
        int count = 0;
        for (int[] interval: intervals) {
            if (newInterval[1] < interval[0]) {
                result.add(newInterval);
                for (int c = count; c < length; c++) {
                    result.add(intervals[c]);
                }
                return result.toArray(new int[result.size()][2]);
            } else if (newInterval[0] > interval[1]) {
                result.add(interval);
            } else {
                newInterval = new int[] { Math.min(newInterval[0], interval[0]), Math.max(newInterval[1], interval[1]) };
            }
            count++;
        }

        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }
}
