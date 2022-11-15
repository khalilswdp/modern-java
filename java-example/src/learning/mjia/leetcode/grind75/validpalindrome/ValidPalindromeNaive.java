package learning.mjia.leetcode.grind75.validpalindrome;

public class ValidPalindromeNaive {
    public boolean isPalindrome(String s) {
        String stripped = clean(s);
        String strippedReversed = getReverse(stripped);
        return stripped.equals(strippedReversed);
    }

    private static String getReverse(String stripped) {
        byte[] strAsByteArray = stripped.getBytes();

        byte[] result = new byte[strAsByteArray.length];

        for (int i = 0; i < strAsByteArray.length; i++) {
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        }

        String strippedReversed = new String(result);
        return strippedReversed;
    }

    public String clean(String s) {
        StringBuilder result = new StringBuilder();
        for (Character c: s.toLowerCase().toCharArray()) {
            if ((c >= 'a' && c <= 'z' )||(c >= '0' && c <='9')) {
                result.append(c);
            } else if (c >= 'A' && c <= 'Z' ) {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }
}
