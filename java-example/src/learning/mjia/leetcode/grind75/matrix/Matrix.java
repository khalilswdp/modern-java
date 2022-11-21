package learning.mjia.leetcode.grind75.matrix;

public class Matrix {
    public static void main(String[] args) {
        System.out.println(updateMatrix(new int[][]{
                new int[]{0,0,0},
                new int[]{0,1,0},
                new int[]{0,0,0}
        }));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int length = mat.length;
        int width = mat[0].length;
        int max = length * width;
        int[][] result = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = max;
            }
        }
        searchAround(mat, result, 0, 0);
        return result;
    }

    public static int searchAround(int[][] mat, int[][] result, int sr, int sc) {
        if (sr < 0 || sc < 0 || sr >= mat.length || sc >= mat[0].length) {
            return 10000;
        }
        if (mat[sr][sc] == 0) {
            result[sr][sc] = 0;
        } else {
            int distanceUp = searchAround(mat, result, sr - 1, sc);
            int distanceLeft = searchAround(mat, result, sr, sc - 1);
            result[sr][sc] = 1 + Math.min(distanceUp, distanceLeft);
        }

        return result[sr][sc];
    }

    public static int searchAroundReversed(int[][] mat, int[][] result, int sr, int sc) {
        if (sr < 0 || sc < 0 || sr >= mat.length || sc >= mat[0].length) {
            return 10000;
        }
        if (mat[sr][sc] != 0) {
            int distanceDown = searchAroundReversed(mat, result, sr + 1, sc);
            int distanceRight = searchAroundReversed(mat, result, sr, sc + 1);
            result[sr][sc] = Math.min(result[sr][sc], 1 + Math.min(distanceDown, distanceRight));
        }

        return result[sr][sc];
    }
}
