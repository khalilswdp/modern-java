package learning.mjia;

import java.util.Stack;

public class Example {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("){"));
        System.out.println(isValid("([}}])"));
        System.out.println(isValid("))"));
    }

    public static boolean isValid(String s) {
        int stringLength = s.length();
        if (stringLength < 2 || stringLength % 2 != 0) return false;

        Stack<Character> charToPop = new Stack<>();
        for (int index = 0; index < stringLength; index++) {
            char currentChar = s.charAt(index);
            if (currentChar == '{') {
                charToPop.push('}');
            } else if (currentChar == '('){
                charToPop.push(')');
            } else if (currentChar == '[') {
                charToPop.push(']');
            } else {
                if (charToPop.isEmpty()) {
                    return false;
                }
                if (charToPop.pop() != currentChar) {
                    return false;
                }
            }
        }

        return charToPop.isEmpty();
    }
}
