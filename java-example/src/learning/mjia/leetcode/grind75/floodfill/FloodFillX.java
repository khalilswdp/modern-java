package learning.mjia.leetcode.grind75.floodfill;

public class FloodFillX {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if (originalColor != color) {
            recursiveFill(image, sr, sc, image[sr][sc], color);
        }
        return image;
    }

    public void recursiveFill(int[][] image, int sr, int sc, int originalColor, int color) {
        int imageLength = image.length;
        int imageWidth = image[0].length;
        if (sr < 0 || sr > imageLength - 1 || sc < 0 || sc > imageWidth - 1) {
            return;
        }

        if (image[sr][sc] == originalColor) {
            image[sr][sc] = color;
            recursiveFill(image, sr + 1, sc, originalColor, color);
            recursiveFill(image, sr - 1, sc, originalColor, color);
            recursiveFill(image, sr, sc + 1, originalColor, color);
            recursiveFill(image, sr, sc - 1, originalColor, color);

        }
    }
}
