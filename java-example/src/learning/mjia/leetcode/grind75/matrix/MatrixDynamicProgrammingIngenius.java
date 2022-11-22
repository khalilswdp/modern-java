package learning.mjia.leetcode.grind75.matrix;

public class MatrixDynamicProgrammingIngenius {
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
        int moreThanMaxDistance = length + width;

        // We can do this without needing result. Just use mat! that's what the fastest solutions are doing
        // Improve this to reflect those findings
        int[][] result = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    int left = i > 0 ? result[i - 1][j] : moreThanMaxDistance;
                    int up = j > 0 ? result[i][j - 1] : moreThanMaxDistance;
                    result[i][j] = 1 + Math.min(left, up);
                }
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            for (int j = width - 1; j >= 0; j--) {
                int right = i < length - 1 ? result[i + 1][j] : moreThanMaxDistance;
                int down = j < width - 1 ? result[i][j + 1] : moreThanMaxDistance;
                result[i][j] = Math.min(result[i][j], 1 + Math.min(right, down));
            }
        }
        return result;
    }
}
