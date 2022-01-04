package Jan4;

import java.util.Deque;
import java.util.LinkedList;

class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                int num2 = stack.pop();
                int num1 = stack.pop();

                switch (s) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}