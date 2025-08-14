package stack;

import java.util.*;

public class Question20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> leftBrackets = new HashSet<>(Arrays.asList('(', '[', '{'));
        Set<Character> rightBrackets = new HashSet<>(Arrays.asList(')', ']', '}'));
        for (char c : s.toCharArray()) {
            if (leftBrackets.contains(c)) {
                stack.addLast(c);
            } else {
                if (stack.isEmpty()) return false;
                char leftBracket = stack.pollLast();
                if (!check(leftBracket, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private boolean check(Character left, Character right) {
        return (left == '(' && right == ')') ||
               (left == '[' && right == ']') ||
               (left == '{' && right == '}');
    }
}
