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

        for (int i = 0; i < stringLength; i++) {
            for (int j = 0; j < numRows; j++) {
                if (isStringBelongToThisRow(i, j, numRows)) {
                    rows[j] += s.charAt(i);
                }
            }
        }

        return String.join("", rows);

    }

    private static boolean isStringBelongToThisRow(int index, int row, int numRows) {
        if (numRows == 2) return index % 2 == row;
        else {
            int zigZagLength = 2 * numRows - 2;
            int indexInZigZag = index % zigZagLength;

            if (indexInZigZag < numRows) {
                return indexInZigZag == row;
            }

            else {
                return row == (zigZagLength - indexInZigZag);
            }
        }
    }
}
