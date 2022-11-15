package learning.mjia.leetcode.grind75.validparenthesis;

import java.util.Stack;

public class ValidParenthesisOnHighLevel {

    public static void main(String[] args) {
        isValid("({[]})");
    }
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> characterQueue = new Stack<>();


        char[] chars = s.toCharArray();
        for (Character c: chars) {
            if (c == '(') {
                characterQueue.push(')');
            } else if (c == '{') {
                characterQueue.push('}');
            } else if (c == '[') {
                characterQueue.push(']');
            } else if (characterQueue.isEmpty() || c != characterQueue.pop()) {
                return false;
            }
        }

        return characterQueue.isEmpty();
    }
}
