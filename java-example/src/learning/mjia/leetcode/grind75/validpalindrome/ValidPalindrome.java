package learning.mjia.leetcode.grind75.validpalindrome;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String stripped = clean(s);
        int length = stripped.length();
        for (int i = 0; i < length / 2; i++) {
            if (stripped.charAt(i) != stripped.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
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
