package leetcode351_400;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yesongren on 2020/8/11
 * 394. Decode String
 */
public class DecodeString {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();

        // tail记录迄今位置访问到了哪个字符串
        StringBuilder tail = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // 如果当前遍历的字符为数字，将它加入numStack中（注意数字可能不止一位，所以还要向后判断）
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                // 得到重复次数，加入numStack中
                numStack.push(num);
            } else if (c == '[') {
                // 终止已经进入的所有StringBuilder
                strStack.push(tail.toString());
                tail = new StringBuilder();
            } else if (c == ']') {
                // 将numStack中最上放的元素取出，用于乘以重复次数
                StringBuilder tmp = new StringBuilder(strStack.pop());
                int repeatedTimes = numStack.pop();
                for (int j = 0; j < repeatedTimes; j++) {
                    tmp.append(tail);
                }
                // 别忘记将新的字符串赋值给tail
                tail = tmp;
            } else {
                tail.append(c);
            }
        }
        return tail.toString();
    }
}
