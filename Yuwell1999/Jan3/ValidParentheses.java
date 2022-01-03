package Jan3;

import java.util.Deque;
import java.util.LinkedList;

// 20
class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(')');
            } else if (c == '{') {
                stack.offerFirst('}');
            } else if (c == '[') {
                stack.offerFirst(']');
            } else if (stack.isEmpty() || stack.poll() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}