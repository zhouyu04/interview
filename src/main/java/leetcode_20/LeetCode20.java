package leetcode_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode20 {

    private Map<Character, Character> mappings;

    public static void main(String[] args) {
        LeetCode20 leetCode20 = new LeetCode20();

        boolean valid = leetCode20.isValid("([{}])");
        System.out.println(valid);

    }


    public LeetCode20() {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (mappings.containsKey(c)) {

                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
