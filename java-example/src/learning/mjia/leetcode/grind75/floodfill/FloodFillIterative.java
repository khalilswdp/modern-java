package learning.mjia.leetcode.grind75.floodfill;

import java.util.ArrayDeque;
import java.util.Deque;

public class FloodFillIterative {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Can it be done with BFS?
        // iterative ?
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        Deque<int[]> pointsToChange = new ArrayDeque<>();
        pointsToChange.add(new int[] {sr, sc});

        while (!pointsToChange.isEmpty()) {
            int numberOfPoints = pointsToChange.size();
            for (int i = 0; i < numberOfPoints; i++) {
                int[] currentCoordinates = pointsToChange.pop();
                int srowCoordinate = currentCoordinates[0];
                int scolumnCoordinate = currentCoordinates[1];
                if (srowCoordinate >= 0 && srowCoordinate < image.length && scolumnCoordinate >= 0 && scolumnCoordinate < image[0].length && image[srowCoordinate][scolumnCoordinate] == originalColor) {
                    image[srowCoordinate][scolumnCoordinate] = color;
                    pointsToChange.add(new int[] {srowCoordinate + 1, scolumnCoordinate});
                    pointsToChange.add(new int[] {srowCoordinate, scolumnCoordinate + 1});
                    pointsToChange.add(new int[] {srowCoordinate - 1, scolumnCoordinate});
                    pointsToChange.add(new int[] {srowCoordinate, scolumnCoordinate - 1});

                }
            }
        }

        return image;
    }
}
