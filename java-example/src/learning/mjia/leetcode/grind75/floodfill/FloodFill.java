package learning.mjia.leetcode.grind75.floodfill;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            floodFillImage(image, sr, sc, image[sr][sc], color);
        }
        return image;
    }

    private void floodFillImage(int[][] image, int sr, int sc, int originalColor, int color) {
        // we can also do an if outside of image return; else, send problem to all 4 ways
        // if !(sr < 0 || sr >= imageRowLength || sc < 0 || sc >= image[0].length || image[sr][sc] != originalColor) {
        // And remove the inner ifs
        if (image[sr][sc] == originalColor) {
            image[sr][sc] = color;

            if (sr + 1 < image.length) {
                floodFillImage(image, sr + 1, sc, originalColor, color);
            }
            if (sc + 1 < image[0].length) {
                floodFillImage(image, sr, sc + 1, originalColor, color);
            }
            if (0 < sr) {
                floodFillImage(image, sr - 1, sc, originalColor, color);
            }
            if (0 < sc) {
                floodFillImage(image, sr, sc - 1, originalColor, color);
            }
        }
    }
}
