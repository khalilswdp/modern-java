package learning.mjia.leetcode.grind75.kclosestpointstoorigin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // Math.sqrt is unnecessary in our case because we already use integers,
        // so nothing below 0 that might mess up lt or gt signs
        // Sorting solution
        // VS
        // Heap solution?
        Arrays.sort(points, (a, b) -> {
            return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
        });

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(points[i]);
        }

        return result.toArray(new int[k][2]);
    }
}
