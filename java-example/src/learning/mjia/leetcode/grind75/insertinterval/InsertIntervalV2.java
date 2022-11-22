package learning.mjia.leetcode.grind75.insertinterval;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervalV2 {
    public static void main(String[] args) {
        System.out.println(insert(new int[][] {
                new int[]{1,3},
                new int[]{6,9}},
                new int[] {2,5}));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<int[]>();
        int length = intervals.length;

        int i = 0;

        while (i < length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < length && intervals[i][0] <= newInterval[1] ) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        while (i < length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
