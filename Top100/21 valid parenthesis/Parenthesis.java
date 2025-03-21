
import java.util.*;

public class Parenthesis {

    public static void main(String[] args) {
        String p = "()()";
        System.out.println(validParenthesis(p));

    }

    public static boolean validParenthesis(String p) {
        Map<Character, Character> map = Map.of(
                '}', '{',
                ')', '(',
                ']', '['
        );

        Stack<Character> stack = new Stack<>();

        for (char c : p.toCharArray()) {
            if (map.containsValue(c)) {
                stack.push(c);
            } else if (map.containsKey(c)) {

                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
