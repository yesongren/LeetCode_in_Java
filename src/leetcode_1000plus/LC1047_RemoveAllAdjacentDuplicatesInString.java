package leetcode_1000plus;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yesongren on 2021/3/9
 * 1047. Remove All Adjacent Duplicates In String
 */
public class LC1047_RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        char[] chs = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : chs) {
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else if (stack.peek() == ch) {
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        for (char ch : stack) {
            res.append(ch);
        }
        return res.reverse().toString();
    }

    public String removeDuplicatesArray(String s) {
        char[] chs = s.toCharArray();
        int top = -1;
        for (int i = 0; i < chs.length; i++) {
            if (top == -1 || chs[i] != chs[top]) {
                chs[++top] = chs[i];
            } else {
                top--;
            }
        }
        return String.valueOf(chs, 0, top + 1);  // valueOf() 用法
    }
}
