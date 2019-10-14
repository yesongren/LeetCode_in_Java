package leetcode151_200;

import java.util.Stack;

/**
 * Created by yesongren on 2019/10/14
 * LeetCode #169
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else if (stack.peek() == num) {
                stack.push(num);
            } else {
                stack.pop();
            }
        }
        return stack.peek();
    }

    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count++;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
