package br.com.bravi;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Brackets {

    public static boolean isValid(String string) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {

            if (brackets.containsKey(string.charAt(i))) {
                stack.push(string.charAt(i));

            } else if ( brackets.containsValue(string.charAt(i))) {
                if (stack.isEmpty())
                    return false;
                if (brackets.get(stack.pop()) != string.charAt(i))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
