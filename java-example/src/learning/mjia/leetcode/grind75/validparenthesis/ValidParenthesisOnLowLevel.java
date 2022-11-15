package learning.mjia.leetcode.grind75.validparenthesis;

public class ValidParenthesisOnLowLevel {

    public static void main(String[] args) {
        isValid("({[]})");
    }
    public static boolean isValid(String s) {
        int length = s.length();

        if (length % 2 != 0) {
            return false;
        }
        char[] stack = new char[length];
        char[] allCharacters = s.toCharArray();
        int current = 0;
        for (char aChar: allCharacters) {
            if (aChar == '{'|| aChar == '[' || aChar == '(') {
                stack[current] = aChar;
                current++;
            } else if (current > 0) {
                boolean locallyInvalid = ((aChar == '}' && stack[current-1] != '{')
                        || (aChar == ')' && stack[current-1] != '(')
                        || (aChar == ']' && stack[current-1] != '['));
                if (locallyInvalid) {
                    return false;
                }
                current--;
            } else {
                return false;
            }
        }
        return current == 0;
    }
}
