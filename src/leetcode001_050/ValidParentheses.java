package leetcode001_050;

import java.util.Stack;

/**
 * Created by yesongren on 2019/11/27
 * #020. Valid Parentheses
 */
public class ValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch =='[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char topchar = stack.pop();
                if (ch == ')' && topchar != '(') return false;
                if (ch == ']' && topchar != '[') return false;
                if (ch == '}' && topchar != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
