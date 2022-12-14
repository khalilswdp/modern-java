package learning.mjia.leetcode.grind75.floodfill;

import java.util.Stack;

public class FloodFillIterative {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Iteratively? In the four directions? Use a stack of points visited starting with the center?
        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        Stack<int[]> toFill = new Stack<>();
        toFill.push(new int[] { sr, sc });

        int length = image.length, width = image[0].length;
        while (!toFill.isEmpty()) {
            int[] current = toFill.pop();
            int x = current[0], y = current[1];
            if (x >= 0 && y >= 0 && x < length && y < width && image[x][y] == originalColor) {
                image[x][y] = color;
                toFill.push(new int[] { x + 1, y});
                toFill.push(new int[] { x, y + 1});
                toFill.push(new int[] { x - 1, y});
                toFill.push(new int[] { x, y - 1});
            }
        }

        return image;

    }
}
