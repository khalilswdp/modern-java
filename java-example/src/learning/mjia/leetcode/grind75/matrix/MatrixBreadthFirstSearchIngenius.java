package learning.mjia.leetcode.grind75.matrix;

import java.util.ArrayDeque;
import java.util.Deque;

public class MatrixBreadthFirstSearchIngenius {
    public static void main(String[] args) {
        System.out.println(updateMatrix(new int[][]{
                new int[]{0,0,0},
                new int[]{0,1,0},
                new int[]{0,0,0}
        }));
    }

    public static int[][] updateMatrix(int[][] mat) {

        Deque<int[]> zeroCoordinates = new ArrayDeque<>();
        int length = mat.length;
        int width = mat[0].length;
        int[][] result = new int[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 0) {
                    zeroCoordinates.add(new int[] {i, j});
                }
                // or a set containing visited elements
                result[i][j] = -1;
            }
        }
        int distance = 0;
        while (!zeroCoordinates.isEmpty()) {
            int queueSize = zeroCoordinates.size();
            while (queueSize > 0) {
                int[] currentCoordinates = zeroCoordinates.pop();
                int x = currentCoordinates[0];
                int y = currentCoordinates[1];
                if (x >= 0 && x < length && y >= 0 && y < width && result[x][y] == -1) {
                    result[x][y] = distance;

                    zeroCoordinates.add(new int[] {x + 1, y});
                    zeroCoordinates.add(new int[] {x, y + 1});
                    zeroCoordinates.add(new int[] {x - 1, y});
                    zeroCoordinates.add(new int[] {x, y - 1});

                }
                queueSize--;
            }
            distance++;
        }
        return result;
    }
}
