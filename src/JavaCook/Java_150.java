package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_150 {
    /**
     * @TimeComplexity O(N) N is the length of Array tokens
     * @SpaceComplexity O(N)
     */
    public int evalRPN_google_l4(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Deque<Integer> stack = new ArrayDeque<>();

        // Calculate
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(applyOperation(a, b, token));
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(token));
                    break;
                }

            }
        }

        return stack.pop();
    }

    private int applyOperation(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}