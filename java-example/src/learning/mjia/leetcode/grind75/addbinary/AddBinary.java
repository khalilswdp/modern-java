package learning.mjia.leetcode.grind75.addbinary;

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] aChars = a.toCharArray(), bChars = b.toCharArray();
        StringBuilder result = new StringBuilder();
        int aLength = a.length(), bLength = b.length();
        int carry = 0;

        int i = aLength - 1, j = bLength - 1;

        for (; carry != 0 || i >= 0 || j >= 0; i--, j--) {
            int aChar = i >= 0 ? aChars[i] - '0' : 0;
            int bChar = j >= 0 ? bChars[j] - '0' : 0;
            int sum = aChar + bChar + carry;
            result.insert(0, sum % 2);
            carry = sum > 1 ? 1 : 0;
        }

        //              carry = sum / 2;
        //        }
        //
        //        if (carry != 0) {
        //              result.insert(0, carry);
        //        }

        return result.toString();
    }
}
