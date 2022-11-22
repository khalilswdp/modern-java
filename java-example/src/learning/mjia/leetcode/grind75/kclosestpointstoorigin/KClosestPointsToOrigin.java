package learning.mjia.leetcode.grind75.kclosestpointstoorigin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // add all points distances to the center in a dictionary/ArrayList:
        // where key is distance and value is the point
        Arrays.sort(points, (a, b) -> (int) (Math.sqrt(a[0] * a[0] + a[1] * a[1]) - Math.sqrt(b[0] * b[0] + b[1] *b[1])));
        // sort dictionary by distance and take first k distances
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(points[i]);
        }

        return result.toArray(new int[k][2]);
    }
}
