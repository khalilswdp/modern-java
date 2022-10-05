package learning.mjia;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("){"));
        System.out.println(isValid("([}}])"));
        System.out.println(isValid("))"));
    }

    public static boolean isValid(String s) {
        int stringLength = s.length();
        if (stringLength == 0 || stringLength % 2 != 0) return false;

        List<Character> charToPop = new ArrayList<>();
        for (int index = 0; index < stringLength; index++) {
            char currentChar = s.charAt(index);
            int pendingParentsToClose = charToPop.size();
            if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                charToPop.add(currentChar);
            } else if ((pendingParentsToClose > 0)) {
                Character lastChar = charToPop.get(pendingParentsToClose - 1);
                if ((lastChar == '(' && currentChar == ')') || (lastChar == '[' && currentChar == ']') || (lastChar == '{' && currentChar == '}'))
                {
                    charToPop.remove(pendingParentsToClose - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return charToPop.size() == 0;
    }
}
