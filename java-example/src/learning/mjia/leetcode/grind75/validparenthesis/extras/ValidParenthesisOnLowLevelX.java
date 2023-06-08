package learning.mjia.leetcode.grind75.validparenthesis;

public class ValidParenthesisOnLowLevelX {

    public static void main(String[] args) {
        isValid("({[]})");
    }
    public static boolean isValid(String s) {
        int sLength = s.length();

        if (sLength % 2 != 0) {
            return false;
        }

        char[] sChar = s.toCharArray(), toValidate = new char[sLength];
        int count = 0;

        for (char c: sChar) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                    toValidate[count++] = c;
                    break;
                case '}':
                    if (count == 0 || toValidate[--count] != '{') {
                        return false;
                    }
                    break;
                case ')':
                    if (count == 0 || toValidate[--count] != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (count == 0 || toValidate[--count] != '[') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        return count == 0;
    }
}
