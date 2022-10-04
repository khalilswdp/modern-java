package learning.mjia;

public class Example {

    public static void main(String[] args) {
         System.out.println(longestPalindrome("babad"));
         System.out.println(longestPalindrome("cbbd"));
         System.out.println(longestPalindrome("abb"));
         System.out.println(longestPalindrome("ccd"));
        // System.out.println(longestPalindrome("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"));
        System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    public static String longestPalindrome(String s) {

        int stringLength = s.length();

        if (stringLength < 2) {
            return s;
        }

        int currentMaxLength = 0;
        String maxPalindrome = "";

        for (int startIndex = 0; startIndex < stringLength; startIndex++) {
            int leftMost = startIndex;
            int rightMost = startIndex;

            // odd
            while (leftMost >= 0 && rightMost < stringLength && s.charAt(leftMost) == s.charAt(rightMost)) {
                if (rightMost - leftMost + 1 > currentMaxLength) {
                    maxPalindrome = s.substring(leftMost, rightMost + 1);
                    currentMaxLength = rightMost - leftMost + 1;
                }
                leftMost--;
                rightMost++;
            }

            leftMost = startIndex;
            rightMost = startIndex + 1;

            // even
            while (leftMost >= 0 && rightMost < stringLength && s.charAt(leftMost) == s.charAt(rightMost)) {
                if (rightMost - leftMost + 1 > currentMaxLength) {
                    maxPalindrome = s.substring(leftMost, rightMost + 1);
                    currentMaxLength = rightMost - leftMost + 1;
                }
                leftMost--;
                rightMost++;
            }
        }

        return maxPalindrome;
    }
}
