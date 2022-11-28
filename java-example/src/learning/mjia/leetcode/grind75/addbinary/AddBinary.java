package learning.mjia.leetcode.grind75.addbinary;

public class AddBinary {
    public String addBinary(String a, String b) {
        int aLen = a.length() - 1, bLen = b.length() - 1;
        StringBuilder res = new StringBuilder();

        char[] aCh = a.toCharArray(), bCh = b.toCharArray();
        int count = 0;
        for (; aLen > -1 || bLen > -1 || count != 0; aLen--, bLen--) {
            int left = aLen > -1 ? aCh[aLen] - '0' : 0;
            int right = bLen > -1 ? bCh[bLen] - '0' : 0;

            count = left + right + count;

            res.insert(0, count % 2);
            count = count / 2;
        }

        return res.toString();
    }
}
