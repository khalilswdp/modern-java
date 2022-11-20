package learning.mjia.leetcode.grind75.validparenthesis;

import java.util.HashMap;
import java.util.Map;

public class ValidParenthesisOnLowLevelGenericX {

    public static void main(String[] args) {
        isValid("({[]})");
    }
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> openToClose = new HashMap<>();
        openToClose.put('{', '}');
        openToClose.put('(', ')');
        openToClose.put('[', ']');
        char[] characters = s.toCharArray();

        int current = 0;
        char[] toClose = new char[s.length()];
        for (char character: characters) {
            if (openToClose.containsKey(character)) {
                toClose[current] = character;
                current++;
            } else if (current == 0 || openToClose.get(toClose[--current]) != character) {
                return false;
            }
        }
        return current == 0;
    }
}
