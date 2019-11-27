package leetcode401_450;

import java.util.Stack;

/**
 * Created by yesongren on 2019/11/26
 * #445. Add Two Numbers II
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null || l2 != null) {
            while (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }

        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int total = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + carry;
            carry = total / 10;
            total = total % 10;
            cur.next = new ListNode(total);
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return reverseList(pre.next);
    }

    public ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode pre = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
