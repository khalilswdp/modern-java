package learning.mjia.leetcode.grind75.validparenthesis;

import java.util.Stack;

public class ValidParenthesisOnHighLevel2 {

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
            if (c == '(' || c == '{' || c == '[') {
                characterQueue.push(c);
            } else if (!characterQueue.isEmpty() && ((c == ')' && characterQueue.peek() == '(')
                    || (c == ']' && characterQueue.peek() == '[')
                    || (c == '}' && characterQueue.peek() == '{'))) {
                characterQueue.pop();
            } else {
                return false;
            }
        }

        return characterQueue.isEmpty();
    }
}
