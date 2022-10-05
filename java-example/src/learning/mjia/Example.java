package learning.mjia;

import java.util.Arrays;

public class Example {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        int stringLength = s.length();

        if (numRows == 1 || stringLength <= numRows) {
            return s;
        }

        String[] rows = new String[numRows];
        Arrays.fill(rows, "");
        int zigZagLength = 2 * (numRows - 1);

        // two possible alternatives (I watched 3 videos, and they're all equally inspiring)!
        // Loop through the rows! and within do some of your magic!
        // An alternative: just loop through the string and keep track of the row as you go (two approaches: boolean, or not/string builder)

        for (int row = 0; row < numRows; row++) {
            for (int indexAtZig = row; indexAtZig < stringLength; indexAtZig+= zigZagLength) {
                char[] currentRowAppend = new char[2];
                char characterInZig;
                characterInZig = s.charAt(indexAtZig);
                currentRowAppend[0] = characterInZig;
                if (!(row == 0 || row == numRows - 1)) {
                    int indexAtZag = indexAtZig + zigZagLength - 2 * row;
                    if (indexAtZag < stringLength) {
                        currentRowAppend[1] = s.charAt(indexAtZag);
                    }
                }
                rows[row] += new String(currentRowAppend).trim();
            }
        }
        return String.join("", rows);

    }
}
