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
        int numberOfZigZags = (int) Math.ceil(((double) stringLength / zigZagLength));

        for (int zigZagNumber = 0; zigZagNumber < numberOfZigZags; zigZagNumber++) {
            int zigZagStart = zigZagNumber * zigZagLength;
            for (int row = 0; row < numRows && zigZagStart + row < stringLength; row++) {
                char[] currentRowAppend = new char[2];
                char characterInVerticalRow;
                int indexAtZig = zigZagStart + row;
                characterInVerticalRow = s.charAt(indexAtZig);
                currentRowAppend[0] = characterInVerticalRow;
                if (!(row == 0 || row == numRows - 1)) {
                    int indexAtZag = zigZagStart + zigZagLength - row;
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
