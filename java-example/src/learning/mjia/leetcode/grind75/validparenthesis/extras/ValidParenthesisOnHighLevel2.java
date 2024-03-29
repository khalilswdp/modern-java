package learning.mjia.leetcode.grind75.validparenthesis.extras;

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
            } else if (isAMatchingClosingParen(characterQueue, c)) {
                characterQueue.pop();
            } else {
                return false;
            }
        }

        return characterQueue.isEmpty();
    }

    private static boolean isAMatchingClosingParen(Stack<Character> characterQueue, Character c) {
        return !characterQueue.isEmpty() && ((c == ')' && characterQueue.peek() == '(')
                || (c == ']' && characterQueue.peek() == '[')
                || (c == '}' && characterQueue.peek() == '{'));
    }
}
