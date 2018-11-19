package leetcode001_050;

/**
 * Created by yesongren on 2018/11/19
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

public class AddTwoNumbers {
    /**
     * #002 Add Two Numbers
     *
     * Description:
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode result = newHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            int val = sum + carry;
            carry = val / 10;
            result.next = new ListNode(val % 10);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            result = result.next;
        }
        return newHead.next;
    }
}
