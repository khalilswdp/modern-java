package learning.mjia.leetcode.grind75.validparenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesisOnHighLevelGeneric2 {

    public static void main(String[] args) {
        isValid("({[]})");
    }
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> characterQueue = new Stack<>();

        Map<Character, Character> openToClosed = new HashMap<>();
        openToClosed.put('(', ')');
        openToClosed.put('{', '}');
        openToClosed.put('[', ']');

        char[] chars = s.toCharArray();
        for (Character c: chars) {
            if (openToClosed.containsKey(c)) {
                characterQueue.push(c);
            } else if (characterQueue.isEmpty() || (c != openToClosed.get(characterQueue.pop()))) {
                return false;
            }
        }

        return characterQueue.isEmpty();
    }
}
