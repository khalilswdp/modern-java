package learning.mjia;

public class Example {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        int stringLength = s.length();

        if (numRows == 1 || stringLength <= numRows) {
            return s;
        }

        int zigZagLength = 2 * (numRows - 1);


        StringBuilder allRows = new StringBuilder(stringLength);
        for (int row = 0; row < numRows; row++) {
            for (int indexAtZig = row; indexAtZig < stringLength; indexAtZig += zigZagLength) {
                allRows.append(s.charAt(indexAtZig));
                int indexAtZag = indexAtZig + zigZagLength - 2 * row;
                if (!(row == 0 || row == numRows - 1 || indexAtZag >= stringLength)) {
                    allRows.append(s.charAt(indexAtZag));
                }
            }
        }
        return allRows.toString();

    }
}
