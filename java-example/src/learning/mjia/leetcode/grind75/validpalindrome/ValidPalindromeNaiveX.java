package learning.mjia.leetcode.grind75.validpalindrome;

public class ValidPalindromeNaiveX {
    public boolean isPalindrome(String s) {
        String normal = clean(s);
        String reverse = new StringBuilder(normal).reverse().toString();

        return normal.equals(reverse);
    }

    public String clean(String s) {
        StringBuilder sb = new StringBuilder();
        char[] sChar = s.toCharArray();

        for (char c: sChar) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }
}
