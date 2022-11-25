package learning.mjia.leetcode.grind75.addbinary;

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] aChars = a.toCharArray(), bChars = b.toCharArray();
        StringBuilder result = new StringBuilder();
        int aLength = a.length(), bLength = b.length();
        boolean carry = false;

        int i = aLength - 1, j = bLength - 1;

        for (; carry || i >= 0 || j >= 0; i--, j--) {
            char aChar = i >= 0 ? aChars[i] : '0';
            char bChar = j >= 0 ? bChars[j] : '0';
            result.insert(0, addBinary(aChar, bChar, carry));
            carry = getCarry(aChar, bChar, carry);
        }

        return result.toString();
    }

    public char addBinary(char a, char b, boolean carry) {
        if (carry) {
            return a == b ? '1' : '0';
        } else {
            return a == b ? '0' : '1';
        }
    }

    public boolean getCarry(char a, char b, boolean carry) {
        if (carry) {
            return a == '1' || b == '1';
        } else {
            return a == '1' && b == '1';
        }
    }
}
