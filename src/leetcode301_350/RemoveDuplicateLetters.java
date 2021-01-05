package leetcode301_350;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yesongren on 2021/1/5
 * 316. Remove Duplicate Letters
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] chs = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[chs[i] - 'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            if (visited[chs[i] - 'a']) continue;
            while (!stack.isEmpty() && stack.peekLast() > chs[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                char top = stack.removeLast();
                visited[top - 'a'] = false;
            }
            stack.addLast(chs[i]);
            visited[chs[i] - 'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        for (char c : stack) {
            res.append(c);
        }
        return res.toString();
    }
}
