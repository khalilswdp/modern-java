package learning.mjia.leetcode.grind75.addbinary;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        int aLen = a.length(), bLen = b.length();
        char[] aChar = a.toCharArray(), bChar = b.toCharArray();

        int i = aLen - 1, j = bLen - 1;

        int carry = 0;

        for (; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int aInt = i >= 0 ? aChar[i] - '0' : 0;
            int bInt = j >= 0 ? bChar[j] - '0' : 0;
            carry = aInt + bInt + carry;
            res.insert(0, carry % 2);

            carry = carry / 2;
        }

        return res.toString();
    }
}
