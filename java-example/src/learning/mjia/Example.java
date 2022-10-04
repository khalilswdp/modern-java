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

        if (isPalindrome(s)) {
            return s;
        }

        int stringLength = s.length();
        int currentMaxLength = 0;
        String maxPalindrome = "";

        for (int startIndex = 0; startIndex < stringLength; startIndex++) {
            int leftMost = startIndex;
            int rightMost = startIndex;

            // odd
            while (leftMost >= 0 && rightMost < stringLength && s.charAt(leftMost) == s.charAt(rightMost)) {
                if (rightMost - leftMost + 1 > currentMaxLength) {
                    String subString = s.substring(leftMost, rightMost + 1);
                    if (isPalindrome(subString)) {
                        currentMaxLength = subString.length();
                        maxPalindrome = subString;
                    }
                }
                leftMost--;
                rightMost++;
            }

            leftMost = startIndex;
            rightMost = startIndex + 1;

            // even
            while (leftMost >= 0 && rightMost < stringLength && s.charAt(leftMost) == s.charAt(rightMost)) {
                if (rightMost - leftMost + 1 > currentMaxLength) {
                    String subString = s.substring(leftMost, rightMost + 1);
                    if (isPalindrome(subString)) {
                        currentMaxLength = subString.length();
                        maxPalindrome = subString;
                    }
                }
                leftMost--;
                rightMost++;
            }
        }

        return maxPalindrome;
    }

    private static boolean isPalindrome(String subString) {
        int subStringLength = subString.length();
        if (subStringLength == 0 || subStringLength == 1) {
            return true;
        }
        else {
            boolean startAndEndMatch = subString.charAt(0) == subString.charAt(subStringLength - 1);
            String substringMinusStartAndEnd = subString.substring(1, subStringLength - 1);
            return startAndEndMatch && isPalindrome(substringMinusStartAndEnd);
        }
    }
}
